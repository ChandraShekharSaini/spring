package com.spring.springprac.service;


import com.mailersend.sdk.MailerSend;
import com.mailersend.sdk.MailerSendResponse;
import com.mailersend.sdk.emails.Email;
import com.mailersend.sdk.exceptions.MailerSendException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MailerSendEmailService {

    private Logger log = LoggerFactory.getLogger(MailerSendEmailService.class);

    @Value("${mailersend.api.token}")
    private String apiToken;

    @Value("${mailersend.from.email}")
    private String fromEmail;

    @Value("${mailersend.from.name}")
    private String fromName;

    public String sendEmail(String sendername, String to, String subject, String body) {

        Email email = new Email();
        email.setFrom(fromName, fromEmail);
        email.addRecipient("User", to);
        email.setSubject(subject);
        email.setPlain(body);


        String htmlContent = """
                <div style="font-family: Arial, sans-serif; max-width: 600px; margin: auto; padding: 20px;">
                    <h2 style="color: #2E86C1;">Welcome to Our Platform!</h2>
                
                    <p>Hi, %s</p>
                
                    <p>Thank you for signing up successfully. Your account has been created.</p>
                
                    <p>You can now log in and start using our services.</p>
                
                    <hr style="margin: 20px 0;">
                
                    <p style="font-size: 14px; color: gray;">
                        If you did not create this account, please contact our support team.
                    </p>
                
                    <p>Best Regards,<br>
                    <strong>Chandra Shekhar</strong></p>
                </div>
                """.formatted(sendername);

        email.setHtml(htmlContent);

        email.setHtml(htmlContent);
        email.setPlain("Welcome! Your account has been successfully created.");

        MailerSend ms = new MailerSend();
        ms.setToken(apiToken);

        try {
            MailerSendResponse response = ms.emails().send(email);
            log.debug("Email Sent. Message ID:{}", response.messageId);
            return "Email Sent. Message ID: " + response.messageId;
        } catch (MailerSendException e) {
            e.printStackTrace();
            return "Error sending email";
        }
    }
}
