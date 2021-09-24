package com.asyncronoustasks;

import com.sun.xml.internal.org.jvnet.mimepull.MIMEMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class AsyncronousTasksApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    void contextLoads() {
        //一个简单的邮件
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("你好啊~");
        mailMessage.setText("123456");
        mailMessage.setFrom("3060529292@qq.com");//发件人
        mailMessage.setTo("zjbin123@163.com","3554572522@qq.com");//收件人
        //mailMessage.setTo("3554572522@qq.com");
        mailSender.send(mailMessage);

    }
    @Test
    void contextLoads2() throws MessagingException {
        //一个复杂的邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //组装
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);

        //正文
        helper.setSubject("你好，朋友");
        helper.setText("<p style='color:red'>谢谢你的课程<p/>",true);

        //附件
        helper.addAttachment("1.jpg",new File("E:\\学习资源\\1.jpg"));
        helper.addAttachment("科比高清图片.jpg",new File("E:\\学习资源\\科比高清图片.jpg"));

        helper.setFrom("3060529292@qq.com");//发件人
        helper.setTo("2897612087@qq.com");//收件人


        mailSender.send(mimeMessage);

    }

    /**
     *
     * @param html:是否为html
     * @param subject:正文
     * @param text：文本
     * @throws MessagingException
     * @Author zj970
     */

    //封装方法
    public void SendMail(boolean html,String subject,String text) throws MessagingException {
        //一个复杂的邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //组装
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,html);

        //正文
        helper.setSubject(subject);
        helper.setText("<p style='color:red'>谢谢你的课程<p/>",html);

        //附件
        helper.addAttachment("1.jpg",new File("E:\\学习资源\\1.jpg"));
        helper.addAttachment("科比高清图片.jpg",new File("E:\\学习资源\\科比高清图片.jpg"));

        helper.setFrom("3060529292@qq.com");//发件人
        helper.setTo("2897612087@qq.com");//收件人


        mailSender.send(mimeMessage);
    }
}
