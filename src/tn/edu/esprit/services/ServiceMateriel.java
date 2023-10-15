/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tn.edu.esprit.entities.Materiel;
import tn.edu.esprit.tools.DataSource;

/**
 *
 * @author megbl
 */
public class ServiceMateriel {
    
    private Connection cnx;

    public ServiceMateriel() {
        this.cnx = DataSource.getInstance().getConnection();
    }
 public void ajouterMateriel(Materiel materiel) {
        try {
            String req = "INSERT INTO `materiel`(`nomParc`, `nomMat`, `etatMat`, `QuantiteMat`, `dateAjout`) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement ps = cnx.prepareStatement(req)) {
                ps.setString(1, materiel.getNomParc());
                ps.setString(2, materiel.getNomMat());
                ps.setBoolean(3, materiel.getEtatMat());
                ps.setFloat(4, materiel.getQuantiteMat());
                ps.setDate(5, Date.valueOf(materiel.getDateAjout()));
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

 public void supprimerMateriel(String nomMateriel) {
    try {
        String req = "DELETE FROM `materiel` WHERE nomMat = ?";

        try (PreparedStatement ps = cnx.prepareStatement(req)) {
            ps.setString(1, nomMateriel);
            ps.executeUpdate();
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
}



  public Materiel getOneMateriel(int id) {
    Materiel materiel = null;
    String req = "SELECT `nomMat`, `etatMat`, `QuantiteMat`,`dateAjout`, `nomParc` FROM `materiel` WHERE idParc = ?";

    try (PreparedStatement ps = cnx.prepareStatement(req)) {
        ps.setInt(1, id);

        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                materiel = new Materiel();
                materiel.setNomParc(rs.getString("nomParc"));
                materiel.setNomMat(rs.getString("nomMat"));
                materiel.setEtatMat(rs.getBoolean("etatMat"));
                materiel.setQuantiteMat(rs.getFloat("QuantiteMat"));
                materiel.setDateAjout(rs.getDate("dateAjout").toLocalDate());
            }
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }

    return materiel;
}

 

  public List<Materiel> getAllMateriels() {
        List<Materiel> materiels = new ArrayList<>();

        try {
            String req = "SELECT * FROM `materiel`";

            try (Statement stm = cnx.createStatement(); ResultSet rs = stm.executeQuery(req)) {

                while (rs.next()) {
                    Materiel materiel = new Materiel();
                    materiel.setNomParc(rs.getString("nomParc"));
                    materiel.setNomMat(rs.getString("nomMat"));
                    materiel.setEtatMat(rs.getBoolean("etatMat"));
                    materiel.setQuantiteMat(rs.getFloat("QuantiteMat"));
                    materiel.setDateAjout(rs.getDate("dateAjout").toLocalDate());
                  

                    materiels.add(materiel);
                }

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return materiels;
    }
 
   public void modifierMateriel(Materiel materiel) {
        try {
            String req = "UPDATE `materiel` SET `nomParc`=?, `nomMat`=?, `etatMat`=?, `QuantiteMat`=?, `dateAjout`=? WHERE idMat=?";

            try (PreparedStatement ps = cnx.prepareStatement(req)) {
                ps.setString(1, materiel.getNomParc());
                ps.setString(2, materiel.getNomMat());
                ps.setBoolean(3, materiel.getEtatMat());
                ps.setFloat(4, materiel.getQuantiteMat());
                ps.setDate(5, Date.valueOf(materiel.getDateAjout()));               
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}


