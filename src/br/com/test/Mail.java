package br.com.test;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.Security;
import java.util.Date;
import java.util.Properties;

public class Mail {

    public static final String USERNAME = "testdextragptw";
    public static final String PWD = "321mudar";

    public static Session openSession() {
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        Properties props = System.getProperties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.auth", "true");
        Session mailSession = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PWD);
            }
        });

        return mailSession;
    }

    public static Message newMessage(Session mailSession, String username, String subject) throws MessagingException {
        // -- Create a new message --
        Message msg = new MimeMessage(mailSession);

        // -- Set the FROM and TO fields --
        msg.setFrom(new InternetAddress(username + "@gmail.com"));
        msg.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse("gustavocarvalho_ti@hotmail.com", false));
        msg.setSubject(subject);
        msg.setSentDate(new Date());

        return msg;
    }

    public static String createHTML(String message, String linkIMG) {
        String result = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\n" +
                "\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns:mc=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/>\n" +
                "<title>GPTW</title>\n" +
                "<style type=\"text/css\">\n" +
                "#backgroundTable {\n" +
                "height: 100% !important;\n" +
                "margin: 0;\n" +
                "padding: 0;\n" +
                "width: 100% !important;\n" +
                "}\n" +
                "\n" +
                "#templateContainer {\n" +
                "border: 1px solid #DDDDDD;\n" +
                "}\n" +
                "\n" +
                "#templateHeader {\n" +
                "background-color: #FFFFFF;\n" +
                "border-bottom: 0;\n" +
                "}\n" +
                "\n" +
                "#headerImage {\n" +
                "height: auto;\n" +
                "max-width: 600px;\n" +
                "}\n" +
                "\n" +
                "#social {\n" +
                "background-color: #FAFAFA;\n" +
                "border: 0;\n" +
                "}\n" +
                "\n" +
                "#social div {\n" +
                "text-align: center;\n" +
                "}\n" +
                "\n" +
                "#utility div {\n" +
                "text-align: center;\n" +
                "}\n" +
                "\n" +
                "#monkeyRewards img {\n" +
                "max-width: 190px;\n" +
                "}\n" +
                "\n" +
                "#templateContainer, .bodyContent {\n" +
                "background-color: #FFFFFF;\n" +
                "}\n" +
                "\n" +
                "#templateFooter {\n" +
                "background-color: #FFFFFF;\n" +
                "border-top: 0;\n" +
                "}\n" +
                "\n" +
                "body {\n" +
                "width: 100% !important;\n" +
                "-webkit-text-size-adjust: none;\n" +
                "margin: 0;\n" +
                "padding: 0;\n" +
                "background-color: #FAFAFA;\n" +
                "}\n" +
                "\n" +
                "img {\n" +
                "border: 0;\n" +
                "height: auto;\n" +
                "line-height: 100%;\n" +
                "outline: none;\n" +
                "text-decoration: none;\n" +
                "}\n" +
                "\n" +
                "table td {\n" +
                "border-collapse: collapse;\n" +
                "}\n" +
                "\n" +
                ".preheaderContent div {\n" +
                "color: #505050;\n" +
                "font-family: Arial;\n" +
                "font-size: 10px;\n" +
                "line-height: 100%;\n" +
                "text-align: left;\n" +
                "}\n" +
                "\n" +
                ".preheaderContent div a:link, .preheaderContent div a:visited,\n" +
                ".preheaderContent div a {\n" +
                "color: #336699;\n" +
                "font-weight: normal;\n" +
                "text-decoration: underline;\n" +
                "}\n" +
                "\n" +
                ".headerContent {\n" +
                "color: #202020;\n" +
                "font-family: Arial;\n" +
                "font-size: 34px;\n" +
                "font-weight: bold;\n" +
                "line-height: 100%;\n" +
                "padding: 0;\n" +
                "text-align: center;\n" +
                "vertical-align: middle;\n" +
                "}\n" +
                "\n" +
                ".headerContent a:link, .headerContent a:visited,\n" +
                ".headerContent a {\n" +
                "color: #336699;\n" +
                "font-weight: normal;\n" +
                "text-decoration: underline;\n" +
                "}\n" +
                "\n" +
                ".bodyContent div {\n" +
                "color: #505050;\n" +
                "font-family: Arial;\n" +
                "font-size: 14px;\n" +
                "line-height: 150%;\n" +
                "text-align: left;\n" +
                "}\n" +
                "\n" +
                ".bodyContent div a:link, .bodyContent div a:visited,\n" +
                ".bodyContent div a {\n" +
                "color: #336699;\n" +
                "font-weight: normal;\n" +
                "text-decoration: underline;\n" +
                "}\n" +
                "\n" +
                ".bodyContent img {\n" +
                "display: inline;\n" +
                "height: auto;\n" +
                "}\n" +
                "\n" +
                ".footerContent div {\n" +
                "color: #707070;\n" +
                "font-family: Arial;\n" +
                "font-size: 12px;\n" +
                "line-height: 125%;\n" +
                "text-align: left;\n" +
                "}\n" +
                "\n" +
                ".footerContent div a:link, .footerContent div a:visited,\n" +
                ".footerContent div a {\n" +
                "color: #336699;\n" +
                "font-weight: normal;\n" +
                "text-decoration: underline;\n" +
                "}\n" +
                "\n" +
                ".footerContent img {\n" +
                "display: inline;\n" +
                "}\n" +
                "</style>\n" +
                "</head>\n" +
                "<body leftmargin=\"0\" marginwidth=\"0\" topmargin=\"0\" marginheight=\"0\" offset=\"0\">\n" +
                "<center>\n" +
                "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" height=\"100%\" width=\"100%\" id=\"backgroundTable\">\n" +
                "<tr>\n" +
                "<td align=\"center\" valign=\"top\">\n" +
                "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" id=\"templateContainer\">\n" +
                "<tr>\n" +
                "<td align=\"center\" valign=\"top\">\n" +
                "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" id=\"templateHeader\">\n" +
                "<tr>\n" +
                "<td class=\"headerContent\">\n" +
                "<img src=\"<%img%>\"\n" +
                " style=\"max-width:600px;\"\n" +
                " id=\"headerImage campaign-icon\"\n" +
                " label=\"header_image\"\n" +
                " edit=\"header_image\"\n" +
                " allowdesigner\n" +
                " allowtext/>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td align=\"center\" valign=\"top\">\n" +
                "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" id=\"templateBody\">\n" +
                "<tr>\n" +
                "<td valign=\"top\">\n" +
                "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\">\n" +
                "<tr>\n" +
                "<td valign=\"top\" class=\"bodyContent\">\n" +
                "<table border=\"0\" cellpadding=\"20\" cellspacing=\"0\" width=\"100%\">\n" +
                "<tr>\n" +
                "<td valign=\"top\">\n" +
                "<div edit=\"std_content00\">\n" +
                "<%message%>\n" +
                "</div>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td align=\"center\" valign=\"top\">\n" +
                "<table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" width=\"600\" id=\"templateFooter\">\n" +
                "<tr>\n" +
                "<td valign=\"top\" class=\"footerContent\">\n" +
                "<table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" width=\"100%\">\n" +
                "<tr>\n" +
                "<td colspan=\"2\" valign=\"middle\" id=\"social\">\n" +
                "<div edit=\"std_social\">\n" +
                "&nbsp;<a href=\"https://twitter.com/gptw_brasil\" target=\"_blank\">Twitter</a>\n" +
                "|\n" +
                "<a href=\"https://www.facebook.com/greatplacetoworkbrasil\"\n" +
                " target=\"_blank\">Facebook</a> |\n" +
                "<a href=\"https://www.linkedin.com/company/2078737/\"\n" +
                " target=\"_blank\">Linkedin</a> |\n" +
                "<a href=\"https://www.flickr.com/photos/greatplacetowork/\"\n" +
                " target=\"_blank\">Flickr</a>&nbsp;\n" +
                "</div>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "<br/>\n" +
                "</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "</center>\n" +
                "</body>\n" +
                "</html>";
        return result.replace("<%img%>", linkIMG).replace("<%message%>", message);
    }
}
