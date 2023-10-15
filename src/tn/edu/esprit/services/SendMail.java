/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import tn.edu.esprit.entities.Parc;
/**
 *
 * @author megbl
 */
public class SendMail {
    
    public void envoyerEmail(Parc parc, String destinataire, String sujet, String contenu) throws MessagingException {
    if (parc == null || parc.getIdParc() == 0) {
        throw new IllegalArgumentException("Le parc spécifié est invalide.");
    }

    Properties props = new Properties();
        props.put("mail.smtp.auth", "true"); // Activation de l'authentification
        props.put("mail.smtp.starttls.enable", "true"); // Utilisation de TLS
        props.put("mail.smtp.host", "smtp.office365.com"); // Serveur SMTP d'Outlook
        props.put("mail.smtp.port", "587"); // Port SMTP

    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("houssemmeguebli@outlook.com", "esprit@2023");
        }
    });

    try {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("houssemmeguebli@outlook.com"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinataire));
        message.setSubject(sujet);
        message.setText("Détails du parc :\n\n" +
                "ID : " + parc.getIdParc() + "\n" +
                "Nom : " + parc.getNomParc() + "\n" +
                "Adresse : " + parc.getAdresseParc() + "\n" +
                "Superficie : " + parc.getSuperficieParc() + " m²\n\n" +
                contenu);

        Transport.send(message);

        System.out.println("E-mail envoyé avec succès.");

    } catch (MessagingException e) {
        e.printStackTrace();
        System.err.println("Erreur lors de l'envoi de l'e-mail : " + e.getMessage());
    }
   }
    
}






    

