/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package writereadobject;

import java.io.Serializable;

/**
 *
 * @author cipri
 *///Para que permita que el objeto sea leido y escrito en un archivo binarios
public class TestObject implements Serializable{
    //Se declaran sus atrubutos 
    private int id;
    private String text;
    public double number;
    
    //Se crean los metodos
    public TestObject(int id, String text, double number){//Inicializa mediante un contructor
        this.id = id;
        this.text = text;
        this.number = number;
    }
    
    public void Display(){
        System.out.println(this.id);
        System.out.println(this.text);
        System.out.println(this.number);
    }
}
