package com.crossover.app.utils;

import com.crossover.app.common.Constant;
import org.testng.annotations.Test;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

/**
 * Created by parag.dhoble on 20-07-2018.
 */
public class EmailApi {


    public void SendEmail() {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(Constant.EmailUserName, Constant.EmailPassword);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(Constant.EmailUserName));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("paragd001@gmail.com"));
            message.setSubject("Web_Automation_Report");
           // message.setText(Constant.Email_Body);

            String filename =System.getProperty("user.dir")+"\\Report.xlsx";
            DataSource source = new FileDataSource(filename);

            // set the handler
            message.setDataHandler(new DataHandler(source));
            message.setFileName(filename);
            Transport.send(message);
            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}


