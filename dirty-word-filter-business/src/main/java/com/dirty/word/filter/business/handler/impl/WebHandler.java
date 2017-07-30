package com.dirty.word.filter.business.handler.impl;

import com.dirty.word.filter.business.exactor.HttpExactor;
import com.dirty.word.filter.business.parser.PageParse;
import com.dirty.word.filter.business.read.manage.CategoryReadManage;
import com.dirty.word.filter.business.write.manage.ItemWriteManage;
import com.dirty.word.filter.model.Category;
import com.dirty.word.filter.model.Item;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by shj on 2017/7/30.
 */

public class WebHandler implements Runnable{


    private ItemWriteManage itemWriteManage;

    private CategoryReadManage categoryReadManage;


    private PageParse pageParse;

    private HttpExactor httpExactorm;

    private static Logger logger = Logger.getLogger(WebHandler.class);


    public WebHandler(ItemWriteManage itemWriteManage, CategoryReadManage categoryReadManage, PageParse pageParse, HttpExactor httpExactorm) {
        this.itemWriteManage = itemWriteManage;
        this.categoryReadManage = categoryReadManage;
        this.pageParse = pageParse;
        this.httpExactorm = httpExactorm;
    }

    public void run() {
        try {
            List<Category> categories = this.categoryReadManage.getAllCategories();
            for(Category c:categories){
                List<Item> items  =this.pageParse.htmlParse(this.httpExactorm.webExact(c.getUrl()+c.getParam()),c.getUrl(),c.getId());
                this.itemWriteManage.addItems(items);
            }

        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(),e);
        }
    }
}
