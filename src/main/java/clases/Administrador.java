/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanc
 */
public class Administrador extends Thread {

    public Semaphore mutex;
    private IA ia;
    private boolean addVehicle;

    //Colas de prioridad de lamborghini
    private Cola lambo_p1;
    private Cola lambo_p2;
    private Cola lambo_p3;
    private Cola lambo_r;
    private int lambo_id;

    //Colas de prioridad de bugatti
    private Cola bugatti_p1;
    private Cola bugatti_p2;
    private Cola bugatti_p3;
    private Cola bugatti_r;
    private int bugatti_id;

    public Administrador(Semaphore mutex, IA ia) {
        this.mutex = mutex;
        this.ia = ia;
        this.addVehicle = false;
        // TODO
        // Cada timestamp chequea contador de c/vehiculo p2,p3. Si = 8 se aumenta su prioridad.
    }

    @Override
    public void run() {
        while (true) {

            try {
                mutex.acquire();

                //chequeo de colas, se pasan a la ia, añade nuevo vehiculo cada dos timestamps
                Vehiculo lambo = chequearColasLambo();
                ia.setLamborghini(lambo);
                Vehiculo bugatti = chequearColasBugatti();
                ia.setBugatti(bugatti);

                //40% probabilidad de sacar head de refuerzo y encolar en p1
                chequeoRefuerzo();

                //Chequea los contadores de todos los vehiculos en las colas p2 y p3 para ver si se aumneta su prioridad
                chequeoContadores();

                mutex.release();
            } catch (InterruptedException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private Vehiculo chequearColasLambo() {
        if (lambo_p3.isEmpty()) {
            if (lambo_p2.isEmpty()) {
                if (this.addVehicle) {
                    Vehiculo nuevo = new Vehiculo("Lamboghini", "a", this.lambo_id);
                    this.lambo_p1.encolar(nuevo);
                    this.lambo_id++;
                    this.addVehicle = !this.addVehicle;
                }
                return lambo_p1.readHead();
            } else {
                if (this.addVehicle) {
                    Vehiculo nuevo = new Vehiculo("Lamboghini", "a", this.lambo_id);
                    this.lambo_p2.encolar(nuevo);
                    this.lambo_id++;
                    this.addVehicle = !this.addVehicle;
                }
                return lambo_p2.readHead();
            }
        } else {
            if (this.addVehicle) {
                Vehiculo nuevo = new Vehiculo("Lamboghini", "a", this.lambo_id);
                this.lambo_p3.encolar(nuevo);
                this.lambo_id++;
                this.addVehicle = !this.addVehicle;
            }
            return lambo_p3.readHead();
        }
    }

    private Vehiculo chequearColasBugatti() {
        if (bugatti_p3.isEmpty()) {
            if (bugatti_p2.isEmpty()) {
                if (this.addVehicle) {
                    Vehiculo nuevo = new Vehiculo("Bugatti", "a", this.bugatti_id);
                    this.bugatti_p1.encolar(nuevo);
                    this.bugatti_id++;
                    this.addVehicle = !this.addVehicle;
                }
                return bugatti_p1.readHead();
            } else {
                if (this.addVehicle) {
                    Vehiculo nuevo = new Vehiculo("Bugatti", "a", this.bugatti_id);
                    this.bugatti_p2.encolar(nuevo);
                    this.bugatti_id++;
                    this.addVehicle = !this.addVehicle;
                }
                return bugatti_p2.readHead();
            }
        } else {
            if (this.addVehicle) {
                Vehiculo nuevo = new Vehiculo("Bugatti", "a", this.bugatti_id);
                this.bugatti_p3.encolar(nuevo);
                this.bugatti_id++;
                this.addVehicle = !this.addVehicle;
            }
            return bugatti_p3.readHead();
        }
    }

    private void chequeoRefuerzo() {
        if (!lambo_r.isEmpty()) {
            Random random = new Random();
            float prob = random.nextFloat(1);
            if (prob <= 0.4) {
                Vehiculo chosen = lambo_r.readHead();
                lambo_r.desencolar();
                lambo_p1.encolar(chosen);
            }
        }

        if (!bugatti_r.isEmpty()) {
            Random random = new Random();
            float prob = random.nextFloat(1);
            if (prob <= 0.4) {
                Vehiculo chosen = bugatti_r.readHead();
                bugatti_r.desencolar();
                bugatti_p1.encolar(chosen);
            }
        }
    }

    private void chequeoContadores() {

    }

}
