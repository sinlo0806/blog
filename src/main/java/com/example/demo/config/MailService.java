package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

@Component
/**
 *  spring boot提供了基于类型安全的配置方式,通过@ConfigurationProperties和PropertySource将properties
 *  属性和一个bean及其属性关联、从而实现类型安全的配置。
 */
//加载properties
@PropertySource("classpath:/config/email.properties")
//通过prefix指定properties中的前缀
@ConfigurationProperties(prefix = "email")
public class MailService {
    private   String host = null;
    private   Integer port = null;
    private   String userName = null;
    private   String password = null;
    private   String emailform = null;
    /**
     * 邮件发送器
     *
     * @return 配置好的工具
     */
    private  JavaMailSenderImpl createMailSender() {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
System.out.println(host);
        sender.setHost(host);
        sender.setPort(port);
        sender.setUsername(userName);
        sender.setPassword(password);
        sender.setDefaultEncoding("Utf-8");
        Properties p = new Properties();
        p.setProperty("mail.smtp.timeout", "25000");
        p.setProperty("mail.smtp.auth", "false");
        sender.setJavaMailProperties(p);
        return sender;
    }


    /**
     * 发送邮件
     *
     * @param to 接收人
     * @param subject 邮件主题
     * @param html 发送内容
     * @throws MessagingException 异常
     * @throws UnsupportedEncodingException 异常
     */
    public  void sendHtmlMail(String to, String subject, String html) throws MessagingException,UnsupportedEncodingException {
        JavaMailSenderImpl mailSender = createMailSender();;
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        // 设置utf-8,否则邮件会有乱码
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        messageHelper.setFrom(emailform, "博客回复");
        messageHelper.setTo(to);
        messageHelper.setSubject(subject);
        messageHelper.setText(html, true);
       /* //使用Spring的FileSystemResource来加载附件
        FileSystemResource image = new FileSystemResource("D:\\img.jpg");
        //添加附件,第一个为附件名称
        messageHelper.addAttachment("img.jpg",image);*/
        MailService mailService=new MailService();
        mailSender.send(mimeMessage);
        System.out.println("发送成功");
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailform() {
        return emailform;
    }

    public void setEmailform(String emailform) {
        this.emailform = emailform;
    }

}