/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.sql.ResultSet;

/**
 *
 * @author Korisnik
 */
public interface OpstiDomenskiObjekat extends Serializable {

    public String vratiImeKlase();//za sve

    public String vratiVrednostiAtributa(); //za svaki vraca vr, za insert 

    public String postaviVrednostiAtributa(); //stavlja vesdnosti atributima, za update
    
    public String vratiListuAtributa(); //vraca listu atributa, za insert
    
    public String vratiUslovZaNadjiSlog(); //prema primarnom kljucu, vraca jedan tacno read
    
    public String vratiUslovZaNadjiSlogove(); //prema spoljnim kljucevima, moze da vrati vise za reda
    
    public String primarniKljuc(); //samo vrednost prrim kljuca
    
    public boolean Napuni(ResultSet rs); //puni sve osim spoljnjeg kljuca

    public String obrazacZaBrisanje(); //posto ne brisemo stvarno, samo postavlja atr obrisano na true obrisano=true
    
    public String vratiUslovPostoji(); //samo ispituje primarni kljuc

    public String nijeObrisan(); //stavlja obrisan=false
    
    public String toJson(); 
    
}
