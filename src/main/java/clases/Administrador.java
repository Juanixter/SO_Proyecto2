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
public class Administrador extends Thread{
    
    public Semaphore mutex;
    private Cola p1;
    private Cola p2;
    private Cola p3;
    private Cola r;
    
    public Administrador(Semaphore mutex) {
        this.mutex = mutex;
        // TODO
        // Cada timestamp Chequea p1, sin nada chequea p2, sin nada chequea p3 --> pasa a ia.
        // Cada timestamp, prob 40% de sacar el primer vehiculo de la cola, se coloca p1.
        // Cada timestamp chequea contador de c/vehiculo p2,p3. Si = 8 se aumenta su prioridad.
        // Cada dos timestamps, se añade un vehiculo a la cola que se esta revisando.
    }
    
    @Override
    public void run() {
        while (true) {
            
        }
    }
    
}
