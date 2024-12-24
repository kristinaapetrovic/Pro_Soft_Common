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
public class Projekat implements OpstiDomenskiObjekat, Serializable {

    private String regBroj;
    private String nazivProjekta;
    private String opisProjekta;
    private double budzet;
    private int trajanje;
    private java.util.Date datumPocetka;
    private java.util.Date datumZavrsetka;
    private Menadzer menadzer;
    private boolean zavrsen;

    public Projekat() {
    }

    public Projekat(String regBroj, String nazivProjekta, String opisProjekta, double budzet, int trajanje, Date datumPocetka, Date datumZavrsetka, Menadzer menadzer, boolean zavrsen) {
        this.regBroj = regBroj;
        this.nazivProjekta = nazivProjekta;
        this.opisProjekta = opisProjekta;
        this.budzet = budzet;
        this.trajanje = trajanje;
        this.datumPocetka = datumPocetka;
        this.datumZavrsetka = datumZavrsetka;
        this.menadzer = menadzer;
        this.zavrsen = zavrsen;
    }

    public String getOpisProjekta() {
        return opisProjekta;
    }

    public void setOpisProjekta(String opisProjekta) {
        this.opisProjekta = opisProjekta;
    }

    public String getRegBroj() {
        return regBroj;
    }

    public void setRegBroj(String regBroj) {
        this.regBroj = regBroj;
    }

    public String getNazivProjekta() {
        return nazivProjekta;
    }

    public void setNazivProjekta(String nazivProjekta) {
        this.nazivProjekta = nazivProjekta;
    }

    public double getBudzet() {
        return budzet;
    }

    public void setBudzet(double budzet) {
        this.budzet = budzet;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }

    public Date getDatumPocetka() {
        return datumPocetka;
    }

    public void setDatumPocetka(Date datumPocetka) {
        this.datumPocetka = datumPocetka;
    }

    public Date getDatumZavrsetka() {
        return datumZavrsetka;
    }

    public void setDatumZavrsetka(Date datumZavrsetka) {
        this.datumZavrsetka = datumZavrsetka;
    }

    public Menadzer getMenadzer() {
        return menadzer;
    }

    public void setMenadzer(Menadzer menadzer) {
        this.menadzer = menadzer;
    }

    public boolean isZavrsen() {
        return zavrsen;
    }

    public void setZavrsen(boolean zavrsen) {
        this.zavrsen = zavrsen;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.regBroj);
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
        final Projekat other = (Projekat) obj;
        return this.regBroj == other.regBroj;
    }

    @Override
    public String toString() {
        return regBroj + ", " + nazivProjekta;
    }

    @Override
    public String vratiImeKlase() {
        return "projektniugovor";
    }

    @Override
    public String vratiVrednostiAtributa() {
        java.sql.Date datumOD = new java.sql.Date(datumPocetka.getTime());
        java.sql.Date datumDO = new java.sql.Date(datumZavrsetka.getTime());
        return "('" + regBroj + "','" + nazivProjekta + "','" + opisProjekta + "'," + budzet + "," + trajanje + ",'" + datumOD + "','" + datumDO + "'," + zavrsen + ",'" + menadzer.getJmbg() + "')";

    }

    @Override
    public String postaviVrednostiAtributa() {
        java.sql.Date datumOD = new java.sql.Date(datumPocetka.getTime());
        java.sql.Date datumDO = new java.sql.Date(datumZavrsetka.getTime());
        return "regBroj='" + regBroj + "',nazivProjekta='" + nazivProjekta + "',opisProjekta='" + opisProjekta + "',budzet=" + budzet + ",trajanje=" + trajanje + ",datumPocetka='" + datumOD + "',datumZavrsetka='" + datumDO + "',zavrsen=" + zavrsen + ",jmbg='" + menadzer.getJmbg() + "'";
    }

    @Override
    public String vratiListuAtributa() {
        return "(regBroj,nazivProjekta,opisProjekta,budzet,trajanje,datumPocetka,datumZavrsetka,zavrsen,jmbg)";
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return "regBroj='" + regBroj+"'";
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        return "jmbg='" + menadzer.getJmbg();
    }

    @Override
    public String primarniKljuc() {
        return "'"+regBroj + "'";
    }

    @Override
    public boolean Napuni(ResultSet rs) {

        try {
            regBroj = rs.getString("regBroj");
            nazivProjekta = rs.getString("nazivProjekta");
            opisProjekta = rs.getString("opisProjekta");
            budzet = rs.getDouble("budzet");
            trajanje = rs.getInt("trajanje");
            java.sql.Date datumOD = rs.getDate("datumPocetka");
            java.sql.Date datumDO = rs.getDate("datumZavrsetka");

            datumPocetka = new java.util.Date(datumOD.getTime());

            datumZavrsetka = new java.util.Date(datumDO.getTime());

            zavrsen = rs.getBoolean("zavrsen");

        } catch (SQLException ex) {
            Logger.getLogger(Projekat.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
    }

    @Override
    public String obrazacZaBrisanje() {
        return vratiUslovZaNadjiSlog();
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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Format za datum
        return "{"
                + "\"regBroj\":\" " + regBroj + "\", "
                + "\"nazivProjekta\": \"" + nazivProjekta + "\", "
                + "\"opisProjekta\": \"" + opisProjekta + "\", "
                + "\"budzet\": " + budzet + ", "
                + "\"trajanje\": " + trajanje + ", "
                + "\"datumPocetka\": \"" + (sdf.format(datumPocetka)) + "\", "
                + "\"datumZavrsetka\": \"" + (sdf.format(datumZavrsetka)) + "\", "
                + "\"menadzer\": \"" + (menadzer.getJmbg()) + "\", "
                + "\"zavrsen\": " + zavrsen
                + "}";
    }

}
