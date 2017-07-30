package com.dirty.word.filter.business.read.dao.impl;

import com.dirty.word.filter.business.read.dao.ItemReadDao;
import com.dirty.word.filter.model.Item;
import com.ibatis.sqlmap.client.SqlMapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shj on 2017/7/29.
 */
@Repository
public class ItemReadDaoImpl implements ItemReadDao {
    @Autowired
    @Qualifier(value = "sqlMapClientRead")
    private SqlMapClient sqlMapClient;

    public List<Item> queryAllItems() throws Exception {
        return this.sqlMapClient.queryForList("item_sqlMap.query_all");
    }

    public List<Item> queryItemByState(int state) throws Exception {
        return this.sqlMapClient.queryForList("item_sqlMap.query_by_state",state);
    }

    public List<Item> queryItemByCategory(int categoryId) throws Exception {
        return this.sqlMapClient.queryForList("item_sqlMap.query_by_category",categoryId);
    }

    public List<Item> queryItemByStateAndCategory(int state, int categoryId) throws Exception {
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("state",state);
        res.put("categoryId",categoryId);
        return this.sqlMapClient.queryForList("item_sqlMap.query_by_state_category",res);
    }

    public boolean queryItemExist(int num) throws Exception {
        int res =  (Integer) this.sqlMapClient.queryForObject("item_sqlMap.query_item_exist",num);
        if(res==0)
            return false;
        return true;
    }
}
