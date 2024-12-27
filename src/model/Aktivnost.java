/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Korisnik
 */
public class Aktivnost implements OpstiDomenskiObjekat, Serializable {

    private Projekat projektniUgovor;
    private int redniBroj;
    private String nazivAktivnosti;
    private String opisAktivnosti;
    private boolean obavljena;
    private VrstaAktivnosti vrstaAktivnosti;
    private Date datumRealizacije;

    public Aktivnost() {
    }

    public Aktivnost(Projekat projektniUgovor, int redniBroj, String nazivAktivnosti, String opisAktivnosti, boolean obavljena, VrstaAktivnosti vrstaAktivnosti, Date datumRealizacije) {
        this.projektniUgovor = projektniUgovor;
        this.redniBroj = redniBroj;
        this.nazivAktivnosti = nazivAktivnosti;
        this.opisAktivnosti = opisAktivnosti;
        this.obavljena = obavljena;
        this.vrstaAktivnosti = vrstaAktivnosti;
        this.datumRealizacije = datumRealizacije;
    }

    public Date getDatumRealizacije() {
        return datumRealizacije;
    }

    public void setDatumRealizacije(Date datumRealizacije) {
        this.datumRealizacije = datumRealizacije;
    }

    public Projekat getProjektniUgovor() {
        return projektniUgovor;
    }

    public void setProjektniUgovor(Projekat projektniUgovor) {
        this.projektniUgovor = projektniUgovor;
    }

    public int getRedniBroj() {
        return redniBroj;
    }

    public void setRedniBroj(int redniBroj) {
        this.redniBroj = redniBroj;
    }

    public String getNazivAktivnosti() {
        return nazivAktivnosti;
    }

    public void setNazivAktivnosti(String nazivAktivnosti) {
        this.nazivAktivnosti = nazivAktivnosti;
    }

    public String getOpisAktivnosti() {
        return opisAktivnosti;
    }

    public void setOpisAktivnosti(String opisAktivnosti) {
        this.opisAktivnosti = opisAktivnosti;
    }

    public VrstaAktivnosti getVrstaAktivnosti() {
        return vrstaAktivnosti;
    }

    public void setVrstaAktivnosti(VrstaAktivnosti vrstaAktivnosti) {
        this.vrstaAktivnosti = vrstaAktivnosti;
    }

    public boolean isObavljena() {
        return obavljena;
    }

    public void setObavljena(boolean obavljena) {
        this.obavljena = obavljena;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.projektniUgovor);
        hash = 59 * hash + this.redniBroj;
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
        final Aktivnost other = (Aktivnost) obj;
        if (this.redniBroj != other.redniBroj) {
            return false;
        }
        return Objects.equals(this.projektniUgovor, other.projektniUgovor);
    }

    @Override
    public String toString() {
        return nazivAktivnosti;
    }

    @Override
    public String vratiImeKlase() {
        return "aktivnost";
    }

    @Override
    public String vratiVrednostiAtributa() {
        java.sql.Date datum = datumRealizacije == null ? null : new java.sql.Date(datumRealizacije.getTime());
        if (datum != null) {
            return "(" + projektniUgovor.getRegBroj() + "," + redniBroj + ",'" + nazivAktivnosti + "','" + opisAktivnosti + "'," + obavljena + "," + vrstaAktivnosti.getIdVrstaAktivnosti() + ",'" + datum + "')";
        }
        return "('" + projektniUgovor.getRegBroj() + "'," + redniBroj + ",'" + nazivAktivnosti + "','" + opisAktivnosti + "'," + obavljena + "," + vrstaAktivnosti.getIdVrstaAktivnosti() + "," + null + ")";
    }

    @Override
    public String postaviVrednostiAtributa() {
        java.sql.Date datum = datumRealizacije == null ? null : new java.sql.Date(datumRealizacije.getTime());
        if (datum != null) {
            return "nazivAktivnosti='" + nazivAktivnosti + "',opisAktivnosti='" + opisAktivnosti + "',obavljena=" + obavljena + ",idVrstaAktivnosti=" + vrstaAktivnosti.getIdVrstaAktivnosti() + ", datumRealizacije='" + datum + "'";
        }
        return "nazivAktivnosti='" + nazivAktivnosti + "',opisAktivnosti='" + opisAktivnosti + "',obavljena=" + obavljena + ",idVrstaAktivnosti=" + vrstaAktivnosti.getIdVrstaAktivnosti() + ", datumRealizacije=" + null;
    }

    @Override
    public String vratiListuAtributa() {
        return "(regBroj,redniBroj,nazivAktivnosti,opisAktivnosti,obavljena,idVrstaAktivnosti, datumRealizacije)";
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return "regBroj='" + projektniUgovor.getRegBroj() + "' AND redniBroj=" + redniBroj;
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        return "regBroj='" + projektniUgovor.getRegBroj()+"'";
    }

    @Override
    public String primarniKljuc() {
        return "" + redniBroj;
    }

    @Override
    public boolean Napuni(ResultSet rs) {

        try {
            this.redniBroj = rs.getInt("redniBroj");
            this.nazivAktivnosti = rs.getString("nazivAktivnosti");
            this.opisAktivnosti = rs.getString("opisAktivnosti");
            this.obavljena = rs.getBoolean("obavljena");

            java.sql.Date datum = rs.getDate("datumRealizacije");
            this.datumRealizacije = datum == null ? null : new java.util.Date(datum.getTime());
        } catch (SQLException ex) {
            Logger.getLogger(Aktivnost.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;

    }

    @Override
    public String obrazacZaBrisanje() {
        return null;
    }

    @Override
    public String vratiUslovPostoji() {
        return vratiUslovZaNadjiSlog();
    }

    @Override
    public String nijeObrisan() {
        return "";
    }

    @Override
    public String toJson() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return "{"
                //+ "\"projektniUgovor\": \"" + (projektniUgovor != null ? projektniUgovor.getRegBroj() : "null") + "\", "
                + "\"redniBroj\": " + redniBroj + ", "
                + "\"nazivAktivnosti\": \"" + nazivAktivnosti + "\", "
                + "\"opisAktivnosti\": \"" + opisAktivnosti + "\", "
                + "\"obavljena\": " + obavljena + ", "
                //+ "\"vrstaAktivnosti\": \"" + (vrstaAktivnosti.getIdVrstaAktivnosti()) + "\", "
                + "\"datumRealizacije\": \"" + (sdf.format(datumRealizacije)) + "\""
                + "}";
    }

}
