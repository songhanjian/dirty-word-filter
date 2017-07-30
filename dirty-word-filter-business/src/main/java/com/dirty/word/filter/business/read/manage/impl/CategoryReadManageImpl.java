package com.dirty.word.filter.business.read.manage.impl;

import com.dirty.word.filter.business.read.dao.CategoryReadDao;
import com.dirty.word.filter.business.read.manage.CategoryReadManage;
import com.dirty.word.filter.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shj on 2017/7/30.
 */
@Service
public class CategoryReadManageImpl implements CategoryReadManage {
    @Autowired
    private CategoryReadDao categoryReadDao;

    public List<Category> getAllCategories() throws Exception {
        return this.categoryReadDao.queryAllCategories();
    }
}
