/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.entities;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author megbl
 */
public class Materiel {
 private int idMat ;
 private String nomParc;
 private String nomMat;
 private boolean etatMat ;
 private float QuantiteMat ;
 private LocalDate dateAjout ;
 private int idParc;

    public Materiel() {
    }

 
    public Materiel(String nomParc, String nomMat, boolean etatMat, float QuantiteMat, LocalDate dateAjout) {
        this.nomParc = nomParc;
        this.nomMat = nomMat;
        this.etatMat = etatMat;
        this.QuantiteMat = QuantiteMat;
        this.dateAjout = dateAjout;
    }

    public int getIdMat() {
        return idMat;
    }

    public String getNomParc() {
        return nomParc;
    }

    public String getNomMat() {
        return nomMat;
    }

    public boolean getEtatMat() {
        return etatMat;
    }

    public float getQuantiteMat() {
        return QuantiteMat;
    }

    public LocalDate getDateAjout() {
        return dateAjout;
    }

    public int getIdParc() {
        return idParc;
    }

    public void setIdMat(int idMat) {
        this.idMat = idMat;
    }

    public void setNomParc(String nomParc) {
        this.nomParc = nomParc;
    }

    public void setNomMat(String nomMat) {
        this.nomMat = nomMat;
    }

    public void setEtatMat(boolean etatMat) {
        this.etatMat = etatMat;
    }

    public void setQuantiteMat(float QuantiteMat) {
        this.QuantiteMat = QuantiteMat;
    }

    public void setDateAjout(LocalDate dateAjout) {
        this.dateAjout = dateAjout;
    }

    public void setIdParc(int idParc) {
        this.idParc = idParc;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.idMat;
        hash = 61 * hash + Objects.hashCode(this.nomParc);
        hash = 61 * hash + Objects.hashCode(this.nomMat);
        hash = 61 * hash + (this.etatMat ? 1 : 0);
        hash = 61 * hash + Float.floatToIntBits(this.QuantiteMat);
        hash = 61 * hash + Objects.hashCode(this.dateAjout);
        hash = 61 * hash + this.idParc;
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
        final Materiel other = (Materiel) obj;
        if (this.idMat != other.idMat) {
            return false;
        }
        if (this.etatMat != other.etatMat) {
            return false;
        }
        if (Float.floatToIntBits(this.QuantiteMat) != Float.floatToIntBits(other.QuantiteMat)) {
            return false;
        }
        if (this.idParc != other.idParc) {
            return false;
        }
        if (!Objects.equals(this.nomParc, other.nomParc)) {
            return false;
        }
        if (!Objects.equals(this.nomMat, other.nomMat)) {
            return false;
        }
        if (!Objects.equals(this.dateAjout, other.dateAjout)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Materiel{" + "nomParc=" + nomParc + ", nomMat=" + nomMat + ", etatMat=" + etatMat + ", QuantiteMat=" + QuantiteMat + ", dateAjout=" + dateAjout + '}';
    }
 
}

    