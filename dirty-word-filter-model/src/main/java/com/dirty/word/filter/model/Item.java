package com.dirty.word.filter.model;

import java.util.Date;
import java.util.Arrays;

/**
 * Created by shj on 2017/7/28.
 */
public class Item {
    private int id;
    private int num;
    private int state;
    private String author;
    private Date date;
    private String topic;
    private String content;
    private String dirtyWords;
    private int categoryId;


    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", num=" + num +
                ", state=" + state +
                ", author='" + author + '\'' +
                ", date=" + date +
                ", topic='" + topic + '\'' +
                ", content='" + content + '\'' +
                ", dirtyWords='" + dirtyWords + '\'' +
                ", categoryId=" + categoryId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (id != item.id) return false;
        if (num != item.num) return false;
        if (state != item.state) return false;
        if (categoryId != item.categoryId) return false;
        if (author != null ? !author.equals(item.author) : item.author != null) return false;
        if (date != null ? !date.equals(item.date) : item.date != null) return false;
        if (topic != null ? !topic.equals(item.topic) : item.topic != null) return false;
        if (content != null ? !content.equals(item.content) : item.content != null) return false;
        return dirtyWords != null ? dirtyWords.equals(item.dirtyWords) : item.dirtyWords == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + num;
        result = 31 * result + state;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (topic != null ? topic.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (dirtyWords != null ? dirtyWords.hashCode() : 0);
        result = 31 * result + categoryId;
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDirtyWords() {
        return dirtyWords;
    }

    public void setDirtyWords(String dirtyWords) {
        this.dirtyWords = dirtyWords;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
