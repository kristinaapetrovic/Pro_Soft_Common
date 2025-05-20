/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "@class")

/**
 *
 * @author Korisnik
 */
public class Sponzor implements OpstiDomenskiObjekat, Serializable {

    private String maticniBroj;
    private String nazivFirme;
    private String vlasnik;
    private boolean obrisanGI;
    private Mesto mesto;

    public Sponzor() {
    }

    public Sponzor(String maticniBroj, String nazivFirme, String vlasnik, boolean obrisan, Mesto mesto) {
        this.maticniBroj = maticniBroj;
        this.nazivFirme = nazivFirme;
        this.vlasnik = vlasnik;
        this.obrisanGI = obrisan;
        this.mesto = mesto;
    }

    public String getMaticniBroj() {
        return maticniBroj;
    }

    public void setMaticniBroj(String maticniBroj) {
        this.maticniBroj = maticniBroj;
    }

    public String getNazivFirme() {
        return nazivFirme;
    }

    public void setNazivFirme(String nazivFirme) {
        this.nazivFirme = nazivFirme;
    }

    public String getVlasnik() {
        return vlasnik;
    }

    public void setVlasnik(String vlasnik) {
        this.vlasnik = vlasnik;
    }

    public boolean isObrisan() {
        return obrisanGI;
    }

    public void setObrisan(boolean obrisan) {
        this.obrisanGI = obrisan;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.maticniBroj);
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
        final Sponzor other = (Sponzor) obj;
        return Objects.equals(this.maticniBroj, other.maticniBroj);
    }

    @Override
    public String toString() {
        return nazivFirme + ", " + vlasnik;
    }

    @Override
    public String vratiImeKlase() {
        return "sponzor";
    }

    @Override
    public String vratiVrednostiAtributa() {
        return "('" + maticniBroj + "','" + nazivFirme + "','" + vlasnik + "'," + obrisanGI + ",'" + mesto.getPostanskiBroj() + "')";
    }

    @Override
    public String postaviVrednostiAtributa() {
        return "maticniBroj='" + maticniBroj + "',nazivFirme='" + nazivFirme + "',vlasnik='" + vlasnik + "',obrisanGI=" + obrisanGI + ",postanskiBroj='" + mesto.getPostanskiBroj() + "'";
    }

    @Override
    public String vratiListuAtributa() {
        return "(maticniBroj,nazivFirme,vlasnik,obrisanGI,postanskiBroj)";
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return "maticniBroj='" + maticniBroj + "' AND obrisanGI=0";
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        return "postanskiBroj=" + mesto.getPostanskiBroj() + " AND obrisanGI=0";
    }

    @Override
    public String primarniKljuc() {
        return "'" + maticniBroj + "'";
    }

    @Override
    public boolean Napuni(ResultSet rs) {

        try {
            maticniBroj = rs.getString("maticniBroj");
            nazivFirme = rs.getString("nazivFirme");
            vlasnik = rs.getString("vlasnik");
            obrisanGI = rs.getBoolean("obrisanGI");
        } catch (SQLException ex) {
            Logger.getLogger(Sponzor.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
    }

    @Override
    public String obrazacZaBrisanje() {
        return "obrisanGI=1";
    }

    @Override
    public String vratiUslovPostoji() {
        return "maticniBroj='" + maticniBroj + "'";
    }

    @Override
    public String nijeObrisan() {
        return "WHERE obrisanGI=0";
    }

    @Override
    public String toJson() {
    return "{"
            + "\"maticniBroj\": \"" + maticniBroj + "\", "
            + "\"nazivFirme\": \"" + nazivFirme + "\", "
            + "\"vlasnik\": \"" + vlasnik + "\", "
            + "\"obrisanGI\": " + obrisanGI
            + "}";
}

}
