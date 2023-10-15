/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.entities;

import java.util.Objects;

/**
 *
 * @author megbl
 */
public class CategorieMateriel {
    
    private int idCatMat ;
    private String nomCatMat ;
    private String descripCatMat ;

    public CategorieMateriel() {
    }

    public CategorieMateriel(String nomCatMat, String descripCatMat) {
        this.nomCatMat = nomCatMat;
        this.descripCatMat = descripCatMat;
    }


    public int getIdCatMat() {
        return idCatMat;
    }

    public String getNomCatMat() {
        return nomCatMat;
    }

    public String getDescripCatMat() {
        return descripCatMat;
    }

    public void setIdCatMat(int idCatMat) {
        this.idCatMat = idCatMat;
    }

    public void setNomCatMat(String nomCatMat) {
        this.nomCatMat = nomCatMat;
    }

    public void setDescripCatMat(String descripCatMat) {
        this.descripCatMat = descripCatMat;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.idCatMat;
        hash = 79 * hash + Objects.hashCode(this.nomCatMat);
        hash = 79 * hash + Objects.hashCode(this.descripCatMat);
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
        final CategorieMateriel other = (CategorieMateriel) obj;
        if (this.idCatMat != other.idCatMat) {
            return false;
        }
        if (!Objects.equals(this.nomCatMat, other.nomCatMat)) {
            return false;
        }
        if (!Objects.equals(this.descripCatMat, other.descripCatMat)) {
            return false;
        }
        return true;
    }

   
 
    
    
}
