/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import Pantallas.Pantalla;
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
    private boolean addVehicle;
    private Pantalla pantalla;

    //id de siguiente lambo
    private int lambo_id;

    //id de siguiente bugatti
    private int bugatti_id;

    public Administrador(Semaphore mutex, Pantalla pantalla) {
        this.mutex = mutex;
        this.addVehicle = false;
        this.pantalla = pantalla;

        inicializarVehiculos("lambo");
        inicializarVehiculos("bugatti");
    }

    @Override
    public void run() {
        while (true) {

            try {
                mutex.acquire();
                pantalla.pintarColas();

                //chequeo de colas, se pasan a la ia
                Vehiculo lambo = chequearColasLambo();
                pantalla.lamborghini = lambo;
                pantalla.idLambo.setText("L" + String.valueOf(lambo.id));
                Vehiculo bugatti = chequearColasBugatti();
                pantalla.bugatti = bugatti;
                pantalla.idBugatti.setText("B" + String.valueOf(bugatti.id));

                //Añade nuevo vehiculo cada dos timestamps
                añadirVehiculos();

                //40% probabilidad de sacar head de refuerzo y encolar en p1
                chequeoRefuerzo();
                
                //chequea los contadores de todos los vehiculos de cola 2 y 3 de ambas marcas, si debe subri sube y su contador regresa a 0
                chequeoContadores(2, "lambo");
                chequeoContadores(3, "lambo");
                chequeoContadores(2, "bugatti");
                chequeoContadores(3, "bugatti");
                
                pantalla.pintarColas();
                mutex.release();
                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private Vehiculo chequearColasLambo() {
        Vehiculo vehiculo;
        if (pantalla.lambo_p1.isEmpty()) {
            if (pantalla.lambo_p2.isEmpty()) {
                vehiculo = pantalla.lambo_p3.readHead();
                pantalla.lambo_p3.desencolar();
            } else {
                vehiculo = pantalla.lambo_p2.readHead();
                pantalla.lambo_p2.desencolar();
            }
        } else {
            vehiculo = pantalla.lambo_p1.readHead();
            pantalla.lambo_p1.desencolar();
        }
        return vehiculo;
    }

    private Vehiculo chequearColasBugatti() {
        Vehiculo vehiculo;
        if (pantalla.bugatti_p1.isEmpty()) {
            if (pantalla.bugatti_p2.isEmpty()) {
                vehiculo = pantalla.bugatti_p3.readHead();
                pantalla.bugatti_p3.desencolar();
            } else {
                vehiculo = pantalla.bugatti_p2.readHead();
                pantalla.bugatti_p2.desencolar();
            }
        } else {
            vehiculo = pantalla.bugatti_p1.readHead();
            pantalla.bugatti_p1.desencolar();
        }
        return vehiculo;
    }

    private void chequeoRefuerzo() {
        if (!pantalla.lambo_r.isEmpty()) {
            Random random = new Random();
            float prob = random.nextFloat(1);
            if (prob <= 0.4) {
                Vehiculo chosen = pantalla.lambo_r.readHead();
                pantalla.lambo_r.desencolar();
                pantalla.lambo_p1.encolar(chosen);
            }
        }

        if (!pantalla.bugatti_r.isEmpty()) {
            Random random = new Random();
            float prob = random.nextFloat(1);
            if (prob <= 0.4) {
                Vehiculo chosen = pantalla.bugatti_r.readHead();
                pantalla.bugatti_r.desencolar();
                pantalla.bugatti_p1.encolar(chosen);
            }
        }
    }

    private void chequeoContadores(int prioridad, String marca) {
        switch (prioridad) {
            case 2 -> {
                if (marca.equals("lambo")) {

                    Vehiculo vehiculo = pantalla.lambo_p2.readHead();
                    Cola auxp2 = new Cola(2, "lambo");
                    while (vehiculo != null) {
                        pantalla.lambo_p2.desencolar();
                        if (vehiculo.contador >= 8) {
                            pantalla.lambo_p1.encolar(vehiculo);
                            vehiculo.contador = 0;
                        } else {
                            auxp2.encolar(vehiculo);
                            vehiculo.contador++;
                        }
                        vehiculo = pantalla.lambo_p2.readHead();
                    }
                    pantalla.lambo_p2 = auxp2;

                } else if (marca.equals("bugatti")) {

                    Vehiculo vehiculo = pantalla.bugatti_p2.readHead();
                    Cola auxp2 = new Cola(2, "bugatti");
                    while (vehiculo != null) {
                        pantalla.bugatti_p2.desencolar();
                        if (vehiculo.contador >= 8) {
                            pantalla.bugatti_p1.encolar(vehiculo);
                            vehiculo.contador = 0;
                        } else {
                            auxp2.encolar(vehiculo);
                            vehiculo.contador++;
                        }
                        vehiculo = pantalla.bugatti_p2.readHead();
                    }
                    pantalla.bugatti_p2 = auxp2;

                } else {
                    System.out.println("marca erronea método chequeoContadores");
                }
                break;
            }
            case 3 -> {
                if (marca.equals("lambo")) {

                    Vehiculo vehiculo = pantalla.lambo_p3.readHead();
                    Cola auxp2 = new Cola(3, "lambo");
                    while (vehiculo != null) {
                        pantalla.lambo_p3.desencolar();
                        if (vehiculo.contador >= 8) {
                            pantalla.lambo_p2.encolar(vehiculo);
                            vehiculo.contador = 0;
                        } else {
                            auxp2.encolar(vehiculo);
                            vehiculo.contador++;
                        }
                        vehiculo = pantalla.lambo_p3.readHead();
                    }
                    pantalla.lambo_p3 = auxp2;

                } else if (marca.equals("bugatti")) {

                    Vehiculo vehiculo = pantalla.bugatti_p3.readHead();
                    Cola auxp2 = new Cola(3, "bugatti");
                    while (vehiculo != null) {
                        pantalla.bugatti_p3.desencolar();
                        if (vehiculo.contador >= 8) {
                            pantalla.bugatti_p2.encolar(vehiculo);
                            vehiculo.contador = 0;
                        } else {
                            auxp2.encolar(vehiculo);
                            vehiculo.contador++;
                        }
                        vehiculo = pantalla.bugatti_p3.readHead();
                    }
                    pantalla.bugatti_p3 = auxp2;

                } else {
                    System.out.println("marca erronea método chequeoContadores");
                }
                break;
            }
            default ->
                System.out.println("prioridad erronea método chequeoContadores");
        }
    }

    private void inicializarVehiculos(String marca) {
        if (marca.equals("lambo")) {
            for (int i = 1; i < 11; i++) {
                Vehiculo vehiculo = new Vehiculo("Lamborghini", i);
                switch (vehiculo.cola_prioridad) {
                    case 1 -> {
                        pantalla.lambo_p1.encolar(vehiculo);
                    }
                    case 2 -> {
                        pantalla.lambo_p2.encolar(vehiculo);
                    }
                    case 3 -> {
                        pantalla.lambo_p3.encolar(vehiculo);
                    }
                    default ->
                        System.out.println("Error en inicializarVehiculos, cola_prioridad fuera de rango lambo");
                }
            }
            this.lambo_id = 11;
        } else if (marca.equals("bugatti")) {
            for (int i = 1; i < 11; i++) {
                Vehiculo vehiculo = new Vehiculo("Bugatti", i);
                switch (vehiculo.cola_prioridad) {
                    case 1 -> {
                        pantalla.bugatti_p1.encolar(vehiculo);
                    }
                    case 2 -> {
                        pantalla.bugatti_p2.encolar(vehiculo);
                    }
                    case 3 -> {
                        pantalla.bugatti_p3.encolar(vehiculo);
                    }
                    default ->
                        System.out.println("Error en inicializarVehiculos, cola_prioridad fuera de rango bugatti");
                }
            }
            this.bugatti_id = 11;
        } else {
            System.out.println("Error de marca método inicializarVehiculos()");
        }
    }

    private void añadirVehiculos() {
        if (this.addVehicle) {
            Random random = new Random();
            float prob = random.nextFloat(1);
            if (prob <= 0.8) {

                Vehiculo lambo = new Vehiculo("Lamborghini", this.lambo_id);
                this.lambo_id++;
                switch (lambo.cola_prioridad) {
                    case 1 -> {
                        pantalla.lambo_p1.encolar(lambo);
                    }
                    case 2 -> {
                        pantalla.lambo_p2.encolar(lambo);
                    }
                    case 3 -> {
                        pantalla.lambo_p3.encolar(lambo);
                    }
                    default ->
                        System.out.println("Error en añadirVehiculos, cola_prioridad fuera de rango lambo");
                }

                Vehiculo bugatti = new Vehiculo("Bugatti", this.bugatti_id);
                this.bugatti_id++;
                switch (bugatti.cola_prioridad) {
                    case 1 -> {
                        pantalla.bugatti_p1.encolar(bugatti);
                    }
                    case 2 -> {
                        pantalla.bugatti_p2.encolar(bugatti);
                    }
                    case 3 -> {
                        pantalla.bugatti_p3.encolar(bugatti);
                    }
                    default ->
                        System.out.println("Error en añadirVehiculos, cola_prioridad fuera de rango bugatti");
                }
            
            }
        }
        this.addVehicle = !this.addVehicle;
    }

}
