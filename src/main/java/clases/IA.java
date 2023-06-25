/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.concurrent.Semaphore;

/**
 *
 * @author juanc
 */
public class IA extends Thread{
    
    public Semaphore mutex;
    private Vehiculo lamborghini;
    private Vehiculo bugatti;
    
    public IA(Semaphore mutex) {
        this.mutex = mutex;
    }
    
    @Override
    public void run() {
        while(true) {
            
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
    
}
