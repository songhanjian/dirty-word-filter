package com.dirty.word.filter.business.write.dao;

import com.dirty.word.filter.model.Item;

/**
 * Created by shj on 2017/7/29.
 */
public interface ItemWriteDao {

    void insert(Item item)throws Exception;
}
