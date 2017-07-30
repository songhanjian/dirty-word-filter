package com.dirty.word.filter.business.util;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by shj on 2017/7/28.
 */
public class HttpUtil {

//    private static HttpClient httpClient = HttpClients.createDefault();


    private final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd HH:mm", Locale.ENGLISH);

    public static String httpGetExecute(HttpGet httpGet)throws Exception{
        HttpResponse httpResponse = HttpClients.createDefault().execute(httpGet);
        String res = "";
        String temp =null;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent(),"gb2312"));
        while ((temp=bufferedReader.readLine())!=null){
            res +=temp+"\n";
        }
        return res;
    }
    public static Date dateTransfer(String date)throws Exception{
        return simpleDateFormat.parse(date);
    }

    public static HttpGet httpGetPackage(String url)throws Exception{
        return new HttpGet(url);
    }

    public static HttpGet alterHttpGetPackage(String url,HttpGet httpGet)throws Exception{
        httpGet.setURI(new URI(url));
        return httpGet;
    }

    public static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }
}
