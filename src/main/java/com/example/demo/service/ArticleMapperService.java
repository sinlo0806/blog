package com.example.demo.service;

import com.example.demo.po.AricleExtended;
import com.example.demo.po.Article;
import com.example.demo.po.PageModel;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ArticleMapperService {
    List<Article> select() throws Exception;;
    Article findByIdArticle(Integer id ) throws Exception;;
    void addAticle(Article article) throws Exception;;
     List<AricleExtended> findNewArticle(Integer page) throws Exception;;
    void addviews(Integer id) throws Exception;
    List<AricleExtended> findArticleTitle(PageModel pageModel) throws Exception;
    Integer countArticle() throws Exception;
    Integer countArticleTitle(String title) throws Exception;
    List<AricleExtended> clickArticle() throws Exception;

    AricleExtended nextArticle(Integer id) throws Exception;
    AricleExtended previousArticle(Integer id) throws Exception;

}
