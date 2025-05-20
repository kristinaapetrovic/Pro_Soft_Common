/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.io.Serializable;
import java.sql.ResultSet;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "@class")
@JsonSubTypes({
     @JsonSubTypes.Type(value = Mesto.class, name = "Mesto"),
    @JsonSubTypes.Type(value = Menadzer.class, name = "Menadzer"),
    @JsonSubTypes.Type(value = StrucnaSprema.class, name = "StrucnaSprema"),
    @JsonSubTypes.Type(value = Aktivnost.class, name = "Aktivnost"),
    @JsonSubTypes.Type(value = VrstaAktivnosti.class, name = "VrstaAktivnosti"),
    @JsonSubTypes.Type(value = JeSponzor.class, name = "JeSponzor"),
    @JsonSubTypes.Type(value = Sponzor.class, name = "Sponzor"),
    @JsonSubTypes.Type(value = MSS.class, name = "MSS"),
    @JsonSubTypes.Type(value = Projekat.class, name = "Projekat")
})
/**
 *
 * @author Korisnik
 */
public interface OpstiDomenskiObjekat extends Serializable {

    public String vratiImeKlase();

    public String vratiVrednostiAtributa(); 

    public String postaviVrednostiAtributa(); 

    public String vratiListuAtributa(); 

    public String vratiUslovZaNadjiSlog(); 

    public String vratiUslovZaNadjiSlogove(); 

    public String primarniKljuc(); 

    public boolean Napuni(ResultSet rs); 

    public String obrazacZaBrisanje();

    public String vratiUslovPostoji(); 

    public String nijeObrisan();

    public String toJson();

}
