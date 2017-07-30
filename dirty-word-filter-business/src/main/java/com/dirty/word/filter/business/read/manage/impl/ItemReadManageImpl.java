package com.dirty.word.filter.business.read.manage.impl;

import com.dirty.word.filter.business.read.dao.ItemReadDao;
import com.dirty.word.filter.business.read.manage.ItemReadManage;
import com.dirty.word.filter.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shj on 2017/7/30.
 */
@Service
public class ItemReadManageImpl implements ItemReadManage{
    @Autowired
    private ItemReadDao itemReadDao;

    public List<Item> queryItemByStateAndCategory(int state, int categoryId) throws Exception {
        return this.itemReadDao.queryItemByStateAndCategory(state,categoryId);
    }

    public List<Item> queryItemByCategory(int categoryId) throws Exception {
        return this.itemReadDao.queryItemByCategory(categoryId);
    }

    public List<Item> queryItemByState(int state) throws Exception {
        return this.itemReadDao.queryItemByState(state);
    }

    public List<Item> queryAllItems() throws Exception {
        return this.itemReadDao.queryAllItems();
    }

}
