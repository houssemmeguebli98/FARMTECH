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

public class Reclamations {

    private int id; // Unique identifier for the complaint

    private String type; // Type of complaint

    private String description; // Description of the complaint

    private String email; // Email of the complainant

    private String telephone; // Telephone number of the complainant

 

    // Constructors

 

    public Reclamations() {

        // Default constructor

    }

 

    public Reclamations(String type, String description, String email, String telephone) {

        this.type = type;

        this.description = description;

        this.email = email;

        this.telephone = telephone;

    }

 

    // Getter and Setter methods

 

    public int getId() {

        return id;

    }

 

    public void setId(int id) {

        this.id = id;

    }

 

    public String getType() {

        return type;

    }

 

    public void setType(String type) {

        this.type = type;

    }

 

    public String getDescription() {

        return description;

    }

 

    public void setDescription(String description) {

        this.description = description;

    }

 

    public String getEmail() {

        return email;

    }

 

    public void setEmail(String email) {

        this.email = email;

    }

 

    public String getTelephone() {

        return telephone;

    }

 

    public void setTelephone(String telephone) {

        this.telephone = telephone;

    }

 

    // Override toString() method for better representation

 

    @Override

    public String toString() {

        return "Reclamation [id=" + id + ", type=" + type + ", description=" + description + ", email=" + email

                + ", telephone=" + telephone + "]";

    }
}