/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestordeagenda;
import java.io.*;

/**
 *
 * @author cipri
 */
public class ItemAgenda implements Serializable{//Serializar el objeto y escribirlo en el archivo
    private String nom, tel;
    private int postal;
    //Constructor
    public ItemAgenda(String n, String t, int p){
        this.nom = n;
        this.tel = t;
        this.postal = p;
    }
    //Crear metodo que va a mostrar el contenido de nuestros atributos
    public String toString(){
        return nom + ": " + tel + "(" + postal + ")";
    }
}
