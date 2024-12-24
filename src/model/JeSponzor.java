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
public class JeSponzor implements OpstiDomenskiObjekat, Serializable{
    private Projekat projekat;
    private Sponzor sponzor;
    private boolean robni;
    private boolean novcani;
    private double iznos;

    public JeSponzor() {
    }

    public JeSponzor(Projekat projekat, Sponzor sponzor, boolean robni, boolean novcani, double iznos) {
        this.projekat = projekat;
        this.sponzor = sponzor;
        this.robni = robni;
        this.novcani = novcani;
        this.iznos = iznos;
    }

    public boolean isRobni() {
        return robni;
    }

    public void setRobni(boolean robni) {
        this.robni = robni;
    }

    public boolean isNovcani() {
        return novcani;
    }

    public void setNovcani(boolean novcani) {
        this.novcani = novcani;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    
    public Projekat getProjekat() {
        return projekat;
    }

    public void setProjekat(Projekat ugovor) {
        this.projekat = ugovor;
    }

    public Sponzor getSponzor() {
        return sponzor;
    }

    public void setSponzor(Sponzor sponzor) {
        this.sponzor = sponzor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.projekat);
        hash = 67 * hash + Objects.hashCode(this.sponzor);
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
        final JeSponzor other = (JeSponzor) obj;
        if (!Objects.equals(this.projekat, other.projekat)) {
            return false;
        }
        return Objects.equals(this.sponzor, other.sponzor);
    }

    @Override
    public String vratiImeKlase() {
        return "jesponzor";
    }

    @Override
    public String vratiVrednostiAtributa() {
        return "("+projekat.getRegBroj()+",'"+sponzor.getMaticniBroj()+"',"+robni+","+novcani+","+iznos+")";
    }

    @Override
    public String postaviVrednostiAtributa() {
        return "regBroj="+projekat.getRegBroj()+",maticniBroj='"+sponzor.getMaticniBroj()+"',robni="+robni+",novcani="+novcani+",iznos="+iznos;
    }

    @Override
    public String vratiListuAtributa() {
        return "(regBroj,maticniBroj,robni,novcani,iznos)";
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return "regBroj="+projekat.getRegBroj()+" AND maticniBroj='"+sponzor.getMaticniBroj()+"'";
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        return "regBroj="+projekat.getRegBroj()+" OR maticniBroj='"+sponzor.getMaticniBroj()+"'";
    }

    @Override
    public String primarniKljuc() {
        return vratiUslovZaNadjiSlog();
    }

    @Override
    public boolean Napuni(ResultSet rs) {
        
        try {
            robni=rs.getBoolean("robni");
            novcani=rs.getBoolean("novcani");
            iznos=rs.getDouble("iznos");
        } catch (SQLException ex) {
            Logger.getLogger(JeSponzor.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public String obrazacZaBrisanje() {
        return "";
    }

    @Override
    public String vratiUslovPostoji() {
        return "";
    }

    @Override
    public String nijeObrisan() {
        return "";
    }
    
    @Override
    public String toJson() {
    return "{"
            + "\"projekat\": \"" + (projekat.getRegBroj()) + "\", "
            + "\"sponzor\": \"" + (sponzor.getMaticniBroj()) + "\", "
            + "\"robni\": " + robni + ", "
            + "\"novcani\": " + novcani + ", "
            + "\"iznos\": " + iznos
            + "}";
}
    
}
