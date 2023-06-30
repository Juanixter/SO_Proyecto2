/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import java.util.Random;
import java.math.RoundingMode;
import java.text.DecimalFormat;
/**
 *
 * @author roman
 */
public class Vehiculo {
    int contador;
    public Vehiculo next;    //Vehiculo que le sigue en su respectiva cola
    String calidad; 
    
    String marca;    //Esto indica si es Bugatti o Lamborghini
    public int id;
    int cola_prioridad;              
    double calidadRueda;
    double calidadMotor;
    double calidadCarroceria;
    double calidadChasis;  
    boolean puede_pasar; 
    
    public Vehiculo(String marca,int id) {
        this.contador = 0;
        this.next = null;
        this.calidad = "Sin calidad asignada"; 
        this.puede_pasar = false;
                
        this.marca = marca;
        this.id = id; 
        this.calidadRueda = ruedaCalidad();
        this.calidadMotor = motorCalidad();
        this.calidadCarroceria = carroceriaCalidad();
        this.calidadChasis = chasisCalidad();
        
        this.cola_prioridad = colaInicial(this.calidadRueda, this.calidadMotor, this.calidadCarroceria, this.calidadChasis);  
        
    }
    
    public void aumentar_contador() {
        if (this.cola_prioridad == 2 || this.cola_prioridad == 3) {
            //codigo para indicar que se ha completado una ronda de la inteligencia artificial
            this.contador++;               
        }
    }
     
    public void chequear_contador(Vehiculo v, Cola cola_baja, Cola cola_alta) {  
        if (v.contador == 8) {
            contador = 0;
            Cola.subir_cola(v, cola_baja, cola_alta);         
        } 
    }
    

    private double ruedaCalidad() {
       Random randomRueda = new Random();
       int nroAleatorioRueda = (int) (randomRueda.nextInt(100) + 1);
       if (nroAleatorioRueda <= 40) {
           this.calidadRueda = (double) (25 - 0.08*nroAleatorioRueda);
           //System.out.println("El numero aleatorio de Rueda es: "+nroAleatorioRueda+" y por ende es calidad");
           return this.calidadRueda;
       } else {
           this.calidadRueda = (double) (14 - 0.05*nroAleatorioRueda);
           //System.out.println("El numero aleatorio de Rueda es: "+nroAleatorioRueda+" y por ende no es calidad");
           return this.calidadRueda;
       }       
    }
    
    private double motorCalidad() {
        Random randomMotor = new Random();
        int nroAleatorioMotor = (int) (randomMotor.nextInt(100) + 1);
        if (nroAleatorioMotor <= 50) {
            this.calidadMotor = (double) (24 - 0.06*nroAleatorioMotor);
            //System.out.println("El numero aleatorio de Motor es: "+nroAleatorioMotor+ " y por ende es calidad");
            return this.calidadMotor;
        } else {
            this.calidadMotor = (double) (14 - 0.06*nroAleatorioMotor);
            //System.out.println("El numero aleatorio de Motor es: "+nroAleatorioMotor+ " y por ende no es calidad");
            return this.calidadMotor;
        }       
    }
       
    private double carroceriaCalidad() {
        Random randomCarroceria = new Random();
        int nroAleatorioCarroceria = (int) (randomCarroceria.nextInt(100) + 1);
        if (nroAleatorioCarroceria <= 60) {
            this.calidadCarroceria = (double) (23 - 0.05*nroAleatorioCarroceria);
            //System.out.println("El numero aleatorio de Carroceria es: "+nroAleatorioCarroceria+ " y por ende es calidad");
            return this.calidadCarroceria;
        } else {
            this.calidadCarroceria = (double) (15 - 0.08*nroAleatorioCarroceria);
            //System.out.println("El numero aleatorio de Carroceria es: "+nroAleatorioCarroceria+ " y por ende no es calidad");
            return this.calidadCarroceria;
        }       
    }
    
    private double chasisCalidad() {
        Random randomChasis = new Random();
        int nroAleatorioChasis = (int) (randomChasis.nextInt(100) + 1);
        if (nroAleatorioChasis <= 70) {
            this.calidadChasis = (double) (22 - 0.04*nroAleatorioChasis);
            //System.out.println("El numero aleatorio de Chasis es: "+nroAleatorioChasis + " y por ende es calidad");
            return this.calidadChasis;
        } else {
            this.calidadChasis = (double) (16 - 0.1*nroAleatorioChasis);
            //System.out.println("El numero aleatorio de Chasis es: "+nroAleatorioChasis + "y por ende no es calidad");
            return this.calidadChasis;
        }       
    }
    
    private int colaInicial(double ruedas,double motor,double carroceria,double chasis) {
        double determinanteColaInicial = 0.8185*ruedas + 0.7727*motor + 0.7270*carroceria + 0.6818*chasis;
        //System.out.println(determinanteColaInicial);
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);
        String numeroRedondeado = df.format(determinanteColaInicial);
        numeroRedondeado = numeroRedondeado.replace(',','.');
        determinanteColaInicial = Double.parseDouble(numeroRedondeado);
        //System.out.println(determinanteColaInicial);
        if (determinanteColaInicial < 40) {
            this.cola_prioridad = 3;
            return this.cola_prioridad;
        } else if (determinanteColaInicial >= 40 && determinanteColaInicial < 55) {
            this.cola_prioridad = 2;
            return this.cola_prioridad;
        } else {
            this.cola_prioridad = 1;
            return this.cola_prioridad;
        }
    }
    
 
    
    public void info1() {
        System.out.println("El vehiculo de la marca: " +this.marca+ " de id: "+this.id+ " esta compitiendo");
    }
    
    public void info2() {
        System.out.println("Ruedas: "+this.calidadRueda+" Motor: "+this.calidadMotor+" Carroceria: "
                +this.calidadCarroceria+" Chasis: "+this.calidadChasis+" Esta en la cola: "+this.cola_prioridad);
    }
}