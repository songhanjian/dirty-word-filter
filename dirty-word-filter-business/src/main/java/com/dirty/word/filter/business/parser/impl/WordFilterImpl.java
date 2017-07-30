package com.dirty.word.filter.business.parser.impl;

import com.dirty.word.filter.business.parser.WordFilter;
import com.dirty.word.filter.model.WordTree;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.util.*;

/**
 * Created by shj on 2017/7/29.
 */
public class WordFilterImpl implements WordFilter {


    private Resource resource;
    private HashMap<String,WordTree> wordTree;

    @PostConstruct
    public void init()throws Exception{
        File file = resource.getFile();
        byte[] buffer =new byte[(int) file.length()];
        FileInputStream is =new FileInputStream(file);

        is.read(buffer, 0, buffer.length);

        is.close();
        String[] str = new String(buffer).split("|");
        this.wordTree = this.wordTreeBuild(str);
    }


    public HashMap<String,WordTree> wordTreeBuild(String[] str)throws Exception{
        HashMap<String,WordTree> res = new HashMap<String, WordTree>();
        if(str==null)
            return res;
        for(String s:str){
            s = s.replace(" ","").trim();
            String[] wordArray = s.split("");
            WordTree currentTree = null;
            if(wordArray.length<=0)
                continue;
            if(!res.containsKey(wordArray[0])){
                currentTree = new WordTree();
                if(wordArray.length==0){
                    currentTree.setIsEnd(true);
                }else {
                    currentTree.setIsEnd(false);
                }

                res.put(wordArray[0],currentTree);
            }else {
                currentTree =res.get(wordArray[0]);
                if(wordArray.length==0){
                    currentTree.setIsEnd(true);
                }else {
                    currentTree.setIsEnd(false);
                }
            }
            for(int i=1;i<wordArray.length;i++){
                if(currentTree.getWordTrees()==null){
                    HashMap<String,WordTree> childMap = new HashMap();
                    currentTree.setWordTrees(childMap);
                }
                if(currentTree.getWordTrees().containsKey(wordArray[i])){
                    currentTree = currentTree.getWordTrees().get(wordArray[i]);
                    if(i==wordArray.length-1){
                        currentTree.setIsEnd(true);
                    }else {
                        currentTree.setIsEnd(false);
                    }
                    continue;
                }
                WordTree child = new WordTree();
                if(i==wordArray.length-1){
                    child.setIsEnd(true);
                }else {
                    child.setIsEnd(false);
                }
                currentTree.getWordTrees().put(wordArray[i],child);
                currentTree = child;
            }



        }
        return res;
    }

    public List<String> dirtyWordMatch(String str)throws Exception{
        str = str.replace(" ","").trim();
        HashSet<String> res = new HashSet<String>();
        String[] strArray = str.split("");

        for(int i=0;i<strArray.length;i++){
            if(!this.wordTree.containsKey(strArray[i]))
                continue;
            StringBuilder temp = new StringBuilder();
            WordTree currentTree = this.wordTree.get(strArray[i]);
            if(currentTree.getIsEnd())
                res.add(new String(strArray[i]));
            if(currentTree.getWordTrees()==null)
                continue;
            temp.append(strArray[i]);
            for(int j=i+1;j<strArray.length;j++){
                if(currentTree.getWordTrees()==null)
                    break;
                if(!currentTree.getWordTrees().containsKey(strArray[j]))
                    break;
                temp.append(strArray[j]);
                currentTree = currentTree.getWordTrees().get(strArray[j]);
                if(currentTree.getIsEnd())
                    res.add(temp.toString());
            }
        }
        return new ArrayList<String>(res);
    }



    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }
}
