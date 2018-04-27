package br.com.test;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;

public class HTMLMail {

    public static void main(String[] args) throws Exception {
        System.out.println("Sending mail");

        Session mailSession = Mail.openSession();
        Message msg = Mail.newMessage(mailSession, Mail.USERNAME, "Teste");
        String emailHTML = Mail.createHTML(
                "Esqueceu sua senha para acessar o GPTW Connect? <br/>\n" +
                        "Para escolher uma nova, clique no link abaixo. <br/> \n" +
                        "<a href='http://www.greatplacetowork.com.br/' target='_blank'>Redefinir senha</a>",
                "https://media.licdn.com/mpr/mpr/AAEAAQAAAAAAAAZ3AAAAJDNkZDU1YmNkLThkMDMtNDE2ZC1hZGUwLWViMGQ3MGMxMDVkYw.jpg");
        msg.setContent(emailHTML, "text/html");
        Transport.send(msg);

        System.out.println("Message sent");
    }

}