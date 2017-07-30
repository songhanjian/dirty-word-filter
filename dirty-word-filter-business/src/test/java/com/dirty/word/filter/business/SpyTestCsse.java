package com.dirty.word.filter.business;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

/**
 * Created by shj on 2017/7/28.
 */
public class SpyTestCsse  {

    @Test
    public void testGetBBSPage()throws Exception{
        HttpClient httpClient= HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://bbs.xjtu.edu.cn/BMYAAWPIMEPZTNRDVNIZCZOXHGYDUNOYDRMM_B/home?B=XJTUnews");
        httpGet.setHeader("Host","bbs.xjtu.edu.cn");
        httpGet.setHeader("Connection","keep-alive");
        httpGet.setHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        httpGet.setHeader("User-Agent","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        httpGet.setHeader("Cookie","Hm_lvt_f6073ff592b43bb4250e644e2872692d=1500623241,1500626302,1500626587; CNZZDATA1254949650=808510368-1500620306-https%253A%252F%252Fwww.baidu.com%252F%7C1500627100; UM_distinctid=15d641d7f9e4e0-03579f603f23be-3f616948-13c680-15d641d7f9f73a");
        HttpResponse httpResponse = httpClient.execute(httpGet);
        System.out.println(httpResponse.getEntity().getContentLength());

    }

    public void TestUnicodeTransfer(){

    }

}
