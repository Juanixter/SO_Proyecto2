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

        this.lambo_p1 = new Cola(1, "lambo");
        this.lambo_p2 = new Cola(2, "lambo");
        this.lambo_p3 = new Cola(3, "lambo");
        this.lambo_r = new Cola(4, "lambo");

        this.bugatti_p1 = new Cola(1, "bugatti");
        this.bugatti_p2 = new Cola(2, "bugatti");
        this.bugatti_p3 = new Cola(3, "bugatti");
        this.bugatti_r = new Cola(4, "bugatti");

        inicializarVehiculos("lambo");
        inicializarVehiculos("bugatti");
    }

    @Override
    public void run() {
        while (true) {

            try {
                mutex.acquire();

                //chequeo de colas, se pasan a la ia
                Vehiculo lambo = chequearColasLambo();
                ia.setLamborghini(lambo);
                Vehiculo bugatti = chequearColasBugatti();
                ia.setBugatti(bugatti);

                //Añade nuevo vehiculo cada dos timestamps
                añadirVehiculos();
                
                //40% probabilidad de sacar head de refuerzo y encolar en p1
                chequeoRefuerzo();

                chequeoContadores(2, "lambo");
                chequeoContadores(3, "lambo");
                chequeoContadores(2, "bugatti");
                chequeoContadores(3, "bugatti");

                mutex.release();
            } catch (InterruptedException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private Vehiculo chequearColasLambo() {
        if (lambo_p3.isEmpty()) {
            if (lambo_p2.isEmpty()) {
                return lambo_p1.readHead();
            } else {
                return lambo_p2.readHead();
            }
        } else {
            return lambo_p3.readHead();
        }
    }

    private Vehiculo chequearColasBugatti() {
        if (bugatti_p3.isEmpty()) {
            if (bugatti_p2.isEmpty()) {
                return bugatti_p1.readHead();
            } else {
                return bugatti_p2.readHead();
            }
        } else {
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

    private void chequeoContadores(int prioridad, String marca) {
        switch (prioridad) {
            case 2 -> {
                if (marca.equals("lambo")) {

                    Vehiculo vehiculo = this.lambo_p2.readHead();
                    Cola auxp2 = new Cola(2, "lambo");
                    while (vehiculo != null) {
                        this.lambo_p2.desencolar();
                        if (vehiculo.contador >= 8) {
                            this.lambo_p1.encolar(vehiculo);
                            vehiculo.contador = 0;
                        } else {
                            auxp2.encolar(vehiculo);
                        }
                    }
                    this.lambo_p2 = auxp2;

                } else if (marca.equals("bugatti")) {

                    Vehiculo vehiculo = this.bugatti_p2.readHead();
                    Cola auxp2 = new Cola(2, "bugatti");
                    while (vehiculo != null) {
                        this.bugatti_p2.desencolar();
                        if (vehiculo.contador >= 8) {
                            this.bugatti_p1.encolar(vehiculo);
                            vehiculo.contador = 0;
                        } else {
                            auxp2.encolar(vehiculo);
                        }
                    }
                    this.bugatti_p2 = auxp2;

                } else {
                    System.out.println("marca erronea método chequeoContadores");
                }
                break;
            }
            case 3 -> {
                if (marca.equals("lambo")) {

                    Vehiculo vehiculo = this.lambo_p3.readHead();
                    Cola auxp2 = new Cola(3, "lambo");
                    while (vehiculo != null) {
                        this.lambo_p3.desencolar();
                        if (vehiculo.contador >= 8) {
                            this.lambo_p2.encolar(vehiculo);
                            vehiculo.contador = 0;
                        } else {
                            auxp2.encolar(vehiculo);
                        }
                    }
                    this.lambo_p3 = auxp2;

                } else if (marca.equals("bugatti")) {

                    Vehiculo vehiculo = this.bugatti_p3.readHead();
                    Cola auxp2 = new Cola(3, "bugatti");
                    while (vehiculo != null) {
                        this.bugatti_p3.desencolar();
                        if (vehiculo.contador >= 8) {
                            this.bugatti_p2.encolar(vehiculo);
                            vehiculo.contador = 0;
                        } else {
                            auxp2.encolar(vehiculo);
                        }
                    }
                    this.bugatti_p3 = auxp2;

                } else {
                    System.out.println("marca erronea método chequeoContadores");
                }
                break;
            }
            default ->
                System.out.println("prioridad erronea método chequeoContadores");
        }
    }

    //
    private void inicializarVehiculos(String marca) {
        if (marca.equals("lambo")) {
            for (int i = 1; i < 11; i++) {
                Vehiculo vehiculo = new Vehiculo("Lamborghini", i);
                switch (vehiculo.cola_prioridad) {
                    case 1 -> {
                        this.lambo_p1.encolar(vehiculo);
                    }
                    case 2 -> {
                        this.lambo_p2.encolar(vehiculo);
                    }
                    case 3 -> {
                        this.lambo_p3.encolar(vehiculo);
                    }
                    default -> System.out.println("Error en inicializarVehiculos, cola_prioridad fuera de rango lambo");
                }
            }
            this.lambo_id = 11;
        } else if (marca.equals("bugatti")) {
            for (int i = 1; i < 11; i++) {
                Vehiculo vehiculo = new Vehiculo("Bugatti", i);
                switch(vehiculo.cola_prioridad) {
                    case 1 -> {
                        this.bugatti_p1.encolar(vehiculo);
                    }
                    case 2 -> {
                        this.bugatti_p2.encolar(vehiculo);
                    }
                    case 3 -> {
                        this.bugatti_p3.encolar(vehiculo);
                    }
                    default -> System.out.println("Error en inicializarVehiculos, cola_prioridad fuera de rango bugatti");
                }
            }
        } else {
            System.out.println("Error de marca método inicializarVehiculos()");
        }
    }

    private void añadirVehiculos() {
        if (this.addVehicle) {
            Vehiculo lambo = new Vehiculo("Lamborghini", this.lambo_id);
            this.lambo_id++;
            switch(lambo.cola_prioridad) {
                    case 1 -> {
                        this.bugatti_p1.encolar(lambo);
                    }
                    case 2 -> {
                        this.bugatti_p2.encolar(lambo);
                    }
                    case 3 -> {
                        this.bugatti_p3.encolar(lambo);
                    }
                    default -> System.out.println("Error en añadirVehiculos, cola_prioridad fuera de rango lambo");
                }
            
            Vehiculo bugatti = new Vehiculo("Bugatti", this.bugatti_id);
            this.bugatti_id++;
            switch(bugatti.cola_prioridad) {
                    case 1 -> {
                        this.bugatti_p1.encolar(bugatti);
                    }
                    case 2 -> {
                        this.bugatti_p2.encolar(bugatti);
                    }
                    case 3 -> {
                        this.bugatti_p3.encolar(bugatti);
                    }
                    default -> System.out.println("Error en añadirVehiculos, cola_prioridad fuera de rango bugatti");
                }
        }
        this.addVehicle = !this.addVehicle;
    }

}
