package com.dirty.word.filter.business.write;

import com.dirty.word.filter.business.read.dao.ItemReadDao;
import com.dirty.word.filter.business.write.dao.ItemWriteDao;
import com.dirty.word.filter.model.Item;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by shj on 2017/7/29.
 */
public class ItemWriteDaoTestCase {

   private ItemWriteDao itemWriteDao;

    @Before
    public void init(){
        System.setProperty("global.config.path","/Users/shj/dev/env/env/env-dev");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("dirty-word-filter-business/spring-service.xml");
        this.itemWriteDao = (ItemWriteDao) applicationContext.getBean("itemWriteDaoImpl");
    }

    @Test
    public void testInsert()throws Exception{
        Item item = new Item();
        item.setNum(23);
        item.setState(0);
        item.setContent("yesyes");
        item.setDirtyWords("sdfisef");
        item.setDate(new Date());
        item.setAuthor("sefesfew");
        item.setCategoryId(3);
        item.setTopic("lalal");
        this.itemWriteDao.insert(item);

    }
}
