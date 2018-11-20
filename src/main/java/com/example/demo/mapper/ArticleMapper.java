package com.example.demo.mapper;

import com.example.demo.po.AricleExtended;
import com.example.demo.po.Article;
import com.example.demo.po.ArticleExample;
import com.example.demo.po.PageModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleMapper {
    /**
     *  查询全部
     * @return 查询结果
     * @throws Exception
     */
    List<Article> select() throws Exception;

    /**
     * 根据id查询Article
     * @param id
     * @return  查询结果
     * @throws Exception
     */
    Article findByIdArticle(Integer id) throws Exception;;

    /**
     * 添加article
     * @param article   被添加的article
     * @throws Exception
     */
    void addAticle(Article article) throws Exception;;

    /**
     *  显示最新的article
     *  @param page  第几页10就是第二页,20就是第三页
     * @return  返回最新的十条article
     * @throws Exception
     */
     List<AricleExtended> findNewArticle(Integer page) throws Exception;;

    /**
     *  增加阅读量
     * @param id
     * @throws Exception
     */
     void addviews(Integer id) throws Exception;;

    /**
     * 搜索文章
     * @param pageModel   搜索内容
     * @return   搜索结果
     * @throws Exception
     */
     List<AricleExtended> findArticleTitle(PageModel pageModel) throws Exception;

    /**
     * 统计文章数量
     * @return   文章数量
     * @throws Exception
     */
     Integer countArticle() throws Exception;

     Integer countArticleTitle(String title) throws Exception;
     List<AricleExtended> clickArticle() throws Exception;

     AricleExtended nextArticle(Integer id) throws Exception;
    AricleExtended previousArticle(Integer id) throws Exception;
}