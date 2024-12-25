/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Korisnik
 */
public class Mesto implements OpstiDomenskiObjekat, Serializable {

    private String postanskiBroj;
    private String nazivMesto;
    private boolean obrisanoMesto;

    public Mesto() {
    }

    public Mesto(String postanskiBroj, String nazivMesto, boolean obrisanoMesto) {
        this.postanskiBroj = postanskiBroj;
        this.nazivMesto = nazivMesto;
        this.obrisanoMesto = obrisanoMesto;
    }

    public String getPostanskiBroj() {
        return postanskiBroj;
    }

    public void setPostanskiBroj(String postanskiBroj) {
        this.postanskiBroj = postanskiBroj;
    }

    public String getNazivMesto() {
        return nazivMesto;
    }

    public void setNazivMesto(String nazivMesto) {
        this.nazivMesto = nazivMesto;
    }

    public boolean isObrisano() {
        return obrisanoMesto;
    }

    public void setObrisano(boolean obrisano) {
        this.obrisanoMesto = obrisano;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.postanskiBroj);
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
        final Mesto other = (Mesto) obj;
        return Objects.equals(this.postanskiBroj, other.postanskiBroj);
    }

    

    @Override
    public String toString() {
        return nazivMesto;
    }

    @Override
    public String vratiImeKlase() {
        return "mesto";
    }

    @Override
    public String vratiVrednostiAtributa() {
        return "('" + postanskiBroj + "','" + nazivMesto + "'," + obrisanoMesto + ")";
    }

    @Override
    public String postaviVrednostiAtributa() {
        return "postanskiBroj='" + postanskiBroj + "',nazivMesto='" + nazivMesto + "',obrisanoMesto=" + obrisanoMesto;
    }

    @Override
    public String vratiListuAtributa() {
        return "(postanskiBroj,nazivMesto,obrisanoMesto)";
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return "postanskiBroj='" + postanskiBroj + "'" + " AND obrisanoMesto=0";
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        return "nazivMesto LIKE LOWER('" + nazivMesto.toLowerCase() + "%')" + " AND obrisanoMesto=0";
    }

    @Override
    public String primarniKljuc() {
        return "'" + postanskiBroj + "'";
    }

    @Override
    public boolean Napuni(ResultSet rs) {

        try {
            postanskiBroj = rs.getString("postanskiBroj");
            nazivMesto = rs.getString("nazivMesto");
            obrisanoMesto = rs.getBoolean("obrisanoMesto");
        } catch (SQLException ex) {
            Logger.getLogger(Mesto.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
    }

    @Override
    public String obrazacZaBrisanje() {
        return "obrisanoMesto=1";
    }

    @Override
    public String vratiUslovPostoji() {
        return "postanskiBroj='" + postanskiBroj + "'";
    }

    @Override
    public String nijeObrisan() {
        return "WHERE obrisanoMesto=0";
    }

    @Override
    public String toJson() {
        return "{"
                + "\"postanskiBroj\": \"" + postanskiBroj + "\", "
                + "\"nazivMesto\": \"" + nazivMesto + "\", "
                + "\"obrisanoMesto\": " + obrisanoMesto
                + "}";
    }

}
