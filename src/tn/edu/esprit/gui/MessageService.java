/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

/**
 *
 * @author Wael.Ibnezzine
 */
import tn.edu.esprit.entities.Message;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import tn.edu.esprit.entities.Message;
import tn.edu.esprit.tools.DataSource;

import tn.edu.esprit.gui.GetAllMessageController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import tn.edu.esprit.entities.Message;
import tn.edu.esprit.tools.DataSource;

public class MessageService {
    private Connection cnx;

    public MessageService() {
        this.cnx = DataSource.getInstance().getConnection();
    }

    public void ajouterMessage(Message message) {
        try {
            String req = "INSERT INTO messages (text, destinataire, source, date) VALUES (?, ?, ?, ?)";
            try (PreparedStatement ps = cnx.prepareStatement(req)) {
                ps.setString(1, message.getText());
                ps.setString(2, message.getDestinataire());
                ps.setString(3, message.getSource());
                ps.setString(4, message.getDate());
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de l'ajout du message : " + ex.getMessage());
        }
    }

    public void updateMessageContent(int messageId, String newContent) {
        try {
            String req = "UPDATE messages SET text = ? WHERE id = ?";
            try (PreparedStatement ps = cnx.prepareStatement(req)) {
                ps.setString(1, newContent);
                ps.setInt(2, messageId);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la mise à jour du contenu du message : " + ex.getMessage());
        }
    }

    public List<Message> getAll() {
        List<Message> messages = new ArrayList<>();
        String req = "SELECT * FROM messages";

        try (PreparedStatement ps = cnx.prepareStatement(req); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Message message = new Message();
                message.setId(rs.getInt("id"));
                message.setText(rs.getString("text"));
                message.setDestinataire(rs.getString("destinataire"));
                message.setSource(rs.getString("source"));
                message.setDate(rs.getString("date"));
                messages.add(message);
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération des messages : " + ex.getMessage());
        }
        return messages;
    }

    public void supprimer(int idMessage) {
        try {
            String req = "DELETE FROM messages WHERE id = ?";
            try (PreparedStatement ps = cnx.prepareStatement(req)) {
                ps.setInt(1, idMessage);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la suppression du message : " + ex.getMessage());
        }
    }

    public Message getOne(String text) {
        Message message = null;
        String req = "SELECT * FROM messages WHERE text = ?";

        try (PreparedStatement ps = cnx.prepareStatement(req)) {
            ps.setString(1, text);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    message = new Message();
                    message.setId(rs.getInt("id"));
                    message.setText(rs.getString("text"));
                    message.setDestinataire(rs.getString("destinataire"));
                    message.setSource(rs.getString("source"));
                    message.setDate(rs.getString("date"));
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération du message : " + ex.getMessage());
        }

        return message;
    }

    public void modifier(Message message) {
        try {
            String req = "UPDATE messages SET text = ?, destinataire = ?, source = ?, date = ? WHERE id = ?";
            try (PreparedStatement ps = cnx.prepareStatement(req)) {
                ps.setString(1, message.getText());
                ps.setString(2, message.getDestinataire());
                ps.setString(3, message.getSource());
                ps.setString(4, message.getDate());
                ps.setInt(5, message.getId());
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la mise à jour du message : " + ex.getMessage());
        }
    }
    
    
    
    
    public List<Message> searchMessages(String searchText) {
        List<Message> matchingMessages = new ArrayList<>();

        String query = "SELECT * FROM messages WHERE content LIKE ?";
        try (PreparedStatement ps = cnx.prepareStatement(query)) {
            ps.setString(1, "%" + searchText + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Message message = new Message();
                    message.setId(rs.getInt("id"));
                    message.setText(rs.getString("content"));
                    message.setDestinataire(rs.getString("receiver"));
                    message.setSource(rs.getString("sender"));
                    message.setDate(rs.getString("date"));

                    matchingMessages.add(message);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error searching messages: " + ex.getMessage());
        }

        return matchingMessages;
    }
    // Ajoutez d'autres méthodes pour mettre à jour d'autres propriétés du message si nécessaire
}
