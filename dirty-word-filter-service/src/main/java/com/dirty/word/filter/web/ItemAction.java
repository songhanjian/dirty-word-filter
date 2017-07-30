package com.dirty.word.filter.web;

import com.dirty.word.filter.business.read.manage.ItemReadManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by shj on 2017/7/30.
 */
@Controller
@RequestMapping(value = "/item")
public class ItemAction {


    @Autowired
    private ItemReadManage itemReadManage;

    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public @ResponseBody Object itemQuery(@RequestParam(value = "state",required = false) Integer state, @RequestParam(value = "categoryId",required = false) Integer categoryId)throws Exception{
        System.out.println(state);
        System.out.println(categoryId);
        if(state==null&&categoryId==null)
            return this.itemReadManage.queryAllItems();
        else if(state==null&&categoryId!=null)
            return this.itemReadManage.queryItemByCategory(categoryId);
        else if(state!=null&&categoryId==null)
            return this.itemReadManage.queryItemByState(state);
        else return this.itemReadManage.queryItemByStateAndCategory(state,categoryId);
    }

}
