/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import java.util.Scanner;
import javax.swing.JFileChooser;
//import sun.misc.ObjectInputFilter;

/**
 *
 * @author emmanuel
 */
public class PersonFile {

    private String filename;// se crea para guerdar el nobre que se creara 
    private PrintWriter output;//imprimir datos
    static private File file;//se guarda en la variable file
    
    public void countfile(){
        JFileChooser fileChooser = new JFileChooser(); // Se crea un objeto de tipo JFlieChooser
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            // Get the selected file
            File file = fileChooser.getSelectedFile(); // Obtenemos todo lo relcionado al archivo no el archivo en si
            try {
                //Create a Scanner for the file
                Scanner input = new Scanner(file);
                //Read text from the file
                int count = 0;
                while (input.hasNext()/*hasNext detecta si el archivo tiene renglones*/) {
                    
                    String numero = input.next();
                    count++;
                }
                JOptionPane.showMessageDialog(null, count);
                input.close();
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null/*se refiere a la posiscion en la que se mostraria el error, se le pone el nombre de la ventana para que aparesca en esa ventana centrado el error*/, ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "No file Selected");
        }
        
    }
    

    public void createFile(String name) throws FileNotFoundException {
        this.filename = name;
        this.file = new File(this.filename);//guardar
        if (!this.file.exists()) {//si el nombre del archivo exixte hagrga datos al archivo
            this.output = new PrintWriter(new FileOutputStream(this.file, true));//imprime
        } else {
            JOptionPane.showMessageDialog(null, "The file already exists");//
        }
    }

    public void WritePerson(String dni, String name, String lastName, String birthDay, String place) throws FileNotFoundException {
        if (this.file.exists()) {// si existe guarda datos 
            this.output = new PrintWriter(new FileOutputStream(this.file, true));
            this.output.println(dni + " " + name + " " + lastName + " " + birthDay + " " + place);//ingresa 
        } else {
            JOptionPane.showMessageDialog(null, "The file already exists");
        }
        this.output.close();
    }

    public void ReadPersonFile() {
        JFileChooser fileChooser = new JFileChooser(); // Se crea un objeto de tipo JFlieChooser
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            // Get the selected file
            File file = fileChooser.getSelectedFile(); // Obtenemos todo lo relcionado al archivo no el archivo en si
            try {
                //Create a Scanner for the file
                Scanner input = new Scanner(file);
                //Read text from the file
                int contador = 0;
                while (input.hasNext()/*hasNext detecta si el archivo tiene renglones*/) {
                    System.out.println(input.nextLine());
//                    String numero = input.next();
//                    contador++;
                }
//                JOptionPane.showMessageDialog(null, contador);
                input.close();
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null/*se refiere a la posiscion en la que se mostraria el error, se le pone el nombre de la ventana para que aparesca en esa ventana centrado el error*/, ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "No file Selected");
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        int num;
        PersonFile person = new PersonFile();
        String nameFile = " ", name = " ", dni = " ", lastname = " ", birthDay = " ", place = " ";
        do {
            num = Integer.parseInt(JOptionPane.showInputDialog("Elija Un Numero: \n 1.Crear archivo \n 2.Escribir Datos \n 3.Leer archivo \n 4.Numero de Palabras \n 5.Salir "));
            switch (num) {
                case 1:
                    nameFile = JOptionPane.showInputDialog("Ingrese el Nombre para su archivo ", nameFile);
                    person.createFile(nameFile);
                    break;
                case 2:
                    dni = JOptionPane.showInputDialog("Ingrese su DNI ", dni);
                    name = JOptionPane.showInputDialog("Ingrese su Nombre ", name);
                    lastname = JOptionPane.showInputDialog("Ingrese su Apellido ", lastname);
                    birthDay = JOptionPane.showInputDialog("ingrese el dia de su Cumpleaños ", birthDay);
                    place = JOptionPane.showInputDialog("Ingrese su Lugar de nacimiento ", place);
                    person.WritePerson(dni, name, lastname, birthDay, place);
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Elija el archivo a leer");
                    person.ReadPersonFile();
                    break;
                  case 4:
                   person.countfile();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Cerrar");
                    break;
            }
        } while (num != 5);
    }

}
