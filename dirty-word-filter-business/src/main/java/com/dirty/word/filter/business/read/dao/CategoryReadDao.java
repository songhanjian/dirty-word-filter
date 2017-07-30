package com.dirty.word.filter.business.read.dao;

import com.dirty.word.filter.model.Category;

import java.util.List;

/**
 * Created by shj on 2017/7/29.
 */
public interface CategoryReadDao {


    List<Category> queryAllCategories()throws Exception;
}
