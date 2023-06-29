/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author juanc
 */
public class IA extends Thread{
    
    public Semaphore mutex;
    public int segundos;
    private Administrador admin;
    
    public JLabel pista;
    public JLabel estadoIA;
    public JLabel estadoL;
    public JLabel estadoB;
    public JLabel idLambo;
    public JLabel idBugatti;
    public JLabel timeL;
    public JLabel timeB;
    public JLabel nroGanadoresL;
    public JLabel nroGanadoresB;
    public JLabel listaGanadores;
    
    private Vehiculo lamborghini;
    private Vehiculo bugatti;  
    
    private float climaL;
    private float climaB;
    private float terrenoL;
    private float terrenoB;
    
    public IA(Semaphore mutex, JLabel pista, JLabel estadoIA, JLabel estadoL, JLabel estadoB, JLabel idLambo, JLabel idBugatti, JLabel timeL, JLabel timeB, JLabel nroGanadoresL, JLabel nroGanadoresB, JLabel listaGanadores) {
        this.mutex = mutex;
        this.segundos = 10;
        this.pista = pista;
        this.estadoIA = estadoIA;
    }
    
    @Override
    public void run() {
        while(true) {
            try {
                mutex.acquire();
                seleccionarPista();
                ejecutarSimulacion();
                
                
                mutex.release();
            } catch (InterruptedException ex) {
                Logger.getLogger(IA.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * @param lamborghini the lamborghini to set
     */
    public void setLamborghini(Vehiculo lamborghini) {
        this.lamborghini = lamborghini;
    }

    /**
     * @param bugatti the bugatti to set
     */
    public void setBugatti(Vehiculo bugatti) {
        this.bugatti = bugatti;
    }

    private void ejecutarSimulacion() {
        estadoIA.setText("Decidiendo");
        Random random = new Random();        
        float prob = random.nextFloat(1);
        try {
            sleep(this.segundos * 1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(IA.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (prob <= 0.4) {  //Caso hay un ganador
            
        } else if (prob <= 0.67) {  //Caso empate
            
        } else { //Caso no ocurre la carrera
            estadoIA.setText("Fallo de vehiculos");
            
        }
    }

    private void seleccionarPista() {
        estadoIA.setText("Seleccionando la pista");
        try {
            sleep(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(IA.class.getName()).log(Level.SEVERE, null, ex);
        }
        Random random = new Random();
        int prob = random.nextInt(60) + 1;
        if (prob <= 10) {
            Funciones.scaleImage(this.pista, "pista1.PNG");
            this.climaL = (float) 1.60;
            this.climaB = 1;
            this.terrenoL = 1;
            this.terrenoB = (float) 1.40;
        } else if (prob <= 20) {
            Funciones.scaleImage(this.pista, "pista2.PNG");
            this.climaL = (float) 1.40;
            this.climaB = 1;
            this.terrenoL = (float) 1.60;
            this.terrenoB = 1;
        } else if (prob <= 30) {
            Funciones.scaleImage(this.pista, "pista3.PNG");
            this.climaL = (float) 1.20;
            this.climaB = 1;
            this.terrenoL = 1;
            this.terrenoB = (float) 1.20;
        } else if (prob <= 40) {
            Funciones.scaleImage(this.pista, "pista4.PNG");
            this.climaL = 1;
            this.climaB = (float) 1.60;
            this.terrenoL = (float) 1.40;
            this.terrenoB = 1;
        } else if (prob <= 50) {
            Funciones.scaleImage(this.pista, "pista5.PNG");
            this.climaL = 1;
            this.climaB = (float) 1.40;
            this.terrenoL = 1;
            this.terrenoB = (float) 1.60;
        } else {
            Funciones.scaleImage(this.pista, "pista6.PNG");
            this.climaL = 1;
            this.climaB = (float) 1.20;
            this.terrenoL = (float) 1.20;
            this.terrenoB = 1;
        }
    }

    /**
     * @param admin the admin to set
     */
    public void setAdmin(Administrador admin) {
        this.admin = admin;
    }
    
}
