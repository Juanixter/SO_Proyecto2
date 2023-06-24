/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package clases;


/**
 *
 * @author juanc
 */
public class Main {

    public static void main(String[] args) {
       // System.out.println("Hello World!");
        Vehiculo v1 = new Vehiculo("Lambo","Destructor",1);
        v1.info1();
        v1.info2();
       
        Vehiculo v2 = new Vehiculo("Lambo","Demoledor",2);
        v2.info1();
        v2.info2();

        Vehiculo v3 = new Vehiculo("Buga","Crack",1);     
        v3.info1();
        v3.info2();
      
    }
}
