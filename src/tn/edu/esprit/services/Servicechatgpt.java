/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;
import java.io.BufferedReader;
import java.io.IOException;
import java.io. InputStreamReader;
import java.io.OutputStreamWriter;
import java.net. HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;



/**
 *
 * @author jouin
 */
public class Servicechatgpt implements IService {
    
<<<<<<< HEAD
         @Override
    public String chatGPT(String message) {
    String url = "https://api.openai.com/v1/chat/completions";
    String apiKey ="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";
    String model = "gpt-3.5-turbo";

    try {
        // Créer la requête POST HTTP
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Authorization", "Bearer " + apiKey);
        con.setRequestProperty("Content-Type", "application/json");

        // Construire le corps de la requête
        String requestBody = "{\"model\": \"" + model + "\", \"messages\": [{\"role\": \"user\", \"content\": \"" + message + "\"}]}";
        con.setDoOutput(true);

        // Envoyer la requête
        OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream());
        writer.write(requestBody);
        writer.flush();
        writer.close();

        // Lire la réponse
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // Analyser la réponse JSON
        JSONObject jsonResponse = new JSONObject(response.toString());
        JSONArray choices = jsonResponse.getJSONArray("choices");
        if (choices.length() > 0) {
            String answer = choices.getJSONObject(0).getJSONObject("message").getString("content");
            return answer;
        } else {
            return "Aucune réponse reçue";
        }
    } catch (IOException e) {
        throw new RuntimeException(e);
    }

    }
    
        
=======
          @Override
    public String chatGPT(String message) {
        String url = "https://api.openai.com/v1/chat/completions";
        String apiKey = "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";
        String model = "gpt-3.5-turbo";

        try {
            // Create the HTTP POST request
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Authorization", "Bearer " + apiKey);
            con.setRequestProperty("Content-Type", "application/json");

            // Build the request body
            String requestBody = "{\"model\": \"" + model + "\", \"messages\": [{\"role\": \"user\", \"content\": \"" + message + "\"}]}";
            con.setDoOutput(true);

            // Send the request
            OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream());
            writer.write(requestBody);
            writer.flush();
            writer.close();

            // Read the response
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Parse the JSON response
            JSONObject jsonResponse;
            jsonResponse = new JSONObject(response.toString());
            JSONArray choices = jsonResponse.getJSONArray("choices");
            if (choices.length() > 0) {
                String answer = choices.getJSONObject(0).getJSONObject("message").getString("content").substring(4);
                return answer;
            } else {
                return "No response received";
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

>>>>>>> ad4816ef4b1a5675c53fd9cfa3d34b73cccef807
    @Override
    public void ajouter(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifier(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimer(int id_tra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void rechercheType(int id_tra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List remplircombo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getOne(String categ_tra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getPneById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int caisse() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int nbligne() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
<<<<<<< HEAD

    @Override
    public Object create(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getOne(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getAll(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
=======
>>>>>>> ad4816ef4b1a5675c53fd9cfa3d34b73cccef807
}