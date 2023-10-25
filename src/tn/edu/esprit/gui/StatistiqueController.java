package tn.edu.esprit.gui;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class StatistiqueController implements Initializable {
    @FXML
    private Label nombreTerrain;
    
    @FXML
    private Label totalSuperficie;
    @FXML
    private Label statistiquesTerrains;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Vous pouvez effectuer des opérations d'initialisation ici si nécessaire.
    }

    // Méthode pour définir le nombre de terrains affiché dans l'interface
    public void setNombreTerrain(String nombreTerrains) {
        nombreTerrain.setText("Le nombre totale des terrains est :  " +nombreTerrains+" terrains");
        
    }
    
    // Méthode pour définir la superficie totale affichée dans l'interface
    public void setTotalSuperficie(String superficieTotale) {
        totalSuperficie.setText("La superficie totale de vos terrains est:  " +superficieTotale +" m2");
    }

    

    public void setStatistiquesTerrains(Map<String, Integer> nombreRessourcesParTerrain) {
    StringBuilder statistiques = new StringBuilder("Nombre total de ressources par terrain :  \n");

    for (Map.Entry<String, Integer> entry : nombreRessourcesParTerrain.entrySet()) {
        statistiques.append("Terrain ").append(entry.getKey()).append("  :   ").append(entry.getValue()).append("   ressources\n");
    }

    statistiquesTerrains.setText(statistiques.toString());
}

}
