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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tn.edu.esprit.entities.Activite;

import tn.edu.esprit.tools.DataSource;
/**
 *
 * @author rihab
 */
public class ServiceActivite implements IService<Activite>  {
     Connection cnx ;

    public ServiceActivite() {
         this.cnx= DataSource.getInstance().getConnection();
    }
     
     
      @Override
    public void ajouter(Activite t) {
        try {
        String req = "INSERT INTO `activite`(`objetAct`, `descriptionAct`, `distAct`, `emailDist`) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setString(1, t.getObjetAct());
        ps.setString(2, t.getDescriptionAct());
        ps.setString(3, t.getDistAct());
        ps.setString(4, t.getEmailDist());

        ps.executeUpdate();
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    }
    
    
    
    
    

    @Override
    public void modifier(Activite t) {
        try {
            
            String req = "UPDATE `activite` SET `objetAct` = ?, `descriptionAct` = ?, `distAct` = ?, `emailDist` = ? WHERE `idAct` = ?";

            PreparedStatement ps = cnx.prepareStatement(req);

            ps.setString(1, t.getObjetAct());
            ps.setString(2, t.getDescriptionAct());
            ps.setString(3, t.getDistAct());
            ps.setString(4, t.getEmailDist());
            ps.setInt(5, t.getIdAct());
            ps.executeUpdate();
    }    
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
         }
    }

    
    
    
    
    
    @Override
    public void supprimer(int id) {
       try {
        String req = "DELETE FROM `activite` WHERE `idAct` = " + id; 
        Statement stm = cnx.createStatement(); 
        stm.executeUpdate(req);
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    }

    
    
    
    
    @Override
    public Activite getOne(int id) {
    Activite activite = null;
    try {
        String req = "SELECT * FROM `activite` WHERE `idAct` = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            activite = new Activite();
            activite.setIdAct(rs.getInt("idAct"));
            activite.setObjetAct(rs.getString("objetAct"));
            activite.setDescriptionAct(rs.getString("descriptionAct"));
            activite.setDistAct(rs.getString("distAct"));
            activite.setEmailDist(rs.getString("emailDist"));
        }
        
        ps.close();
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return activite;
}

    
    

    @Override
    public List<Activite> getAll(Activite t) {
        String req = "SELECT * FROM `activite`";
        ArrayList<Activite> activites = new ArrayList<>();
        Statement stm;
        try {
            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(req);
            while (rs.next()) {
                Activite a = new Activite();
                a.setIdAct(rs.getInt(1));
                a.setObjetAct(rs.getString("objetAct"));
                a.setDescriptionAct(rs.getString("descriptionAct"));
                a.setDistAct(rs.getString("distAct"));
                a.setEmailDist(rs.getString("emailDist"));
                activites.add(a);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return activites;
    }

    

    
    
    
    
}
