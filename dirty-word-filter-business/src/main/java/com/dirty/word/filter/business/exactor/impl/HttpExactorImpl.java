package com.dirty.word.filter.business.exactor.impl;

import com.dirty.word.filter.business.exactor.HttpExactor;
import com.dirty.word.filter.business.util.HttpUtil;
import org.apache.http.client.methods.HttpGet;
import org.springframework.stereotype.Component;

import java.net.URI;

/**
 * Created by shj on 2017/7/28.
 */
@Component
public class HttpExactorImpl implements HttpExactor{


    private HttpGet httpGet;

    public String webExact(String url) throws Exception {
        HttpGet httpGet = HttpUtil.httpGetPackage(url);
        return new String(HttpUtil.httpGetExecute(httpGet).getBytes(),"utf-8");
    }

    public String itemWebExact(String url)throws Exception{
        if(httpGet==null){
            this.httpGet =  new HttpGet(url);
        }else {
            this.httpGet.setURI(new URI(url));
        }
        return new String(HttpUtil.httpGetExecute(this.httpGet).getBytes(),"UTF-8");
    }




}
