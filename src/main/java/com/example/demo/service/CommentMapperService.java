package com.example.demo.service;

import com.example.demo.po.CommentExtended;

import java.util.List;

public interface CommentMapperService {
    void commentArticle(CommentExtended extended) throws Exception;
    List<CommentExtended> selectComment(Integer id) throws Exception;
    void replyComment(CommentExtended commentExtended)throws Exception;
}
