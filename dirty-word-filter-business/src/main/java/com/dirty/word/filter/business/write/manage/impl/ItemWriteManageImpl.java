package com.dirty.word.filter.business.write.manage.impl;

import com.dirty.word.filter.business.read.dao.ItemReadDao;
import com.dirty.word.filter.business.write.dao.ItemWriteDao;
import com.dirty.word.filter.business.write.manage.ItemWriteManage;
import com.dirty.word.filter.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shj on 2017/7/30.
 */
@Service
public class ItemWriteManageImpl implements ItemWriteManage {
    @Autowired
    private ItemWriteDao itemWriteDao;
    @Autowired
    private ItemReadDao itemReadDao;

    public void addItems(List<Item> items) throws Exception {
        for(Item i:items){
            if(!this.itemReadDao.queryItemExist(i.getNum()))
                this.itemWriteDao.insert(i);
        }
    }
}
