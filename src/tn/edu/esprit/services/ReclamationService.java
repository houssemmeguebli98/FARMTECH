/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tn.edu.esprit.entities.Reclamations;
import tn.edu.esprit.tools.DataSource;

/**
 *
 * @author Houssem HENCHIR
 */
public class ReclamationService {
    

    private Connection cnx;

    public ReclamationService() {
        this.cnx = DataSource.getInstance().getConnection();
    }

    public void ajouterReclamation(Reclamations reclamation) {
        try {
            String req = "INSERT INTO reclamations (type, description, email, telephone) VALUES (?, ?, ?, ?)";
            try (PreparedStatement ps = cnx.prepareStatement(req)) {
                ps.setString(1, reclamation.getType());
                ps.setString(2, reclamation.getDescription());
                ps.setString(3, reclamation.getEmail());
                ps.setString(4, reclamation.getTelephone());
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de l'ajout de la réclamation : " + ex.getMessage());
        }
    }

    public void updateReclamationContent(int reclamationId, String newContent) {
        try {
            String req = "UPDATE reclamations SET description = ? WHERE id = ?";
            try (PreparedStatement ps = cnx.prepareStatement(req)) {
                ps.setString(1, newContent);
                ps.setInt(2, reclamationId);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la mise à jour de la description de la réclamation : " + ex.getMessage());
        }
    }

    public void supprimerReclamation(int idReclamation) {
        try {
            String req = "DELETE FROM reclamations WHERE id = ?";
            try (PreparedStatement ps = cnx.prepareStatement(req)) {
                ps.setInt(1, idReclamation);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la suppression de la réclamation : " + ex.getMessage());
        }
    }

    public List<Reclamations> getAllReclamations() {
        List<Reclamations> reclamations = new ArrayList<>();
        String req = "SELECT * FROM reclamations";

        try (PreparedStatement ps = cnx.prepareStatement(req); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Reclamations reclamation = new Reclamations();
                reclamation.setId(rs.getInt("id"));
                reclamation.setType(rs.getString("type"));
                reclamation.setDescription(rs.getString("description"));
                reclamation.setEmail(rs.getString("email"));
                reclamation.setTelephone(rs.getString("telephone"));
                reclamations.add(reclamation);
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération des réclamations : " + ex.getMessage());
        }
        return reclamations;
    }

    public List<Reclamations> searchReclamations(String searchText) {
        List<Reclamations> matchingReclamations = new ArrayList<>();

        String query = "SELECT * FROM reclamations WHERE description LIKE ?";
        try (PreparedStatement ps = cnx.prepareStatement(query)) {
            ps.setString(1, "%" + searchText + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Reclamations reclamation = new Reclamations();
                    reclamation.setId(rs.getInt("id"));
                    reclamation.setType(rs.getString("type"));
                    reclamation.setDescription(rs.getString("description"));
                    reclamation.setEmail(rs.getString("email"));
                    reclamation.setTelephone(rs.getString("telephone"));

                    matchingReclamations.add(reclamation);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la recherche des réclamations : " + ex.getMessage());
        }

        return matchingReclamations;
    }
}
