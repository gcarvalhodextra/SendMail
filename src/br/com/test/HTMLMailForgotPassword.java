package br.com.test;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;

public class HTMLMailForgotPassword {

    public static void main(String[] args) throws Exception {
        System.out.println("Sending mail");

        Session mailSession = Mail.openSession();
        Message msg = Mail.newMessage(mailSession, Mail.USERNAME, "GPTW Connect - Redefinir senha");
        String emailHTML = Mail.createHTML(
                "Esqueceu sua senha para acessar o GPTW Connect? <br/>\n" +
                        "Para escolher uma nova, clique no link abaixo. <br/> \n" +
                        "<a href='http://www.greatplacetowork.com.br/' target='_blank'>Redefinir senha</a>",
                "https://lh5.googleusercontent.com/jSeogOTcr5P44hg23B5JkZsyCRKaQbkLDL7OC0eO0Ryo8SS6U6nL9pQmquVj01dyC0A1vVrQiCfcRzA=w1301-h653");
        msg.setContent(emailHTML, "text/html");
        Transport.send(msg);

        System.out.println("Message sent");
    }

}