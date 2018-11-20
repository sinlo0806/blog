package com.example.demo.error;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class MyHandlerExceptionResolver// implements HandlerExceptionResolver
{
    @Nullable
 //   @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @Nullable Object o, Exception e) {
    //handler就是处理器适配器要执行Handler对象（只有method）
   // 解析出异常类型
   // 如果该 异常类型是系统 自定义的异常，直接取出异常信息，在错误页面展示
        MyException myException = null;
        if(e instanceof MyException){
            myException = (MyException)e ;
        }else{
            myException = new MyException("未知错误");
        }
       //错误信息
        String message = myException.getMessage();
        ModelAndView modelAndView = new ModelAndView();
     //将错误信息传到页面
        modelAndView.addObject("message", message);
     //指向错误页面'
        modelAndView.setViewName("error");

        return modelAndView;
    }
}
