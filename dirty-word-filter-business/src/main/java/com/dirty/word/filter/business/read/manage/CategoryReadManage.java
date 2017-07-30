package com.dirty.word.filter.business.read.manage;

import com.dirty.word.filter.model.Category;

import java.util.List;

/**
 * Created by shj on 2017/7/30.
 */
public interface CategoryReadManage {

    public List<Category> getAllCategories()throws Exception;
}
