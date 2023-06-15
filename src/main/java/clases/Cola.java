/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author roman
 */

public class Cola {

    public Vehiculo first;
    public Vehiculo last;
    public int size;
    int nivel_prioridad;
    String marca;

    public Cola(int nivel_prioridad, String marca) {
        this.size = 0;
        this.first = null;
        this.last = null;
        this.nivel_prioridad = nivel_prioridad;
        this.marca = marca;
    }

    public void empty() {
        this.first = this.last = null;
        this.size = 0;
    }

    public void encolar(Vehiculo x) {
        Vehiculo vehiculo = x;
        if (first == null) {
            this.first = vehiculo;
        } else {
            this.last.next = vehiculo;
        }
        this.last = vehiculo;
        this.size++;
    }

    public void desencolar() {
        this.first = first.next;
        this.size--;
        if (first == null) {
            this.last = null;
        }

    }

//    public void imprimir() {
//        Vehiculo temp = this.first;
//        while (temp != null) {
//            System.out.println(temp.id.toString());
//            temp = temp.next;
//        }
//    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Object readHead() {
        return this.first;   //tenia this.first.info
    }

    public Vehiculo getFirst() {
        return first;
    }


    public void setFirst(Vehiculo first) {
        this.first = first;
    }

    public Vehiculo getLast() {
        return last;
    }

    public void setLast(Vehiculo last) {
        this.last = last;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}  

