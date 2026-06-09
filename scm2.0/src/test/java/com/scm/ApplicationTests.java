package com.scm;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;


import com.scm.services.EmailService;

@SpringBootTest
class ApplicationTests {

	@Autowired
    private EmailService service;

    @Test
    void sendEmailTest() {
        service.sendEmail(
            "parvagr1@gmail.com",
            "Just testing email service",
            "this is scm project working"
        );

	}



}



