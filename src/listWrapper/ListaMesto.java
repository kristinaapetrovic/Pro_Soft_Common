/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listWrapper;

import java.util.ArrayList;
import java.util.List;
import model.Mesto;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "@class")
/**
 *
 * @author Korisnik
 */
public class ListaMesto {
    private List<Mesto> lista=new ArrayList<>();

    public List<Mesto> getLista() {
        return lista;
    }

    public void setLista(List<Mesto> lista) {
        this.lista = lista;
    }
    
}
