package com.example.alert.service;

import com.example.alert.entity.EmailAlertEntity;
import com.example.alert.repository.EmailAlertRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailAlertService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private EmailAlertRepository emailAlertRepository;

    @Async
    public void sendAlert(String to, String cc, String subject, String message) {
        try {
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setTo(to);
            mail.setCc(cc);
            mail.setSubject(subject);
            mail.setText(message);

            mailSender.send(mail);
        } catch (Exception e) {
            System.err.println("Email sending failed: " + e.getMessage());
        }
    }

    public void sendAlerts(SimpleMailMessage mailMessage) {
        try {
            mailSender.send(mailMessage);
        } catch (Exception e) {
            System.out.println("Email sending failed : " + e.getMessage());
        }
    }

    @Transactional
    public void sendAlerting() {

        List<EmailAlertEntity> alerts = emailAlertRepository.findByFlag("Y");

        for (EmailAlertEntity emailAlert : alerts) {

            try {
                SimpleMailMessage mailMessage = new SimpleMailMessage();

                mailMessage.setTo(emailAlert.getToEmail());
                mailMessage.setSubject(emailAlert.getSubject());
                mailMessage.setText(emailAlert.getMessage());

                if (emailAlert.getCcEmail() != null && !emailAlert.getCcEmail().isBlank()) {
                    mailMessage.setCc(emailAlert.getCcEmail());
                }

                mailSender.send(mailMessage);

                emailAlert.setStatus("SENT");
                emailAlert.setFlag("N");

                emailAlertRepository.save(emailAlert);
                System.out.println("EMAIL SENT TO : " + emailAlert.getToEmail());

            } catch (Exception e) {
                emailAlert.setStatus("FAILED");
                emailAlertRepository.save(emailAlert);
            }
        }
    }
}
