package com.sadhwani.kubernetes.EmailService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @RequestMapping("/send")
    public String send(){
        User user = new User();
        user.setFirstName("steve");
        user.setLastName("sadhwani");
        user.setEmailAddress("stevensadh95@yahoo.com");

        try{
            emailService.sendEmail(user);

        }catch(MailException me){
            System.out.println(me.toString());
            return "failed";

        }
        return "success";
    }
}
