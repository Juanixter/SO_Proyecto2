/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import Pantallas.Pantalla;
import java.awt.Color;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanc
 */
public class IA extends Thread {

    public Semaphore mutex;
    public Pantalla pantalla;

    private float climaL;
    private float climaB;
    private float terrenoL;
    private float terrenoB;

    public IA(Semaphore mutex, Pantalla pantalla) {
        this.mutex = mutex;
        this.pantalla = pantalla;
    }

    @Override
    public void run() {
        while (true) {
            try {
                mutex.acquire();
                if (pantalla.lamborghini != null) {

                    seleccionarPista();
                    ejecutarSimulacion();
                    restaurarValores();
                    pantalla.pintarColas();

                }
                mutex.release();
                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(IA.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void ejecutarSimulacion() {
        pantalla.estadoIA.setText("Decidiendo");
        pantalla.estadoL.setText("Esperando");
        pantalla.estadoB.setText("Esperando");
        Random random = new Random();
        float prob = random.nextFloat(1);

        int min1 = random.nextInt(60) + 1;
        int seg1 = random.nextInt(60) + 1;
        int min2 = random.nextInt(60) + 1;
        int seg2 = random.nextInt(60) + 1;

        String m1 = fixTime(min1);
        String m2 = fixTime(min2);
        String s1 = fixTime(seg1);
        String s2 = fixTime(seg2);

        try {
            sleep(pantalla.segundos * 1000);  // espera de 10 seg ajustable con el jslider
        } catch (InterruptedException ex) {
            Logger.getLogger(IA.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (prob <= 0.4) {  //Caso hay un ganador
            pantalla.estadoIA.setText("Seleccionando ganador");
            int nroGanadoresB = Integer.parseInt(pantalla.nroGanadoresBugatti.getText());
            int nroGanadoresL = Integer.parseInt(pantalla.nroGanadoresLambo.getText());
            String colaGanadores = pantalla.colaGanadores.getText();

            float ptosLambo = (float) ((pantalla.lamborghini.calidadRueda * this.terrenoL) + pantalla.lamborghini.calidadMotor + (pantalla.lamborghini.calidadChasis + pantalla.lamborghini.calidadCarroceria) * this.climaL);
            float ptosBugatti = (float) ((pantalla.bugatti.calidadRueda * this.terrenoB) + pantalla.bugatti.calidadMotor + (pantalla.bugatti.calidadChasis + pantalla.bugatti.calidadCarroceria) * this.climaB);

            if (ptosLambo > ptosBugatti) {
                pantalla.estadoL.setText("Ganador");
                pantalla.estadoL.setForeground(Color.GREEN);
                pantalla.estadoB.setText("Perdedor");
                pantalla.estadoB.setForeground(Color.BLUE);
                pantalla.estadoIA.setText("Selección completa");

                String timeLambo;
                String timeBugatti;
                if (min1 > min2) {
                    timeLambo = m1 + ":" + s1;
                    timeBugatti = m2 + ":" + s2;
                } else if (min2 > min1) {
                    timeLambo = m2 + ":" + s1;
                    timeBugatti = m1 + ":" + s2;
                } else {
                    if (seg1 > seg2) {
                        timeLambo = m1 + ":" + s1;
                        timeBugatti = m2 + ":" + s2;
                    } else if (seg2 > seg1) {
                        timeLambo = m1 + ":" + s2;
                        timeBugatti = m2 + ":" + s1;
                    } else {
                        timeLambo = m1 + ":" + String.valueOf(seg1 + 1);
                        timeBugatti = m2 + ":" + s2;
                    }
                }

                pantalla.timeL.setText(timeLambo);
                pantalla.timeB.setText(timeBugatti);

                nroGanadoresL++;
                if (colaGanadores.equals("")) {
                    colaGanadores = "L" + pantalla.lamborghini.id;
                } else {
                    colaGanadores = colaGanadores + ",L" + pantalla.lamborghini.id;
                }

            } else if (ptosBugatti > ptosLambo) {
                pantalla.estadoB.setText("Ganador");
                pantalla.estadoB.setForeground(Color.GREEN);
                pantalla.estadoL.setText("Perdedor");
                pantalla.estadoL.setForeground(Color.BLUE);
                pantalla.estadoIA.setText("Selección completa");

                String timeLambo;
                String timeBugatti;
                if (min1 > min2) {
                    timeLambo = m2 + ":" + s2;
                    timeBugatti = m1 + ":" + s1;
                } else if (min2 > min1) {
                    timeLambo = m1 + ":" + s2;
                    timeBugatti = m2 + ":" + s1;
                } else {
                    if (seg1 > seg2) {
                        timeLambo = m1 + ":" + s2;
                        timeBugatti = m2 + ":" + s1;
                    } else if (seg2 > seg1) {
                        timeLambo = m1 + ":" + s1;
                        timeBugatti = m2 + ":" + s2;
                    } else {
                        timeLambo = m1 + ":" + s1;
                        timeBugatti = m2 + ":" + String.valueOf(seg1 + 1);
                    }
                }

                pantalla.timeL.setText(timeLambo);
                pantalla.timeB.setText(timeBugatti);

                nroGanadoresB++;
                if (colaGanadores.equals("")) {
                    colaGanadores = "B" + pantalla.bugatti.id;
                } else {
                    colaGanadores = colaGanadores + ",B" + pantalla.bugatti.id;
                }
            } else {  // DEBERIA de ser muy raro que empaten, pero bueno si pasa, gana bugatti porque es mejor o sea indiscutible
                pantalla.estadoB.setText("A");
                pantalla.estadoB.setForeground(Color.MAGENTA);
                pantalla.estadoL.setText("A");
                pantalla.estadoL.setForeground(Color.MAGENTA);
                pantalla.estadoIA.setText("A...");

                pantalla.timeL.setText("00:00");
                pantalla.timeB.setText("00:00");

                nroGanadoresB++;
                if (colaGanadores.equals("")) {
                    colaGanadores = "B" + pantalla.bugatti.id;
                } else {
                    colaGanadores = colaGanadores + ",B" + pantalla.bugatti.id;
                }
            }

            pantalla.nroGanadoresBugatti.setText(String.valueOf(nroGanadoresB));
            pantalla.nroGanadoresLambo.setText(String.valueOf(nroGanadoresL));
            pantalla.colaGanadores.setText(colaGanadores);
        } else if (prob <= 0.67) {  //Caso empate
            pantalla.estadoIA.setText("Hubo empate");
            pantalla.estadoL.setText("Empate");
            pantalla.estadoL.setForeground(Color.DARK_GRAY);
            pantalla.estadoB.setText("Empate");
            pantalla.estadoB.setForeground(Color.DARK_GRAY);

            String timeLambo = m1 + ":" + s1;
            String timeBugatti = m1 + ":" + s1;

            pantalla.timeL.setText(timeLambo);
            pantalla.timeB.setText(timeBugatti);

            pantalla.lambo_p1.encolar(pantalla.lamborghini);
            pantalla.bugatti_p1.encolar(pantalla.bugatti);
        } else { //Caso no ocurre la carrera
            pantalla.estadoIA.setText("Fallo de vehiculos");
            pantalla.estadoL.setText("Falló");
            pantalla.estadoL.setForeground(Color.red);
            pantalla.estadoB.setText("Falló");
            pantalla.estadoB.setForeground(Color.red);

            pantalla.timeL.setText("00:00");
            pantalla.timeB.setText("00:00");

            pantalla.lambo_r.encolar(pantalla.lamborghini);
            pantalla.bugatti_r.encolar(pantalla.bugatti);
        }
        try {
            sleep(2000); //espera 2 segs para ver los resultados de la simulacion
        } catch (InterruptedException ex) {
            Logger.getLogger(IA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void seleccionarPista() {
        pantalla.estadoIA.setText("Seleccionando la pista");
        try {
            sleep(2000); //siempre espera 2 seg seleccionando pista
        } catch (InterruptedException ex) {
            Logger.getLogger(IA.class.getName()).log(Level.SEVERE, null, ex);
        }
        Random random = new Random();
        int prob = random.nextInt(60) + 1;
        if (prob <= 10) {
            Funciones.scaleImage(pantalla.pistaImg, "pista1.PNG");
            this.climaL = (float) 1.60;
            this.climaB = 1;
            this.terrenoL = 1;
            this.terrenoB = (float) 1.40;
        } else if (prob <= 20) {
            Funciones.scaleImage(pantalla.pistaImg, "pista2.PNG");
            this.climaL = (float) 1.40;
            this.climaB = 1;
            this.terrenoL = (float) 1.60;
            this.terrenoB = 1;
        } else if (prob <= 30) {
            Funciones.scaleImage(pantalla.pistaImg, "pista3.PNG");
            this.climaL = (float) 1.20;
            this.climaB = 1;
            this.terrenoL = 1;
            this.terrenoB = (float) 1.20;
        } else if (prob <= 40) {
            Funciones.scaleImage(pantalla.pistaImg, "pista4.PNG");
            this.climaL = 1;
            this.climaB = (float) 1.60;
            this.terrenoL = (float) 1.40;
            this.terrenoB = 1;
        } else if (prob <= 50) {
            Funciones.scaleImage(pantalla.pistaImg, "pista5.PNG");
            this.climaL = 1;
            this.climaB = (float) 1.40;
            this.terrenoL = 1;
            this.terrenoB = (float) 1.60;
        } else {
            Funciones.scaleImage(pantalla.pistaImg, "pista6.PNG");
            this.climaL = 1;
            this.climaB = (float) 1.20;
            this.terrenoL = (float) 1.20;
            this.terrenoB = 1;
        }
    }

    private void restaurarValores() {
        pantalla.estadoB.setText("Esperando");
        pantalla.estadoB.setForeground(Color.BLACK);
        pantalla.estadoL.setText("Esperando");
        pantalla.estadoL.setForeground(Color.BLACK);
        pantalla.estadoIA.setText("Esperando Admin");
        pantalla.timeB.setText("00:00");
        pantalla.timeL.setText("00:00");
    }

    private String fixTime(int time) {
        String result = String.valueOf(time);
        if (result.length() == 1) {
            result = "0" + result;
        }
        return result;
    }

}
