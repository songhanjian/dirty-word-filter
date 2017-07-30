package com.dirty.word.filter.business.read;

import com.dirty.word.filter.business.read.dao.CategoryReadDao;
import com.dirty.word.filter.business.read.dao.ItemReadDao;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shj on 2017/7/29.
 */
public class ItemReadDaoTestCase {

    private ItemReadDao itemReadDao;

    @Before
    public void init(){
        System.setProperty("global.config.path","/Users/shj/dev/env/env/env-dev");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("dirty-word-filter-business/spring-service.xml");
        this.itemReadDao = (ItemReadDao) applicationContext.getBean("itemReadDaoImpl");
    }

    @Test
    public void testQueryAllItems()throws Exception{
        System.out.println(this.itemReadDao.queryAllItems());
    }

    @Test
    public void testQueryItemByState()throws Exception{
        System.out.println(this.itemReadDao.queryItemByState(0));
    }

    @Test
    public void testQueryItemByCategory()throws Exception{
        System.out.println(this.itemReadDao.queryItemByCategory(3));
    }

    @Test
    public void testQueryItemByStateAndCategory()throws Exception{
        System.out.println(this.itemReadDao.queryItemByStateAndCategory(0,3));
    }


}
