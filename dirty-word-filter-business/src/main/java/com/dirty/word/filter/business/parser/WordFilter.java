package com.dirty.word.filter.business.parser;

import java.util.List;

/**
 * Created by shj on 2017/7/29.
 */
public interface WordFilter {
    List<String> dirtyWordMatch(String str)throws Exception;
}
