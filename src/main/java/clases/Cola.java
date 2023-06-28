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

    public static Cola[] subir_cola(Vehiculo x, Cola q, Cola q2) {  //Vehiculo x es el que va a subir de nivel
        Vehiculo vehiculo = x;
        Cola cola_baja = q;
        Cola cola_arriba = q2;
        
        Cola[] ambas_colas = new Cola[2];
        
        if (cola_baja.first == vehiculo) {
            cola_baja.first = vehiculo.next;
            cola_arriba.encolar(vehiculo);
            vehiculo.cola_prioridad--;
            ambas_colas[0] = cola_baja;
            ambas_colas[1] = cola_arriba;

        } else {
            Cola aux = new Cola(cola_baja.nivel_prioridad,cola_baja.marca);  
            Vehiculo v1 = cola_baja.first;
            while (v1 != vehiculo) {  //Se recorre cola_baja hasta llegar a vehiculo y cada vehiculo se encola en aux
                aux.encolar(v1);
                v1 = v1.next;
            }

            cola_arriba.encolar(vehiculo);

            Vehiculo v2 = v1.next;   //v1 en este momento es igual a vehiculo. Se agarra su next 
            if (v2 != null) {
                while (v2 != null) {
                    aux.encolar(v2);
                    v2 = v2.next;;
                }
            }
            cola_baja = aux;  //aux es la misma cola que cola_baja solo que sin vehiculo, por lo que cola_baja es ahora aux debido a que vehiculo subio de prioridad
            vehiculo.cola_prioridad--;
            ambas_colas[0] = cola_baja;
            ambas_colas[1] = cola_arriba;

        }
         
        return ambas_colas;
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

    public Vehiculo readHead() {
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

