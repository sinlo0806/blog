package com.example.demo.serviceImp;

import com.example.demo.mapper.CommentMapper;
import com.example.demo.po.CommentExtended;
import com.example.demo.service.CommentMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommentMapperServiceImp implements CommentMapperService{
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public void commentArticle(CommentExtended extended)throws Exception  {
        commentMapper.commentArticle(extended);
    }

    @Override
    public List<CommentExtended> selectComment(Integer id) {
        try {
return commentMapper.selectComment( id);
        }catch (Exception e)
        {
            return null;
        }

    }

    @Override
    public   void replyComment(CommentExtended commentExtended)throws Exception{

        commentMapper.replyComment(commentExtended);
    }
}
