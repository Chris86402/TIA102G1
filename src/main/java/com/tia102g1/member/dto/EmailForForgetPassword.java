package com.tia102g1.member.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailForForgetPassword {

    @Autowired
    private JavaMailSender mailSender;


    public void sendPlainText(String receivers, String subject, String content) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(receivers);
        message.setSubject(subject);
        message.setText(content);
        message.setFrom("Desserter<desserter01@gmail.com>");

        mailSender.send(message);

    }


}


