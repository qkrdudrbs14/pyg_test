package com.project.pyg.web;

import java.io.File;
import java.io.IOException;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
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

            // ???????????? ?????? ?????????
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
            
            // 1. ??????????????? ?????? ????????? ????????? ??????.
            // 2. ?????? ?????? ????????? ?????? ????????? ????????? ??????.
            // 3. ?????? ????????? ??? ???????????? ????????? ???????????? ?????? ????????????.
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
