package com.dirty.word.filter.business.handler.impl;

import com.dirty.word.filter.business.exactor.HttpExactor;
import com.dirty.word.filter.business.parser.PageParse;
import com.dirty.word.filter.business.read.manage.CategoryReadManage;
import com.dirty.word.filter.business.write.manage.ItemWriteManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by shj on 2017/7/30.
 */
@Component
public class WebSchedule {
    @Autowired
    private ItemWriteManage itemWriteManage;

    @Autowired
    private CategoryReadManage categoryReadManage;

    @Autowired
    private PageParse pageParse;

    @Autowired
    private HttpExactor httpExactor;

    private ScheduledExecutorService service;

    @PostConstruct
    public void init(){
        System.out.println("爬虫开始");
        this.service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(new WebHandler(itemWriteManage,categoryReadManage,pageParse,httpExactor),5,60, TimeUnit.SECONDS);
    }
}
