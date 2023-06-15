/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import java.util.Random;
/**
 *
 * @author roman
 */
public class Vehiculo {
    int contador;
    Vehiculo next;    //Vehiculo que le sigue en su respectiva cola
    String calidad; 
    
    String marca;    //Esto indica si es Bugatti o Lamborghini
    String nombre;
    int id;
    int prioridad;         //refuerzo sera nivel con valor 4     
    boolean carroceria_calidad;
    boolean chasis_calidad;
    boolean motor_calidad;
    boolean rueda_calidad;
    boolean puede_pasar;
    
   
    
    public Vehiculo(String marca,String nombre,int id,boolean carroceria_calidad,boolean chasis_calidad,boolean motor_calidad,boolean rueda_calidad,boolean puede_pasar) {
        this.contador = 0;
        this.next = null;
        this.calidad = "Sin calidad asignada";
        this.prioridad = 4; 
                
        this.marca = marca;
        this.nombre = nombre;
        this.id = id;      
        this.carroceria_calidad = carroceriaCalidad();
        this.chasis_calidad = chasisCalidad();
        this.motor_calidad = motorCalidad();
        this.rueda_calidad = ruedaCalidad();
        this.puede_pasar = false;
    }
    
    public void aumentar_contador() {
        //cada vez que se complete una ronda en la inteligencia artificial.
    }
    
    private boolean carroceriaCalidad() {
        Random randomCarroceria = new Random();
        int calidadCarroceria = (int) (randomCarroceria.nextInt(100) + 1);
        if (calidadCarroceria <= 60) {
            return true;
        } else {
            return false;
        }       
    }
    
    private boolean chasisCalidad() {
        Random randomChasis = new Random();
        int calidadChasis = (int) (randomChasis.nextInt(100) + 1);
        if (calidadChasis <= 70) {
            return true;
        } else {
            return false;
        }       
    }
    
    private boolean motorCalidad() {
        Random randomMotor = new Random();
        int calidadMotor = (int) (randomMotor.nextInt(100) + 1);
        if (calidadMotor <= 50) {
            return true;
        } else {
            return false;
        }       
    }
    
    private boolean ruedaCalidad() {
        Random randomRueda = new Random();
        int calidadRueda = (int) (randomRueda.nextInt(100) + 1);
        if (calidadRueda <= 40) {
            return true;
        } else {
            return false;
        }       
    }
    
//    public String info(String marca,String nombre,int id,String calidad) {
//        return ("El vehiculo: "+nombre+" de la marca: "+marca+" de id: "+id"y calidad: "+calidad+" esta compitiendo");
//    }
    
}