package com.dirty.word.filter.business.exactor;

import com.dirty.word.filter.business.exactor.impl.HttpExactorImpl;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

/**
 * Created by shj on 2017/7/28.
 */
public class HttpExactorTestCase {
    @Test
    public void testWebExact()throws Exception{
        String url = "http://bbs.xjtu.edu.cn/BMYAAWPIMEPZTNRDVNIZCZOXHGYDUNOYDRMM_B/home?B=XJTUnews";
        System.out.println(new HttpExactorImpl().webExact(url));
    }

}
