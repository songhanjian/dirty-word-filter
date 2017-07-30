package com.dirty.word.filter.business.write.dao.impl;

import com.dirty.word.filter.business.write.dao.ItemWriteDao;
import com.dirty.word.filter.model.Item;
import com.ibatis.sqlmap.client.SqlMapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * Created by shj on 2017/7/29.
 */
@Repository
public class ItemWriteDaoImpl implements ItemWriteDao {

    @Autowired
    @Qualifier(value = "sqlMapClientWrite")
    private SqlMapClient sqlMapClient;

    public void insert(Item item) throws Exception {
        System.out.println(item);
        this.sqlMapClient.insert("item_sqlMap.insert_item",item);
    }
}
