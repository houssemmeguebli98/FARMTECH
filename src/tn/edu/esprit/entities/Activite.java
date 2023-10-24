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
    private String EtatAct;

    public Activite() {
    }

    
    public Activite(int idAct, String objetAct, String descriptionAct, String distAct, String emailDist, String speciesRES, String EtatAct) {
        this.idAct = idAct;
        this.objetAct = objetAct;
        this.descriptionAct = descriptionAct;
        this.distAct = distAct;
        this.emailDist = emailDist;
        this.speciesRES = speciesRES;
        this.EtatAct = EtatAct;
    }

    public Activite(String objet, String description, String dist, String emailDist, String speciesRES, String etatAct) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdAct() {
        return idAct;
    }

    public String getObjetAct() {
        return objetAct;
    }

    public String getDescriptionAct() {
        return descriptionAct;
    }

    public String getDistAct() {
        return distAct;
    }

    public String getEmailDist() {
        return emailDist;
    }

    public String getSpeciesRES() {
        return speciesRES;
    }

    public String getEtatAct() {
        return EtatAct;
    }

    public void setIdAct(int idAct) {
        this.idAct = idAct;
    }

    public void setObjetAct(String objetAct) {
        this.objetAct = objetAct;
    }

    public void setDescriptionAct(String descriptionAct) {
        this.descriptionAct = descriptionAct;
    }

    public void setDistAct(String distAct) {
        this.distAct = distAct;
    }

    public void setEmailDist(String emailDist) {
        this.emailDist = emailDist;
    }

    public void setSpeciesRES(String speciesRES) {
        this.speciesRES = speciesRES;
    }

    public void setEtatAct(String EtatAct) {
        this.EtatAct = EtatAct;
    }

    @Override
    public String toString() {
        return "Activite{" + "objetAct=" + objetAct + ", descriptionAct=" + descriptionAct + ", distAct=" + distAct + ", emailDist=" + emailDist + ", speciesRES=" + speciesRES + ", EtatAct=" + EtatAct + '}';
    }
 
    
    
    
}
