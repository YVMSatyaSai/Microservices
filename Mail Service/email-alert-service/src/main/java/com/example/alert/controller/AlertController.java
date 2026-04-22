package com.example.alert.controller;

import com.example.alert.service.EmailAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alert")
public class AlertController {

    @Autowired
    private EmailAlertService emailAlertService;

    @PostMapping("/email")
    public String sendEmailAlert() {
        emailAlertService.sendAlert("satyasai202402@gmail.com", "satyasai202402@gmail.com", "ASYNC ALERT", "This email was sent asynchronously");
        return "Email triggered Successfully";
    }

    @PostMapping("/Email")
    public String sendEmailAlert(@RequestBody SimpleMailMessage simpleMailMessage) {
        emailAlertService.sendAlerts(simpleMailMessage);
        return "Email triggered Successfully";
    }

    @PostMapping("/DBEmail")
    public String sendEmailAlerts() {
        emailAlertService.sendAlerting();
        return "Email triggered Successfully";
    }

}
