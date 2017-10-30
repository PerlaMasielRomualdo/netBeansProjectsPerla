/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestordeagenda;

/**
 *
 * @author cipri
 */
public class GestorDeAgenda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Crear objetos para la agenda
        ItemAgenda ia1 =new ItemAgenda("Perla Masiel Romualdo","2381875013", 75740);
        ItemAgenda ia2 =new ItemAgenda("Luis Alberto Cordova","2381119229", 75790);
        ItemAgenda ia3 =new ItemAgenda("Luz Estrella Galaxia Cortes", "2381179796", 75857);
        
        //Crear una agenda
        Agenda a1 = new Agenda();
        a1.insertar(ia1);
        a1.insertar(ia2);
        a1.insertar(ia3);
        
        //Escribir el archivo
        a1.guardarAgenda("myAgenda.dat");
        
        //Leer el archivo
        Agenda resAgenda = Agenda.leerAgenda("myAgenda.dat");
        System.out.println(resAgenda);
    }
    
}
