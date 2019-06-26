package com.wzszy.test;


import com.wzszy.BootApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootApplication.class)
public class MailTest {
    @Autowired
    private JavaMailSenderImpl mailSender;

    @Test
    public void testSendMessage1() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setText("hello Mail...");
        message.setTo("wzs_zy@163.com");
        message.setFrom("787315249@qq.com");
        mailSender.send(message);
    }

    /**
     * 发送带附件
     * @throws Exception
     */
    @Test
    public void testSendMessage2() throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true); // 参数 1： 内容， 参数 2：是 否HTML代码片段
        messageHelper.setText("<h1>美女</h1>", true);
        messageHelper.setTo("1094001688@qq.com");
        messageHelper.setFrom("787315249@qq.com"); // 上传文件
        messageHelper.addAttachment("1.jpg", new File("E:\\test_img\\头像4.jpg"));
        messageHelper.addAttachment("2.jpg", new File("E:\\test_img\\头像3.jpg"));
        messageHelper.addAttachment("3.jpg", new File("E:\\test_img\\头像1.jpg"));
        messageHelper.addAttachment("4.jpg", new File("E:\\test_img\\1111.jpg"));
        mailSender.send(mimeMessage);
    }
}

