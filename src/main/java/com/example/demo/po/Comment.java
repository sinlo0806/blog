package com.example.demo.po;

import java.util.Date;

public class Comment {
    private Integer id;

    private String username;
    private String email;
    private String http;

    private String commentcontent;

    private Integer articleid;

    private Date creationdate;

    private Integer responderid;

    private String responderemail;

    private String respondereanme;
    public String getHttp() {
        return http;
    }

    public void setHttp(String http) {
        this.http = http;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getCommentcontent() {
        return commentcontent;
    }

    public void setCommentcontent(String commentcontent) {
        this.commentcontent = commentcontent == null ? null : commentcontent.trim();
    }

    public Integer getArticleid() {
        return articleid;
    }

    public void setArticleid(Integer articleid) {
        this.articleid = articleid;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Integer getResponderid() {
        return responderid;
    }

    public void setResponderid(Integer responderid) {
        this.responderid = responderid;
    }

    public String getResponderemail() {
        return responderemail;
    }

    public void setResponderemail(String responderemail) {
        this.responderemail = responderemail == null ? null : responderemail.trim();
    }

    public String getRespondereanme() {
        return respondereanme;
    }

    public void setRespondereanme(String respondereanme) {
        this.respondereanme = respondereanme == null ? null : respondereanme.trim();
    }
}