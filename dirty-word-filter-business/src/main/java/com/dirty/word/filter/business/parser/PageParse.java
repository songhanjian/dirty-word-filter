package com.dirty.word.filter.business.parser;

import com.dirty.word.filter.model.Item;

import javax.swing.text.html.HTML;
import java.util.List;

/**
 * Created by shj on 2017/7/28.
 */
public interface PageParse {

    List<Item> htmlParse(String htmlStr,String url,int catgoryId)throws Exception;

}
