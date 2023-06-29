/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author juanc
 */
public class Funciones {
    
    public static void setWindowIcon(JFrame ventana, String path) {
        ImageIcon img = new ImageIcon("src\\main\\java\\Recursos\\" + path);
        ventana.setIconImage(img.getImage());
    }
    
    public static void scaleImage(JLabel frame, String imgName) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("src\\main\\java\\Recursos\\" + imgName));
            Image dimg = img.getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(dimg);
            frame.setIcon(imageIcon);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
