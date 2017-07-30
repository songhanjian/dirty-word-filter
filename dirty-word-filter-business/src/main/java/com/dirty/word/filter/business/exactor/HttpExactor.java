package com.dirty.word.filter.business.exactor;

/**
 * Created by shj on 2017/7/28.
 */
public interface HttpExactor {

    String webExact(String url)throws Exception;
    String itemWebExact(String url)throws Exception;

}
