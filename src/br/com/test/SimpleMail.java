package br.com.test;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import java.util.Date;

public class SimpleMail {

    public static void main(String[] args) throws Exception {
        System.out.println("Sending mail");

        Session mailSession = Mail.openSession();
        Message msg = Mail.newMessage(mailSession, Mail.USERNAME, "Test");
        msg.setText("How are you today");
        msg.setSentDate(new Date());
        Transport.send(msg);

        System.out.println("Message sent");
    }

}
