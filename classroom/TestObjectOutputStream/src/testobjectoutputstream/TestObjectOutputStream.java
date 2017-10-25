/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testobjectoutputstream;

import com.sun.org.apache.xml.internal.security.utils.XMLUtils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author cipri
 */
public class TestObjectOutputStream {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //Se crea un objeto que abre el flujo bucando el archivo indicado
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Object.dat"));
            output.writeUTF("Perla");//Se escriben datos 
            output.writeDouble(158);
            output.writeObject(new Date());
            output.close();
        } catch (FileNotFoundException ex) {//Cacha el error del documento
            JOptionPane.showMessageDialog(null, "There is an error of FileNotFound" + ex.getMessage());
        } catch (IOException ex) {//Cacha el error del flujo
            JOptionPane.showMessageDialog(null, "There is of IO" + ex.getMessage());
        } 
        
        try {//Se crea un objeto de tipo input para leer el archivo
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("Object.dat"));
            
            String name = input.readUTF();
            Double heigth = input.readDouble();
            Date date =(Date) input.readObject();
            
            System.out.println("Name " + name + " Heigth " + heigth + " Date " + date);
            input.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "There is an error of FileNotFound" + ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "There is of IO" + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestObjectOutputStream.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
