package com.project.pyg.web;

import java.io.File;
import java.io.IOException;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MailController {

    @Autowired
    private JavaMailSender javaMailSender;

    @GetMapping(value = "/mail")
    public void moveMail(){
        System.out.println("mail");
    }

    @GetMapping(value = "sendMail")
    public void sendMail(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {

            /*
             SimpleMailMessage message = new SimpleMailMessage();
             message.setFrom("");
             message.setTo("");
             message.setSubject("mail send test Subject");
             message.setText("mail send Test Test");
             javaMailSender.send(message);
             */

            MimeMessage mail = javaMailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo("");
            helper.setReplyTo("");
            helper.setFrom("");
            helper.setSubject("mail send Test Test");
            helper.setText("mail send Test Test");

            javaMailSender.send(mail);


        } catch(Exception e) {
            e.printStackTrace();
        }

        response.getWriter().print("success");
        
    }

    @GetMapping(value = "sendMailAndFile")
    public void sendMailAndFile(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {

            // 첨부파일 메일 보내기
            MimeMessage mail = javaMailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo("");
            helper.setReplyTo("");
            helper.setFrom("");
            helper.setSubject("mail send Test Subject");
            helper.setText("mail send Test Text");

            String fileName = "test.png";
            FileSystemResource file = new FileSystemResource(new File("C:/file/" + fileName));
            helper.addAttachment(fileName,  file);

            javaMailSender.send(mail);
            
            response.getWriter().print("seccessed mail sender");
            
            // 1. 첨부파일에 대한 사이즈 체크가 없다.
            // 2. 메일 발송 실패일 경우 유효성 체크가 없다.
            // 3. 파일 업로드 후 업로드한 파일을 발송하는 것을 구현한다.
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
