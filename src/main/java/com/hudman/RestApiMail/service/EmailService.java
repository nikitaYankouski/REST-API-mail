package com.hudman.RestApiMail.service;

import com.hudman.RestApiMail.entity.MessageEntityMagicNumber;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {

    private JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendMail(String toEmail, String subject, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setTo(toEmail);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);

        mailMessage.setFrom("nikita@example.com");

        javaMailSender.send(mailMessage);
    }

    public void sendListMail(List<MessageEntityMagicNumber> messageEntityList) {
        messageEntityList.forEach(
                value->sendMail(value.getEmail(), value.getTitle(), value.getContent())
        );
    }
}
