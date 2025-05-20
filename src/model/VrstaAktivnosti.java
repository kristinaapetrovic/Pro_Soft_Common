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
public class VrstaAktivnosti implements OpstiDomenskiObjekat, Serializable {

    private int idVrstaAktivnosti;
    private String nazivVrstaAktivnosti;
    private boolean obrisanaVA;

    public VrstaAktivnosti() {
    }

    public VrstaAktivnosti(int idVrstaAktivnosti, String nazivVrstaAktivnosti, boolean obrisana) {
        this.idVrstaAktivnosti = idVrstaAktivnosti;
        this.nazivVrstaAktivnosti = nazivVrstaAktivnosti;
        this.obrisanaVA = obrisana;
    }

    public int getIdVrstaAktivnosti() {
        return idVrstaAktivnosti;
    }

    public void setIdVrstaAktivnosti(int idVrstaAktivnosti) {
        this.idVrstaAktivnosti = idVrstaAktivnosti;
    }

    public String getNazivVrstaAktivnosti() {
        return nazivVrstaAktivnosti;
    }

    public void setNazivVrstaAktivnosti(String nazivVrstaAktivnosti) {
        this.nazivVrstaAktivnosti = nazivVrstaAktivnosti;
    }

    public boolean isObrisana() {
        return obrisanaVA;
    }

    public void setObrisana(boolean obrisana) {
        this.obrisanaVA = obrisana;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.idVrstaAktivnosti;
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
        final VrstaAktivnosti other = (VrstaAktivnosti) obj;
        return this.idVrstaAktivnosti == other.idVrstaAktivnosti;
    }

    @Override
    public String toString() {
        return nazivVrstaAktivnosti;
    }

    @Override
    public String vratiImeKlase() {
        return "vrstaaktivnosti";
    }

    @Override
    public String vratiVrednostiAtributa() {
        return "(" + idVrstaAktivnosti + ",'" + nazivVrstaAktivnosti + "'," + obrisanaVA + ")";
    }

    @Override
    public String postaviVrednostiAtributa() {
        return "idVrstaAktivnosti=" + idVrstaAktivnosti + ",nazivVrstaAktivnosti='" + nazivVrstaAktivnosti + "',obrisanaVA=" + obrisanaVA;
    }

    @Override
    public String vratiListuAtributa() {
        return "(idVrstaAktivnosti,nazivVrstaAktivnosti,obrisanaVA)";
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return "idVrstaAktivnosti=" + idVrstaAktivnosti + " AND obrisanaVA=0";
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        return "nazivVrstaAktivnosti LIKE LOWER('" + nazivVrstaAktivnosti.toLowerCase() + "%')" + " AND obrisanaVA=0";
    }

    @Override
    public String primarniKljuc() {
        return idVrstaAktivnosti + "";
    }

    @Override
    public boolean Napuni(ResultSet rs) {

        try {
            idVrstaAktivnosti = rs.getInt("idVrstaAktivnosti");
            nazivVrstaAktivnosti = rs.getString("nazivVrstaAktivnosti");
            obrisanaVA = rs.getBoolean("obrisanaVA");
        } catch (SQLException ex) {
            Logger.getLogger(VrstaAktivnosti.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
    }

    @Override
    public String obrazacZaBrisanje() {
        return "obrisanaVA=1";
    }

    @Override
    public String vratiUslovPostoji() {
        return "idVrstaAktivnosti=" + idVrstaAktivnosti;
    }

    @Override
    public String nijeObrisan() {
        return "WHERE obrisanaVA=0";
    }

    @Override
    public String toJson() {
        return "{"
                + "\"idVrstaAktivnosti\": " + idVrstaAktivnosti + ", "
                + "\"nazivVrstaAktivnosti\": \"" + nazivVrstaAktivnosti + "\", "
                + "\"obrisanaVA\": " + obrisanaVA
                + "}";
    }

}
