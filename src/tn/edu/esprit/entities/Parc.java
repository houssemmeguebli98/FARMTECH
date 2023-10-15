/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.entities;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author megbl
 */
public class Parc {
    private int idParc ;
    private String nomParc ;
    private String adresseParc ;
    private String  superficieParc ;
    private List<Materiel> materiels; 

    
   

    public Parc() {
    }
    

    public Parc(String nomParc, String adresseParc, String superficieParc) {
        this.nomParc = nomParc;
        this.adresseParc = adresseParc;
        this.superficieParc = superficieParc;
    }

  
  

 

    public int getIdParc() {
        return idParc;
    }
    

    public String getNomParc() {
        return nomParc;
    }

    public String getAdresseParc() {
        return adresseParc;
    }

    public void setAdresseParc(String adresseParc) {
        this.adresseParc = adresseParc;
    }

    public  String getSuperficieParc() {
        return superficieParc;
    }

    public void setIdParc(int idParc) {
        this.idParc = idParc;
    }

    public void setNomParc(String nomParc) {
        this.nomParc = nomParc;
    }

    public void setSuperficieParc( String superficieParc) {
        this.superficieParc = superficieParc;
    }
     public void setMateriels(List<Materiel> materiels) {
        this.materiels = materiels;
    }

    public List<Materiel> getMateriels() {
        return materiels;
    }
 

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.idParc;
        hash = 97 * hash + Objects.hashCode(this.nomParc);
        hash = 97 * hash + Objects.hashCode(this.adresseParc);
        hash = 97 * hash + Objects.hashCode(this.superficieParc);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Parc other = (Parc) obj;
        if (this.idParc != other.idParc) {
            return false;
        }
        if (!Objects.equals(this.nomParc, other.nomParc)) {
            return false;
        }
        if (!Objects.equals(this.adresseParc, other.adresseParc)) {
            return false;
        }
        if (!Objects.equals(this.superficieParc, other.superficieParc)) {
            return false;
        }
        return true;
    }

   

  

    @Override
    public String toString() {
        return "Parc{" + "idParc=" + idParc + ", nomParc=" + nomParc + ", adresseParc=" + adresseParc + ", superficieParc=" + superficieParc + '}';
    }


   
    }

 

