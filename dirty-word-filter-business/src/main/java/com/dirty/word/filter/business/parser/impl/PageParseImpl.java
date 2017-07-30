package com.dirty.word.filter.business.parser.impl;

import com.dirty.word.filter.business.exactor.HttpExactor;
import com.dirty.word.filter.business.parser.PageParse;
import com.dirty.word.filter.business.parser.WordFilter;
import com.dirty.word.filter.business.util.HttpUtil;
import com.dirty.word.filter.model.Item;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shj on 2017/7/28.
 */
@Component
public class PageParseImpl implements PageParse {


    @Autowired
    private HttpExactor httpExactor;

    @Autowired
    private WordFilter wordFilter;


    public List<Item> htmlParse(String htmlStr,String url,int categoryId) throws Exception {
        List<Item> res = new ArrayList<Item>();
        Document document = Jsoup.parse(htmlStr);
        Elements elements =document.getElementsByAttributeValue("width","95%");
        if(elements.size()<2)
            return res;
        Elements children = elements.get(1).children().get(0).children();
        for(int i=1;i<children.size();i++){
            Elements tds = children.get(i).children();
            Item item = new Item();
            if(!HttpUtil.isNumeric(tds.get(0).text().trim()))
                break;
            item.setNum(Integer.parseInt(tds.get(0).text()));
            item.setAuthor(tds.get(2).text());
            if(tds.get(3).children().size()>0){
                item.setDate(HttpUtil.dateTransfer(tds.get(3).children().get(0).text()));
            }else {
                item.setDate(HttpUtil.dateTransfer(tds.get(3).text()));
            }
            Elements aTag = tds.get(4).getElementsByTag("a");

            if(!CollectionUtils.isEmpty(aTag)){
                String itmeUrl = url+aTag.get(0).attr("href");
//                item.setContent(itemHtmlParse(HttpUtil.httpGetExecute(HttpUtil.httpGetPackage(itmeUrl))));
                item.setContent(itemHtmlParse(this.httpExactor.itemWebExact(itmeUrl)));
            }
            item.setTopic(tds.get(4).text());
            item.setState(0);
            item.setCategoryId(categoryId);
            List<String> dirtyWords = this.wordFilter.dirtyWordMatch(item.getContent());
            System.out.println(dirtyWords);
            item.setDirtyWords(dirtyWords.toString().substring(1,dirtyWords.toString().length()-1));
            if(dirtyWords.size()>0){
                item.setState(1);
            }

            res.add(item);
        }
        return res;
    }

    private String itemHtmlParse(String htmlStr)throws Exception{
        Document document = Jsoup.parse(htmlStr);
        Element element = document.getElementById("filecontent");
        return element.ownText();
    }
}
