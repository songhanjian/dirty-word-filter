package com.dirty.word.filter.business.read.manage;

import com.dirty.word.filter.model.Item;

import java.util.List;

/**
 * Created by shj on 2017/7/30.
 */
public interface ItemReadManage {

    List<Item> queryAllItems()throws Exception;
    List<Item> queryItemByState(int state)throws Exception;
    List<Item> queryItemByStateAndCategory(int state,int categoryId)throws Exception;
    List<Item> queryItemByCategory(int categoryId)throws Exception;
}
