/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.entities;

/**
 *
 * @author rihab
 */
public class Activite {
    private int idAct;
    private String objetAct;
    private String descriptionAct;
    private String distAct;
    private String emailDist;
    private String speciesRES;
   

    public Activite() {
    }

    public Activite(String objetAct, String descriptionAct, String distAct, String emailDist, String speciesRES) {
        this.objetAct = objetAct;
        this.descriptionAct = descriptionAct;
        this.distAct = distAct;
        this.emailDist = emailDist;
        this.speciesRES = speciesRES;
    }

    public Activite(int idAct, String objetAct, String descriptionAct, String distAct, String emailDist, String speciesRES) {
        this.idAct = idAct;
        this.objetAct = objetAct;
        this.descriptionAct = descriptionAct;
        this.distAct = distAct;
        this.emailDist = emailDist;
        this.speciesRES = speciesRES;
    }

    
   

    

    public int getIdAct() {
        return idAct;
    }

    public void setIdAct(int idAct) {
        this.idAct = idAct;
    }

    public String getObjetAct() {
        return objetAct;
    }

    public void setObjetAct(String objetAct) {
        this.objetAct = objetAct;
    }

    public String getDescriptionAct() {
        return descriptionAct;
    }

    public void setDescriptionAct(String descriptionAct) {
        this.descriptionAct = descriptionAct;
    }

    public String getDistAct() {
        return distAct;
    }

    public void setDistAct(String distAct) {
        this.distAct = distAct;
    }

    public String getEmailDist() {
        return emailDist;
    }

    public void setEmailDist(String emailDist) {
        this.emailDist = emailDist;
    }

    public String getSpeciesRES() {
        return speciesRES;
    }

    public void setSpeciesRES(String speciesRES) {
        this.speciesRES = speciesRES;
    }

    @Override
    public String toString() {
        return "Activite{" + "idAct=" + idAct + ", objetAct=" + objetAct + ", descriptionAct=" + descriptionAct + ", distAct=" + distAct + ", emailDist=" + emailDist + ", speciesRES=" + speciesRES + '}';
    }

   

    

   
    
    
    
    
}
