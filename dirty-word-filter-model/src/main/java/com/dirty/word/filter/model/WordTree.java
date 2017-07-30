package com.dirty.word.filter.model;

import java.util.HashMap;
import java.util.List;

/**
 * Created by shj on 2017/7/29.
 */
public class WordTree {
    private boolean isEnd;
    private HashMap<String,WordTree> wordTrees;

    @Override
    public String toString() {
        return "WordTree{" +
                "isEnd=" + isEnd +
                ", wordTrees=" + wordTrees +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WordTree wordTree = (WordTree) o;

        if (isEnd != wordTree.isEnd) return false;
        return wordTrees != null ? wordTrees.equals(wordTree.wordTrees) : wordTree.wordTrees == null;
    }

    @Override
    public int hashCode() {
        int result = (isEnd ? 1 : 0);
        result = 31 * result + (wordTrees != null ? wordTrees.hashCode() : 0);
        return result;
    }

    public boolean getIsEnd() {
        return isEnd;
    }

    public void setIsEnd(boolean end) {
        isEnd = end;
    }

    public HashMap<String, WordTree> getWordTrees() {
        return wordTrees;
    }

    public void setWordTrees(HashMap<String, WordTree> wordTrees) {
        this.wordTrees = wordTrees;
    }
}
