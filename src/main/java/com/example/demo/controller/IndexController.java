package com.example.demo.controller;

import com.example.demo.po.AricleExtended;
import com.example.demo.po.Article;
import com.example.demo.po.PageModel;
import com.example.demo.service.ArticleMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private ArticleMapperService articleMapperService;

    /**
     * 首页
     * @param model   首页的数据添加到model
     * @return  返回首页视图
     * @throws Exception
     */
    @RequestMapping("/")
    public String index(Model model)throws Exception{
        List<AricleExtended> articles= articleMapperService.findNewArticle(0);
        model.addAttribute("articles",articles);
       PageModel pageModel=new PageModel(articleMapperService.countArticle(),1);
       System.out.println(pageModel.getMaxPage());
       model.addAttribute("page",pageModel);
        List<AricleExtended> clickarticles =articleMapperService.clickArticle();
        model.addAttribute("clicks",clickarticles);
        return "index";
    }

    /**
     * 分页
     * @param model
     * @param page
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/{page}"  )
    public String page(Model model,@PathVariable Integer page)throws Exception{
        List<AricleExtended> articles= articleMapperService.findNewArticle(((page*10)-10)<=0?0:((page*10)-10));
        model.addAttribute("articles",articles);
        PageModel pageModel=new PageModel(articleMapperService.countArticle(),page);
        model.addAttribute("page",pageModel);
        List<AricleExtended> clickarticles =articleMapperService.clickArticle();
        model.addAttribute("clicks",clickarticles);
        return "index";
    }




    /**
     * 打开登录页面
     * @return  登录页面
     */
    @RequestMapping("/login")
    public String login()throws Exception{

        return "login";
    }
}
