package com.example.demo.bean;

import java.util.Date;

/**
 * 用于判断两分钟内不能重复评论同一个完整
 *
 */
public class CommentDate {
    private int articleId;
    private Date date;

    public CommentDate(int articleId, Date date) {
        this.articleId = articleId;
        this.date = date;
    }

    public CommentDate() {
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
