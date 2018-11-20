package com.example.demo.serviceImp;

import com.example.demo.mapper.ArticleMapper;
import com.example.demo.po.AricleExtended;
import com.example.demo.po.Article;
import com.example.demo.po.PageModel;
import com.example.demo.service.ArticleMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * @author hello
 */
@Component
public class ArticleMapperServiceImp implements ArticleMapperService {
    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public List<Article> select()throws Exception
    {
        return articleMapper.select();
    }

    @Override
    public Article findByIdArticle(Integer id)throws Exception {
        return articleMapper.findByIdArticle(id);
    }

    @Override
    public void addAticle(Article article)throws Exception {
        articleMapper.addAticle(article);
    }

    @Override
    public List<AricleExtended> findNewArticle(Integer page)throws Exception {
        return articleMapper.findNewArticle(page);
    }

    @Override
    public void addviews(Integer id)throws Exception {
        articleMapper.addviews(id);
    }
    @Override
    public  List<AricleExtended> findArticleTitle(PageModel pageModel) throws Exception{

        return articleMapper.findArticleTitle(pageModel);
    }

    @Override
    public Integer countArticle() throws Exception {
        return articleMapper.countArticle();
    }
    @Override
    public   Integer countArticleTitle(String title) throws Exception{

        return articleMapper.countArticleTitle(title);
    }
    @Override
    public  List<AricleExtended> clickArticle() throws Exception{
        return articleMapper.clickArticle();
    }

    @Override
    public AricleExtended nextArticle(Integer id) throws Exception {
        return articleMapper.nextArticle(id);
    }

    @Override
    public AricleExtended previousArticle(Integer id) throws Exception {
        return articleMapper.previousArticle(id);
    }
}
