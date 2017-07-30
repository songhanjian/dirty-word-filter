package com.dirty.word.filter.business.parser;

import com.dirty.word.filter.business.parser.impl.WordFilterImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shj on 2017/7/29.
 */
public class WordFilterTestCase {

    private WordFilterImpl wordFilter;

    @Before
    public void init(){
        System.setProperty("global.config.path","/Users/shj/dev/env/env/env-dev");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("dirty-word-filter-business/spring-service.xml");
        this.wordFilter = (WordFilterImpl) applicationContext.getBean("wordFilterImpl");
    }


    @Test
    public void testWordTreeBuild()throws Exception{
        String[] str = {"我日你妈","我日","我操你妈","我操","你麻痹","你妈","你妈逼"};
        System.out.println(this.wordFilter.wordTreeBuild(str));
    }

}
