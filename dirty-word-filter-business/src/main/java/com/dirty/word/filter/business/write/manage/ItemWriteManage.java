package com.dirty.word.filter.business.write.manage;

import com.dirty.word.filter.model.Item;

import java.util.List;

/**
 * Created by shj on 2017/7/30.
 */
public interface ItemWriteManage {
    void addItems(List<Item> items)throws Exception;
}
