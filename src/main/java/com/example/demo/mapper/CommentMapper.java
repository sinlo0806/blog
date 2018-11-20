package com.example.demo.mapper;

import com.example.demo.po.Comment;

import java.util.List;

import com.example.demo.po.CommentExtended;
import org.apache.ibatis.annotations.Param;

public interface CommentMapper {
void commentArticle(CommentExtended extended) throws Exception;
List<CommentExtended> selectComment(Integer id) throws Exception;
void replyComment(CommentExtended commentExtended)throws Exception;
}