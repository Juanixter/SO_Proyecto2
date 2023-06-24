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
    
    public IA(Semaphore mutex) {
        this.mutex = mutex;
    }
    
    @Override
    public void run() {
        while(true) {
            
        }
    }
    
}
