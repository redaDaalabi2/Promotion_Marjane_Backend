package Services;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
    public static void sendMail(String userEmail, String msg) {
        // Sender's email ID needs to be mentioned
        String email = "daalabir@gmail.com";
        String password = "udfcuhgoqjdwloan";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "25");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(email, password);

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            assert email != null;
            message.setFrom(new InternetAddress(email));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(userEmail));

            // Set Subject: header field
            message.setSubject("Service de Marjane : Les informations de votre compte");

            // Now set the actual message
            message.setText(msg);

            System.out.println("envoyer...");
            // Send message
            Transport.send(message);
            System.out.println("message envoyer avec succées....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
