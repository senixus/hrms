package com.hrms.hrms.core.utilities.emailService;

import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailManager implements  EmailService{


    private JavaMailSender javaMailSender;

    @Autowired
    public EmailManager(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    @Override
    public Result sendEmail(String email) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("senius.33@gmail.com");
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject("Register");
        simpleMailMessage.setText("You have been registered successfully");
        this.javaMailSender.send(simpleMailMessage);

        return new SuccessResult("Email has been sent");
    }
}
