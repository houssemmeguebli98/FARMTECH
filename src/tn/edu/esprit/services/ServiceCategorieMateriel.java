/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tn.edu.esprit.entities.CategorieMateriel;
import tn.edu.esprit.tools.DataSource;

/**
 *
 * @author megbl
 */
public class ServiceCategorieMateriel implements IService<CategorieMateriel>{
    Connection cnx ;

  

public ServiceCategorieMateriel(){
   this.cnx= DataSource.getInstance().getConnection();
}

 
     @Override
    public void ajouter(CategorieMateriel t) {
       try {
        String req = "INSERT INTO `categoriemateriel`( `nomCatMat`, `descripCatMat`) VALUES (?, ?)";
        
           try (PreparedStatement ps = (PreparedStatement) cnx.prepareStatement(req)) {
               ps.setString(1, t.getNomCatMat());
               ps.setString(2, t.getDescripCatMat());
               ps.executeUpdate();
           }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
       
    }
    public List<CategorieMateriel> getAll() {
        List<CategorieMateriel> categories = new ArrayList<>();
        
        try {
            String req = "SELECT * FROM categoriemateriel";
            try (Statement stm = cnx.createStatement(); ResultSet rs = stm.executeQuery(req)) {
                
                while (rs.next()) {
                    CategorieMateriel categorie = new CategorieMateriel();
                    categorie.setIdCatMat(rs.getInt("idCatMat"));
                    categorie.setNomCatMat(rs.getString("nomCatMat"));
                    categorie.setDescripCatMat(rs.getString("descripCatMat"));
                    categories.add(categorie);
                }
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return categories;
       
    }
       @Override
    public void supprimer(int id) {
     try {
            String req = "DELETE FROM categoriemateriel WHERE idCatMat = ?";
         try (PreparedStatement ps = (PreparedStatement) cnx.prepareStatement(req)) {
             ps.setInt(1, id);
             ps.executeUpdate();
         }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }    
/*
    @Override
    public void modifier(Personne t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 

    @Override
    public Personne getOne(Personne t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Personne> getAll(Personne t) {
      String req = "SELECT * FROM `personne`";
      ArrayList<Personne> personnes = new ArrayList();
    Statement stm;
    try {
        stm = this.cnx.createStatement();
    
    
        ResultSet rs=  stm.executeQuery(req);
    while (rs.next()){
        Personne p = new Personne();
        p.setId(rs.getInt(1));
        p.setNom(rs.getString("nom"));
        p.setPrenom(rs.getString(3));
        
        personnes.add(p);
    }
        
        
    } catch (SQLException ex) {
    
        System.out.println(ex.getMessage());
    
    }

    return personnes;
    }

}
*/

  

    @Override
    public void modifier(CategorieMateriel t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 

   

    @Override
    public List<CategorieMateriel> getAll(CategorieMateriel t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CategorieMateriel getOne(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
