/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.olmpiad.s;

import java.io.File;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import quiz.olmpiad.s.User;
import quiz.olmpiad.s.User;

/**
 *
 * @author Anmol
 */
public class mailApi {

    User u = new User();
    String to = u.getEmail();

    String message = "Congratulation! " + u.getName() +" Your Password is :  "+ u.getPassword() +". You have succesfully Signed Up with Quiz Olmpiad";
    String subject = "Quiz Olmpiad";
    String from = "anmol.vns2000@gmail.com";

    mailApi() {

        System.out.println("preparing to send message ...");

        sendEmail(message, subject, to, from);
//        sendAttach(message, subject, to, from);
    }

//    this is responsible to send the message with attachment
    private static void sendAttach(String message, String subject, String to, String from) {

        //Variable for gmail
        String host = "smtp.gmail.com";

        //get the system properties
        Properties properties = System.getProperties();
        System.out.println("PROPERTIES " + properties);

        //setting important information to properties object
        //host set
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication("*********@gmail.com", "*********");
            }
        });

        //Step 1: to get the session object..
//		Session session=Session.getInstance(properties, new Authenticator() {
//			@Override
//			protected PasswordAuthentication getPasswordAuthentication() {				
//				return new PasswordAuthentication("techsoftindia2018@gmail.com", "*******");
//			}
//			
//			
//			
//		});
        session.setDebug(true);

        //Step 2 : compose the message [text,multi media]
        MimeMessage m = new MimeMessage(session);

        try {

            //from email
            m.setFrom(from);

            //adding recipient to message
            m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            //adding subject to message
            m.setSubject(subject);

            //attachement..
            //file path
            String path = "D:\\Anmol\\AnmolFinal\\Quiz Olmpiad's\\src\\quiz\\olmpiad\\s\\icons\\mail.jpg";
          

            MimeMultipart mimeMultipart = new MimeMultipart();
            //text
            //file

            MimeBodyPart textMime = new MimeBodyPart();

            MimeBodyPart fileMime = new MimeBodyPart();

            try {

                textMime.setText(message);

                File file = new File(path);
                fileMime.attachFile(file);

                mimeMultipart.addBodyPart(textMime);
                mimeMultipart.addBodyPart(fileMime);

            } catch (Exception e) {

                e.printStackTrace();
            }

            m.setContent(mimeMultipart);

            //send 
            //Step 3 : send the message using Transport class
            Transport.send(m);

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Sent success...................");

    }

    //this is responsible to send email..
    private static void sendEmail(String message, String subject, String to, String from) {

        //Variable for gmail
        String host = "smtp.gmail.com";

        //get the system properties
        Properties properties = System.getProperties();
        System.out.println("PROPERTIES " + properties);

        //setting important information to properties object
        //host set
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        //Step 1: to get the session object..
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication("anmol.vns2000@gmail.com", "mmxhmsicreenlewd");
            }
        });

//		Session session=Session.getInstance(properties, new Authenticator() {
//			@Override
//			protected PasswordAuthentication getPasswordAuthentication() {				
//				return new PasswordAuthentication("techsoftindia2018@gmail.com", "Durgesh@123");
//			}
//			
//			
//			
//		});
        session.setDebug(true);

        //Step 2 : compose the message [text,multi media]
        MimeMessage m = new MimeMessage(session);

        try {

            //from email
            m.setFrom(from);

            //adding recipient to message
            m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            //adding subject to message
            m.setSubject(subject);

            //adding text to message
            m.setText(message);

            //send 
            //Step 3 : send the message using Transport class
            Transport.send(m);

            System.out.println("Sent success...................");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        mailApi api = new mailApi();

    }

}
