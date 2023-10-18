/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;
import tn.edu.esprit.entities.Transaction;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import tn.edu.esprit.tools.DataSource;

/**
 *
 * @author jouin
 */
public class Servicetransaction implements IService <Transaction> {
Connection cnx ;

    public Servicetransaction(){
        this.cnx= DataSource.getInstance().getConnection();
    }

    @Override
    public void ajouter(Transaction t) {
       try {
        String req = "INSERT INTO `transaction`(`categ_tra`, `type_tra`,`date_tra`, `montant`) VALUES (? ,?, ?, ?)";
        
               PreparedStatement ps = cnx.prepareStatement(req); 
               ps.setString(1, t.getCateg_tra());
               ps.setBoolean(2, t.getType_tra());
               /*java.util.Date utilDate = t.getDate_tra();
               java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
               */
               ps.setDate(3, (Date) t.getDate_tra());
               ps.setInt(4, t.getMontant());
               ps.executeUpdate();
               System.out.println("ajouté");
           
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
       
    }

    /**
     *
     * @param t
     */
    @Override
    public void modifier (Transaction t) {
        try {
            String req = "UPDATE `transaction` SET `categ_tra`=?, `type_tra`=?, `date_tra`=?, `montant`=? WHERE id_tra=?";
            
               try(PreparedStatement ps = (PreparedStatement)cnx.prepareStatement(req)){
               ps.setString(1, t.getCateg_tra());
               ps.setBoolean(2, t.getType_tra());
               ps.setDate(3, (Date) t.getDate_tra());
               ps.setInt(4, t.getMontant());
                ps.setInt(5, t.getId_tra()); 
               ps.executeUpdate();
               //System.out.println("modifié");
               }
           
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }    }

    @Override
    public void supprimer(int id_tra) {
        try{
            String req = "DELETE FROM `transaction` WHERE id_tra="+id_tra;
            PreparedStatement ps = cnx.prepareStatement(req); 
            ps.executeUpdate();
            System.out.println("supprimé");
           
    } catch (SQLException ex) {
                System.out.println(ex.getMessage());

    }      
    }

   @Override
    public void rechercheType (int id_tra) {
         try{
            String req = "SELECT * FROM `transaction` WHERE id_tra="+id_tra;
            PreparedStatement ps = cnx.prepareStatement(req); 
            //ps.executeUpdate();
            ResultSet rst = ps.executeQuery (req);
            rst.last();
            int nbrRow = rst.getRow () ;
            if (nbrRow!=1) {
                System.out.println ("Produit trouve");
                
            }else{
                System.out.println ("Produit non trouve");
            }
       } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        }      
        
    }
     @Override
    public List remplircombo () {
        List List = null;
        return List;
    }
    @Override
    public Transaction getOne(Integer id_tra) {
        Transaction transaction = new Transaction();
        String req = "SELECT id_tra, categ_tra, type_tra, date_tra, montant FROM transaction WHERE id_tra = ?";

    try (PreparedStatement ps = (PreparedStatement) cnx.prepareStatement(req)) {
        ps.setInt(1, id_tra);

        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                //transaction = new Transaction();
                transaction.setId_tra(rs.getInt("id_tra"));
                transaction.setCateg_tra(rs.getString("categ_tra"));
                transaction.setType_tra(rs.getBoolean("type_tra"));
                 transaction.setDate_tra(rs.getDate("date_tra"));
                 transaction.setMontant(rs.getInt("montant"));
            }
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }

    return transaction;
}    

    
@Override
    public List<Transaction> getAll() {
      ArrayList<Transaction> transactions = new ArrayList();
    try {
        String req = "SELECT * FROM `transaction`";
        try (Statement stm = cnx.createStatement(); ResultSet rs = stm.executeQuery(req)) {
            while (rs.next()){
            Transaction p = new Transaction();
            p.setId_tra(rs.getInt("Id_tra"));
            p.setCateg_tra(rs.getString("Categ_tra"));
            p.setType_tra(rs.getBoolean("Type_tra"));
            p.setDate_tra(rs.getDate("Date_tra"));
            p.setMontant(rs.getInt("Montant"));
               
            transactions.add(p);
            }
        }
        
    } catch (SQLException ex) {
    
        System.out.println(ex.getMessage());
    
    }
    return transactions;   
    }

    @Override
    public Transaction getPneById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
   
}

    

