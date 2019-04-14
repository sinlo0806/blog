package com.example.demo.controller;

import com.example.demo.bean.CommentDate;
import com.example.demo.config.MailService;
import com.example.demo.po.Comment;
import com.example.demo.po.CommentExtended;
import com.example.demo.service.CommentMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("comment")
public class CommentController {
@Autowired
private CommentMapperService commentMapperService;

@Autowired
private MailService mailService;

    /**
     * 博客评论
     * @param commentExtended  评论者的信息和评论内容
     * @param model
     * @param session
     * @return
     * @throws Exception
     */
       @RequestMapping("commentArticle")
    public String commentArticle(CommentExtended commentExtended, Model model,HttpSession session) throws Exception {
           /**
            * 使用HttpSession存储上一次评论时间,同一个HttpSession评论同文章需要间隔两分钟
            */
           model.addAttribute("id",commentExtended.getArticleid());
           if(session.getAttribute("CommentDate")==null||((CommentDate )session.getAttribute("CommentDate")).getArticleId()!=(int)commentExtended.getArticleid()||(((CommentDate)session.getAttribute("CommentDate")).getArticleId()==(int)commentExtended.getArticleid()
                   &&((CommentDate)session.getAttribute("CommentDate")).getDate().getTime()<=(System.currentTimeMillis()-(60*1000)))){
               session.setAttribute("CommentDate",new CommentDate(commentExtended.getArticleid(),new Date(System.currentTimeMillis())));
               commentExtended.setCreationdate(new Date());
               commentMapperService.commentArticle(commentExtended);

               return "SuccessfulComment";
           }else{

               return "CommentFailure";
           }


    }

    /**
     *     博客回复评论
     * @param commentExtended  评论者的信息和评论内容
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("replyComment")
    public String replyComment(CommentExtended commentExtended, Model model, HttpSession session) {
        commentExtended.setCreationdate(new Date());

        try {
            /**
             * 使用HttpSession存储上一次评论时间,同一个HttpSession评论同文章需要间隔两分钟
             */
            model.addAttribute("id",commentExtended.getArticleid());
            if(session.getAttribute("CommentDate1")==null||((CommentDate )session.getAttribute("CommentDate")).getArticleId()!=(int)commentExtended.getArticleid()||(((CommentDate)session.getAttribute("CommentDate1")).getArticleId()==(int)commentExtended.getArticleid()
                    &&((CommentDate)session.getAttribute("CommentDate1")).getDate().getTime()<=(System.currentTimeMillis()-(60*1000)))) {
                session.setAttribute("CommentDate1", new CommentDate(commentExtended.getArticleid(), new Date(System.currentTimeMillis())));
                commentMapperService.replyComment(commentExtended);
                mailService.sendHtmlMail(commentExtended.getResponderemail(), "博客回复", commentExtended.getUsername() + "在http://isin.win(罗东荣的博客)回复了您:<br>" + commentExtended.getCommentcontent());
            }else {
             return "CommentFailure";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "SuccessfulComment";
    }
     @RequestMapping("/leaveMeAMessage")
    public String  leaveMeAMessage(){

           return "leaveMeAMessage";
     }

    /**
     *      留言
     * @param commentExtended  留言内容
     * @return  返回首页
     */
     @RequestMapping("/SendMessage")
     public String SendMessage(CommentExtended commentExtended){

      try {

    mailService.sendHtmlMail("874471992@qq.com","博客留言","姓名:<br>"+commentExtended.getUsername()+" <br>邮箱:"+commentExtended.getEmail()+" <br> http:<br>"+commentExtended.getHttp()+"<br>给你留言:<br>"+commentExtended.getCommentcontent());
   }catch (Exception e)
  {

  }
         return "redirect:/";
     }
}
