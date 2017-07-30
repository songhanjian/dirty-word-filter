package com.dirty.word.filter.business.read.dao.impl;

import com.dirty.word.filter.business.read.dao.CategoryReadDao;
import com.dirty.word.filter.model.Category;
import com.ibatis.sqlmap.client.SqlMapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by shj on 2017/7/29.
 */
@Repository
public class CategoryReadDaoImpl implements CategoryReadDao{

    @Autowired
    @Qualifier(value = "sqlMapClientRead")
    private SqlMapClient sqlMapClient;

    public List<Category> queryAllCategories() throws Exception {
        return this.sqlMapClient.queryForList("category_sqlMap.query_all_categories");
    }
}
