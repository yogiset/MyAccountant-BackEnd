package com.example.MyAccountantBackEnd.service.mail;


import com.example.MyAccountantBackEnd.entity.User;
import com.example.MyAccountantBackEnd.jwt.JwtUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


@Service
@AllArgsConstructor
@Slf4j
public class MailService {

    private final JavaMailSender mailSender;
    private final MailContentBuilder mailContentBuilder;
    private  final JwtUtil jwtUtil;


    @Async
    public void sendActivationEmail(User user) {
        log.info("inside sendActivationEmail");
        String token = jwtUtil.generateToken(user.getEmail(), user.getRole(), user.getName());
        String verificationUrl = "https://myaccountant-backend-production.up.railway.app/user/register/accountVerification/" + token;
        String loginUrl = "https://myaccounta-n.vercel.app/login";

        String subject = "Please Activate your Account";

        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
            messageHelper.setFrom("MyAccountant@gmail.com");
            messageHelper.setTo(user.getEmail());
            messageHelper.setSubject(subject);
            String htmlMsg = "<p><b>Thank you for signing up to Myaccountant</b></p>" +
                    "<p>Please click on the below URL to activate your account:</p>" +
                    "<a href='" + verificationUrl +"'>Activate Account</a>" +
                    "<p>Please click on the below URL to redirect to login page:</p>" +
                    "<a href='" + loginUrl +"'>Go to Login Page</a>";
            mimeMessage.setContent(htmlMsg, "text/html");
        };

        try {
            mailSender.send(messagePreparator);
            log.info("Activation email sent!!");
        } catch (MailException e) {
            log.error("Exception occurred when sending mail", e);
            throw new IllegalStateException("Exception occurred when sending mail to " + user.getEmail() + ": " + e.getMessage());
        }
    }

    @Async
    public void forgotMail(String to,String subject,String password) throws MessagingException {
        log.info("inside forgotMail");
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);
        helper.setFrom("MyAccountant@gmail.com");
        helper.setTo(to);
        helper.setSubject(subject);
        String htmlMsg = "<p><b>Your Login details for MyAccountant Management System</b><br><b>Email: </b> " + to + " <br><b>Password: </b> " + password + "<br><a href=\"https://myaccounta-n.vercel.app/login\">Click here to login</a></p>" +"Don't forget to changes your password, thank you for using our service";
        message.setContent(htmlMsg,"text/html");
        mailSender.send(message);

    }
}
