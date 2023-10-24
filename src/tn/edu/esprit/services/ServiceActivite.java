package tn.edu.esprit.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tn.edu.esprit.entities.Activite;
import tn.edu.esprit.tools.DataSource;

public class ServiceActivite implements IService<Activite> {
    Connection cnx;

    public ServiceActivite() {
        this.cnx = DataSource.getInstance().getConnection();
    }

    @Override
    public void ajouter(Activite t) {
        try {
            String req = "INSERT INTO `activite`(`objetAct`, `descriptionAct`, `distAct`, `emailDist`, `speciesRES`, `etatAct`) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, t.getObjetAct());
            ps.setString(2, t.getDescriptionAct());
            ps.setString(3, t.getDistAct());
            ps.setString(4, t.getEmailDist());
            ps.setString(5, t.getSpeciesRES());
            ps.setString(6, t.getEtatAct());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Activite t) {
        try {
            String req = "UPDATE `activite` SET `objetAct` = ?, `descriptionAct` = ?, `distAct` = ?, `emailDist` = ?, `speciesRES` = ?, `etatAct` = ? WHERE `idAct` = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, t.getObjetAct());
            ps.setString(2, t.getDescriptionAct());
            ps.setString(3, t.getDistAct());
            ps.setString(4, t.getEmailDist());
            ps.setString(5, t.getSpeciesRES());
            ps.setString(6, t.getEtatAct());
            ps.setInt(7, t.getIdAct());
            ps.executeUpdate();
        } catch (SQLException ex) {
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
                activite.setSpeciesRES(rs.getString("speciesRES"));
                activite.setEtatAct(rs.getString("etatAct"));
            }

            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return activite;
    }

    public Activite getOneByEmail(String email) {
        Activite activite = null;
        try {
            String req = "SELECT * FROM `activite` WHERE `emailDist` = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                activite = new Activite();
                activite.setIdAct(rs.getInt("idAct"));
                activite.setObjetAct(rs.getString("objetAct"));
                activite.setDescriptionAct(rs.getString("descriptionAct"));
                activite.setDistAct(rs.getString("distAct"));
                activite.setEmailDist(rs.getString("emailDist"));
                activite.setSpeciesRES(rs.getString("speciesRES"));
                activite.setEtatAct(rs.getString("etatAct"));
            }

            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return activite;
    }

    @Override
    public List<Activite> getAll(Activite t) {
        List<Activite> activiteList = new ArrayList<>();
        try {
            String req = "SELECT * FROM `activite`";
            PreparedStatement ps = cnx.prepareStatement(req);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Activite activite = new Activite();
                activite.setIdAct(rs.getInt("idAct"));
                activite.setObjetAct(rs.getString("objetAct"));
                activite.setDescriptionAct(rs.getString("descriptionAct"));
                activite.setDistAct(rs.getString("distAct"));
                activite.setEmailDist(rs.getString("emailDist"));
                activite.setSpeciesRES(rs.getString("speciesRES"));
                activite.setEtatAct(rs.getString("etatAct"));
                activiteList.add(activite);
            }

            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return activiteList;
    }
    
public List<Activite> getAllByEmail(String email) {
    List<Activite> activiteList = new ArrayList<>();
    try {
        String req = "SELECT * FROM `activite` WHERE emailDist=?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setString(1, email); // Paramètre email

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Activite activite = new Activite();
            activite.setIdAct(rs.getInt("idAct"));
            activite.setObjetAct(rs.getString("objetAct"));
            activite.setDescriptionAct(rs.getString("descriptionAct"));
            activite.setDistAct(rs.getString("distAct"));
            activite.setEmailDist(rs.getString("emailDist"));
            activite.setSpeciesRES(rs.getString("speciesRES"));
            activite.setEtatAct(rs.getString("etatAct"));
            activiteList.add(activite);
        }

        ps.close();
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return activiteList;
}

}
