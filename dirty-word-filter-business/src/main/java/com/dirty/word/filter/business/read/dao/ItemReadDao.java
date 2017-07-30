package com.dirty.word.filter.business.read.dao;

import com.dirty.word.filter.model.Item;

import java.util.List;

/**
 * Created by shj on 2017/7/29.
 */
public interface ItemReadDao {
    List<Item> queryAllItems()throws Exception;
    List<Item> queryItemByState(int state)throws Exception;
    List<Item> queryItemByStateAndCategory(int state,int categoryId)throws Exception;
    List<Item> queryItemByCategory(int categoryId)throws Exception;
    boolean queryItemExist(int num)throws Exception;
}
