/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author juanc
 */
public class Funciones {
    
    public static void setWindowIcon(JFrame ventana, String path) {
        ImageIcon img = new ImageIcon("src\\main\\java\\Recursos\\" + path);
        ventana.setIconImage(img.getImage());
    }
    
}
