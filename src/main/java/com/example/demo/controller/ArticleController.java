package com.example.demo.controller;

import com.example.demo.error.MyException;
import com.example.demo.mapper.ArticleMapper;
import com.example.demo.po.AricleExtended;
import com.example.demo.po.Article;
import com.example.demo.po.CommentExtended;
import com.example.demo.po.PageModel;
import com.example.demo.service.ArticleMapperService;
import com.example.demo.service.CommentMapperService;
import com.example.demo.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("article")
public class ArticleController {
    @Autowired
    private ArticleMapperService articleMapper;
    @Autowired
    private CommentMapperService commentMapperService;

    /**
     * 查看文章
     * @param id   根据博客的ID查询
     * @return   返回文章页面
     */

@RequestMapping("/{id}/blog")
    public String blog(Model model, @PathVariable("id") Integer id)throws Exception{

         Article article=articleMapper.findByIdArticle(id);

         if(article!=null){
             List<CommentExtended> commentList=commentMapperService.selectComment(article.getId());
             //访问量+1

             articleMapper.addviews(id);
             model.addAttribute("article",article);
             model.addAttribute("date", Utils.formatDate(article.getCreationdate()));
             model.addAttribute("commentList",commentList);
             List<AricleExtended> clickarticles =articleMapper.clickArticle();
             model.addAttribute("clicks",clickarticles);
              //上下一页
             model.addAttribute("next", articleMapper.nextArticle(id));
             model.addAttribute("previous", articleMapper.previousArticle(id));
             //redirect
             //forward
             return "article";
         }else {
            throw new MyException("404:你访问的页面不存在");
         }
    }

    /**
     * 查询文章
     * @param string  查询内容
     * @param model    把查询结果添加到Model
     * @return     返回视图
     * @throws Exception
     */
    @RequestMapping("/{string}/find/{page}")
public String findArticleTitle(@PathVariable("string") String string,@PathVariable("page") Integer page,Model model) throws Exception {
        System.out.println(page);
        PageModel pageModel=new PageModel();
        pageModel.setTitle(string);
        pageModel.setPage(page);
        pageModel.setIndexOf( ((page*10)-10)<=0?0:((page*10)-10));
      pageModel.setMaxCount(articleMapper.countArticleTitle(string));
       List<AricleExtended> list=articleMapper.findArticleTitle(pageModel);
        model.addAttribute("articles",list);
        model.addAttribute("page",pageModel);
        List<AricleExtended> clickarticles =articleMapper.clickArticle();
        model.addAttribute("clicks",clickarticles);

       return "find";
}



}
