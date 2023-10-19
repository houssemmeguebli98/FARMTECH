/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.entities;

/**
 *
 * @author Houssem HENCHIR
 */
public class Message {
    private int id;
    private String text;
    private String destinataire;
    private String source;
    private String date;

    public Message() {
        // Constructeur par défaut
    }

    public Message(String text, String destinataire, String source, String date) {
        this.text = text;
        this.destinataire = destinataire;
        this.source = source;
        this.date = date;
    }

    // Getters et Setters pour les attributs
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(String destinataire) {
        this.destinataire = destinataire;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
     public void setContent(String content) {
        this.text = content;
    }

    // Vous pouvez également ajouter d'autres méthodes spécifiques à la classe Message en fonction de vos besoins.



}
