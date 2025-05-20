/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "@class")

/**
 *
 * @author Korisnik
 */
public class StrucnaSprema implements OpstiDomenskiObjekat, Serializable {

    private int idStrucnaSprema;
    private String nazivStrucnaSprema;
    private boolean obrisanaSS;

    public StrucnaSprema() {
    }

    public StrucnaSprema(int idStrucnaSprema, String nazivStrucnaSprema, boolean obrisana) {
        this.idStrucnaSprema = idStrucnaSprema;
        this.nazivStrucnaSprema = nazivStrucnaSprema;
        this.obrisanaSS = obrisana;
    }

    public int getIdStrucnaSprema() {
        return idStrucnaSprema;
    }

    public void setIdStrucnaSprema(int idStrucnaSprema) {
        this.idStrucnaSprema = idStrucnaSprema;
    }

    public String getNazivStrucnaSprema() {
        return nazivStrucnaSprema;
    }

    public void setNazivStrucnaSprema(String nazivStrucnaSprema) {
        this.nazivStrucnaSprema = nazivStrucnaSprema;
    }

    public boolean isObrisana() {
        return obrisanaSS;
    }

    public void setObrisana(boolean obrisana) {
        this.obrisanaSS = obrisana;
    }

    @Override
    public String toString() {
        return nazivStrucnaSprema;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idStrucnaSprema;
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
        final StrucnaSprema other = (StrucnaSprema) obj;
        return this.idStrucnaSprema == other.idStrucnaSprema;
    }

    @Override
    public String vratiImeKlase() {
        return "strucnasprema";
    }

    @Override
    public String vratiVrednostiAtributa() {
        return "(" + idStrucnaSprema + ",'" + nazivStrucnaSprema + "'," + obrisanaSS + ")";
    }

    @Override
    public String postaviVrednostiAtributa() {
        return "idStrucnaSprema=" + idStrucnaSprema + ",nazivStrucnaSprema='" + nazivStrucnaSprema + "',obrisanaSS=" + obrisanaSS;
    }

    @Override
    public String vratiListuAtributa() {
        return "(idStrucnaSprema,nazivStrucnaSprema,obrisanaSS)";
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return "idStrucnaSprema=" + idStrucnaSprema+" AND obrisanaSS=0";
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        return "nazivStrucnaSprema LIKE LOWER('"+nazivStrucnaSprema.toLowerCase()+"%')"+" AND obrisanaSS=0";
    }

    @Override
    public String primarniKljuc() {
        return "idStrucnaSprema=" + idStrucnaSprema;
    }

    @Override
    public boolean Napuni(ResultSet rs) {

        try {
            idStrucnaSprema=rs.getInt("idStrucnaSprema");
            nazivStrucnaSprema=rs.getString("nazivStrucnaSprema");
            obrisanaSS=rs.getBoolean("obrisanaSS");
        } catch (SQLException ex) {
            Logger.getLogger(StrucnaSprema.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        
        return true;
    }

    @Override
    public String obrazacZaBrisanje() {
        return "obrisanaSS=1";
    }

    @Override
    public String vratiUslovPostoji() {
        return "idStrucnaSprema=" + idStrucnaSprema;
    }

    @Override
    public String nijeObrisan() {
        return "WHERE obrisanaSS=0";
    }

    @Override
    public String toJson() {
    return "{"
            + "\"idStrucnaSprema\": " + idStrucnaSprema + ", "
            + "\"nazivStrucnaSprema\": \"" + nazivStrucnaSprema + "\", "
            + "\"obrisanaSS\": " + obrisanaSS
            + "}";
}

   

}
