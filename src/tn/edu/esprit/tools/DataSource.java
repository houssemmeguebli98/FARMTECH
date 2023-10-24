package tn.edu.esprit.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataSource {

    public static Connection getConnect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private Connection cnx;
    private static DataSource instance;
<<<<<<< HEAD
    
<<<<<<< HEAD
<<<<<<< HEAD
    private String url = "jdbc:mysql://localhost/esprit";
=======

    private String url = "jdbc:mysql://localhost:3306/esprit";
>>>>>>> origin/gestion_users
=======
    private String url = "jdbc:mysql://localhost:3306/FARMTECH";
>>>>>>> origin/gestion-terrain
=======
    private String url = "jdbc:mysql://localhost:3306/farmtech";
>>>>>>> origin/gestion_treso
    private String user = "root";
    private String password = "";

    

    private DataSource() {
        try {
            cnx = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to MySQL Server!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static DataSource getInstance() {
        if (instance == null) {
            instance = new DataSource();
        }
        return instance;
    }

    public Connection getConnection() {
        return this.cnx;
    }

    /**
     *
     */
    public void createDatabaseIfNotExists() {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {
            // Créez une base de données s'il n'existe pas
            String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS " + "esprit";
            statement.executeUpdate(createDatabaseSQL);
            System.out.println("Database 'esprit' created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error creating the 'esprit' database.");
        }
    }
    
   

  


}






