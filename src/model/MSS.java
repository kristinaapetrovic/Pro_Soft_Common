/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "@class")

/**
 *
 * @author Korisnik
 */
public class MSS implements OpstiDomenskiObjekat, Serializable {

    private Menadzer menadzer;
    private StrucnaSprema strucnaSprema;
    private boolean obrisanaMSS;
    private Date datumMSS;

    public MSS() {
    }

    public MSS(Menadzer menadzer, StrucnaSprema strucnaSprema, boolean obrisanaMSS, Date datumMSS) {
        this.menadzer = menadzer;
        this.strucnaSprema = strucnaSprema;
        this.obrisanaMSS = obrisanaMSS;
        this.datumMSS = datumMSS;
    }

    public boolean isObrisanaMSS() {
        return obrisanaMSS;
    }

    public void setObrisanaMSS(boolean obrisanaMSS) {
        this.obrisanaMSS = obrisanaMSS;
    }

    public Date getDatumMSS() {
        return datumMSS;
    }

    public void setDatumMSS(Date datumMSS) {
        this.datumMSS = datumMSS;
    }

    public boolean isObrisana() {
        return obrisanaMSS;
    }

    public void setObrisana(boolean obrisana) {
        this.obrisanaMSS = obrisana;
    }

    public Menadzer getMenadzer() {
        return menadzer;
    }

    public void setMenadzer(Menadzer menadzer) {
        this.menadzer = menadzer;
    }

    public StrucnaSprema getStrucnaSprema() {
        return strucnaSprema;
    }

    public void setStrucnaSprema(StrucnaSprema strucnaSprema) {
        this.strucnaSprema = strucnaSprema;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.menadzer);
        hash = 29 * hash + Objects.hashCode(this.strucnaSprema);
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
        final MSS other = (MSS) obj;
        if (!Objects.equals(this.menadzer, other.menadzer)) {
            return false;
        }
        return Objects.equals(this.strucnaSprema, other.strucnaSprema);
    }

    @Override
    public String vratiImeKlase() {
        return "mss";
    }

    @Override
    public String vratiVrednostiAtributa() {
        java.sql.Date datum = datumMSS == null ? null : new java.sql.Date(datumMSS.getTime());
        return "('" + menadzer.getJmbg() + "'," + strucnaSprema.getIdStrucnaSprema() + ",'" + datum + "'," + obrisanaMSS + ")";
    }

    @Override
    public String postaviVrednostiAtributa() {
        java.sql.Date datum = datumMSS == null ? null : new java.sql.Date(datumMSS.getTime());
        return "jmbg='" + menadzer.getJmbg() + "',idStrucnaSprema=" + strucnaSprema.getIdStrucnaSprema() + ",datumMSS='" + datum + "',obrisanaMSS=" + obrisanaMSS;
    }

    @Override
    public String vratiListuAtributa() {
        return "(jmbg,idStrucnaSprema,datumMSS,obrisanaMSS)";
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return "jmbg='" + menadzer.getJmbg() + "' AND idStrucnaSprema=" + strucnaSprema.getIdStrucnaSprema() + " AND obrisanaMSS=0";
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        return "jmbg='" + menadzer.getJmbg() + "' OR idStrucnaSprema=" + strucnaSprema.getIdStrucnaSprema() + " AND obrisanaMSS=0";
    }

    @Override
    public String primarniKljuc() {
        return "'" + menadzer.getJmbg() + "'," + strucnaSprema.getIdStrucnaSprema();
    }

    @Override
    public boolean Napuni(ResultSet rs) {
        try {
            java.sql.Date datum = rs.getDate("datumMSS");

            datumMSS = new java.util.Date(datum.getTime());
        } catch (SQLException ex) {
            Logger.getLogger(MSS.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public String obrazacZaBrisanje() {
        return "obrisanaMSS=1";
    }

    @Override
    public String vratiUslovPostoji() {
        return "jmbg='" + menadzer.getJmbg() + "' AND idStrucnaSprema=" + strucnaSprema.getIdStrucnaSprema();
    }

    @Override
    public String nijeObrisan() {
        return "WHERE obrisanaMSS=0";
    }

    @Override
    public String toJson() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Format za datum
        return "{"
                + "\"menadzer\": \"" + (menadzer.getJmbg()) + "\", "
                + "\"strucnaSprema\": \"" + (strucnaSprema.getIdStrucnaSprema()) + "\", "
                + "\"obrisanaMSS\": " + obrisanaMSS + ", "
                + "\"datumMSS\": \"" + (sdf.format(datumMSS)) + "\""
                + "}";
    }
}
