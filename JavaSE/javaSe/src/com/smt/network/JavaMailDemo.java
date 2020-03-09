package com.smt.network;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.Properties;

public class JavaMailDemo {
        static String msgText1 = "This is a message body.\nHere's line two.";
        static String msgText2 = "This is the text in the message attachment.";
        public static void main(String[] args) {
            if (args.length != 4) {
                System.out.println("usage: java msgmultisend <to> <from> <smtp> true|false");
                return;
            }
            String to = args[0];
            String from = args[1];
            String host = "smtp.qq.com";
            boolean debug = Boolean.valueOf(args[3]).booleanValue();
// create some properties and get the default Session
            Properties props = new Properties();
            props.put("smtp.qq.com", host);
            Session session = Session.getInstance(props, null);
            try {
// create a message
                MimeMessage msg = new MimeMessage(session);
                msg.setFrom(new InternetAddress(from));
                InternetAddress[] address = {new InternetAddress(to)};
                msg.setRecipients(Message.RecipientType.TO, address);
                msg.setSubject("JavaMail APIs Multipart Test");
                msg.setSentDate(new Date());
// create and fill the first message part
                MimeBodyPart mbp1 = new MimeBodyPart();
                mbp1.setText(msgText1);
// create and fill the second message part
                MimeBodyPart mbp2 = new MimeBodyPart();
// Use setText(text, charset), to show it off !
                mbp2.setText(msgText2, "utf-8");
// create the Multipart and its parts to it
                Multipart mp = new MimeMultipart();
                mp.addBodyPart(mbp1);
                mp.addBodyPart(mbp2);
// add the Multipart to the message
                msg.setContent(mp);
// send the message
                Transport.send(msg);
            } catch (MessagingException mex) {
                mex.printStackTrace();
                Exception ex = null;
                if ((ex = mex.getNextException()) != null) {
                    ex.printStackTrace();
                }
            }
        }
    }