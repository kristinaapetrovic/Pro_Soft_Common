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
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "@class")

/**
 *
 * @author Korisnik
 */
public class Menadzer implements OpstiDomenskiObjekat, Serializable {

    private String jmbg;
    private String imePrezime;
    private String email;
    private String lozinka;
    private java.util.Date datumRodjenja;
    private boolean aktivanNalog;
    private boolean prviLog;
    private List<StrucnaSprema> strucnaSprema;

    public Menadzer() {
    }

    public Menadzer(String jmbg, String imePrezime, String email, String lozinka, Date datumRodjenja, 
            boolean aktivanNalog, boolean prviLog, List<StrucnaSprema> strucnaSprema) {
        this.jmbg = jmbg;
        this.imePrezime = imePrezime;
        this.email = email;
        this.lozinka = lozinka;
        this.datumRodjenja = datumRodjenja;
        this.aktivanNalog = aktivanNalog;
        this.prviLog = prviLog;
        this.strucnaSprema = strucnaSprema;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public boolean isAktivanNalog() {
        return aktivanNalog;
    }

    public void setAktivanNalog(boolean aktivanNalog) {
        this.aktivanNalog = aktivanNalog;
    }

    public boolean isPrviLog() {
        return prviLog;
    }

    public void setPrviLog(boolean prviLog) {
        this.prviLog = prviLog;
    }

    public List<StrucnaSprema> getStrucnaSprema() {
        return strucnaSprema;
    }

    public void setStrucnaSprema(List<StrucnaSprema> strucnaSprema) {
        this.strucnaSprema = strucnaSprema;
    }

    @Override
    public String toString() {
        return imePrezime;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.jmbg);
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
        final Menadzer other = (Menadzer) obj;
        return Objects.equals(this.jmbg, other.jmbg);
    }

    @Override
    public String vratiImeKlase() {
        return "menadzer";
    }

    @Override
    public String vratiVrednostiAtributa() {
        java.sql.Date dat = new java.sql.Date(datumRodjenja.getTime());
        return "('" + jmbg + "','" + imePrezime + "','" + email + "','" + lozinka + "','" + dat + "'," + aktivanNalog + "," + prviLog + ")";
    }

    @Override
    public String postaviVrednostiAtributa() {
        java.sql.Date dat = new java.sql.Date(datumRodjenja.getTime());
        return "jmbg='" + jmbg + "',imePrezime='" + imePrezime + "',email='" + email + "',lozinka='" + lozinka + "',datumRodjenja='" + dat + "',aktivanNalog=" + aktivanNalog + ",prviLog=" + prviLog;
    }

    @Override
    public String vratiListuAtributa() {
        return "(jmbg,imePrezime,email,lozinka,datumRodjenja,aktivanNalog,prviLog)";
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return "jmbg='" + jmbg + "'" + " AND aktivanNalog=1";
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        return "jmbg='" + jmbg + "'" + " AND aktivanNalog=1";
    }

    @Override
    public String primarniKljuc() {
        return "'" + jmbg + "'";
    }

    @Override
    public boolean Napuni(ResultSet rs) {

        try {
            jmbg = rs.getString("jmbg");
            imePrezime = rs.getString("imePrezime");
            email = rs.getString("email");
            lozinka = rs.getString("lozinka");

            java.sql.Date datumSQL = rs.getDate("datumRodjenja");
            datumRodjenja = new java.util.Date(datumSQL.getTime());
            prviLog = rs.getBoolean("prviLog");
            aktivanNalog = rs.getBoolean("aktivanNalog");

        } catch (SQLException ex) {
            Logger.getLogger(Menadzer.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
    }

    @Override
    public String obrazacZaBrisanje() {
        return "aktivanNalog=0";
    }

    @Override
    public String vratiUslovPostoji() {
        return "jmbg='" + jmbg + "'" + " OR email='" + email + "'";
    }

    @Override
    public String nijeObrisan() {
        return "WHERE aktivanNalog=1";
    }

    @Override
    public String toJson() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Format za datum
        return "{"
                + "\"jmbg\": \"" + jmbg + "\", "
                + "\"imePrezime\": \"" + imePrezime + "\", "
                + "\"email\": \"" + email + "\", "
                + "\"lozinka\": \"" + lozinka + "\", "
                + "\"datumRodjenja\": \"" + (sdf.format(datumRodjenja)) + "\", "
                + "\"aktivanNalog\": " + aktivanNalog + ", "
                + "\"prviLog\": " + prviLog
                + "}";
    }
}
