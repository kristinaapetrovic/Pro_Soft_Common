/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hashing;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import model.Menadzer;

/**
 *
 * @author Korisnik
 */
public class Hash {
    
    //salt je deo koji se dodaje na samo lozinku, radnom je generisan, povecava sigurnost
    public static String kriptuj(String sifra) throws NoSuchAlgorithmException{
        String salt="ArtLik$jdna";
        MessageDigest md=MessageDigest.getInstance("SHA-256");
        String kombinacija=sifra+salt;
        byte[] kript=md.digest(kombinacija.getBytes());
        return Base64.getEncoder().encodeToString(kript);
    }
    
    
    //po istom algoritnu od zadate lozinke kreira kriptovanu, a zatim proverava da li se ona poklapa sa kriptovanom
//    public static boolean proveriLozinku(String sifra, String salt, String kriptovanaLozinka) throws NoSuchAlgorithmException{
//        String noviKript=kriptuj(sifra, salt);
//        return noviKript.equals(kriptovanaLozinka);
//    }
//    
//    

    
    
    
    
    
}
