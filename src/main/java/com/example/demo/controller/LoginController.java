package com.example.demo.controller;

import com.example.demo.po.User;
import com.example.demo.service.UserMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("login")
public class LoginController {
    @Autowired
private UserMapperService userMapperService;

    /**
     * 登录校验
     * @param user   前台传过来的登录信息
     * @param session   登录成功把信息存到HttpSession
     * @return    登录结果  y:成功  n:失败
     */
    @RequestMapping("Verification")
    public @ResponseBody String Verification(User user, HttpSession session)throws Exception{

     if(userMapperService.userIsExist(user)){
         session.setAttribute("user",user);
        return "y";
     }

        return "n";
    }

    /**
     * 判断是否已经登录
     * @param session   从session获取已登录用户信息
     * @return      已登录返回y反之亦然
     * @throws Exception
     */
    @RequestMapping("IsLogin")
    public @ResponseBody String IsLogin( HttpSession session)throws Exception{
        if(session.getAttribute("user")==null){
            return "n";
        }
        return "y";
    }


}
