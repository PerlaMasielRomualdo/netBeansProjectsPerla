/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package writereadobject;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author cipri
 */
public class WriteReadObject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Write an object to a binary file
        //Crear objeto Output = salida
        //Objeto creado con sus tres atrubutos
        ObjectOutputStream fileOut;
        TestObject obj = new TestObject (1, "test1", 2.0);
        String fileName = JOptionPane.showInputDialog(null, "Enter the files's name");
        
        try {
            fileOut = new ObjectOutputStream(new FileOutputStream(fileName));
            fileOut.writeObject(obj);
            fileOut.close();//Nunca olvidar cerrar el flujo
        } catch (FileNotFoundException ex) {//Por si el nombre del ARCHIVO NO lo encuentra
            JOptionPane.showMessageDialog(null, "FileNotFound " + ex.getMessage());
        } catch (IOException ex) {//Por si hay error en el flujo
            JOptionPane.showMessageDialog(null, "IOExeception" + ex.getMessage());
        }
        //End write
        
        //Reads object from a binary file
        TestObject objIn;
        try {
            ObjectInputStream fileInt = new ObjectInputStream(new FileInputStream(fileName));
            objIn = (TestObject)fileInt.readObject();
            objIn.Display();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "FileNotFound " + ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "IOException " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "ClassNotFound " + ex.getMessage());
        }
    }
    
}
