package com.dirty.word.filter.business.read;

import com.dirty.word.filter.business.parser.impl.WordFilterImpl;
import com.dirty.word.filter.business.read.dao.CategoryReadDao;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shj on 2017/7/29.
 */
public class CategoryReadDaoTestCase {

    private CategoryReadDao categoryReadDao;

    @Before
    public void init(){
        System.setProperty("global.config.path","/Users/shj/dev/env/env/env-dev");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("dirty-word-filter-business/spring-service.xml");
        this.categoryReadDao = (CategoryReadDao) applicationContext.getBean("categoryReadDaoImpl");
    }

    @Test
    public void testQueryAllCategories()throws Exception{

        System.out.println(this.categoryReadDao.queryAllCategories());
    }
}
