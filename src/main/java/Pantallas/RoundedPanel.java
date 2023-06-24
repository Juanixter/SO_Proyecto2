/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pantallas;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 *
 * @author juanc
 */
public class RoundedPanel extends JPanel {

    /** Grosor del borde */
    protected int strokeSize = 1;
    /**Color de la sombra*/
    protected Color shadowColor = Color.black;
    /** Determina si panel tiene sombra o no */
    protected boolean shady = true;
    /** Define si se aplica suavizado a los bordes */
    protected boolean highQuality = true;
    /** Determina el radio horizontal y vertical de las esquinas*/
    protected Dimension arcs = new Dimension(20, 20);
    /** Distancia entre el borde del panel y su sombra */
    protected int shadowGap = 5;
    /** Offset de la sombra (distancia entre bordes horizontales y verticales)  */
    protected int shadowOffset = 4;
    /** Grado de transparencia de la sombra (0-255) */
    protected int shadowAlpha = 150;

    public RoundedPanel() {
       super();
       setOpaque(false);
   }
    
    @Override
   protected void paintComponent(Graphics g) {
       super.paintComponent(g);
       int width = getWidth();
       int height = getHeight();
       int shadowGap = this.shadowGap;
       Color shadowColorA = new Color(shadowColor.getRed(),
   shadowColor.getGreen(), shadowColor.getBlue(), shadowAlpha);
       Graphics2D graphics = (Graphics2D) g;

       // Los Hints en Graphics2D son aspectos que modifican la velocidad y/o calidad de renderizado
       if (highQuality) {
           graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
           RenderingHints.VALUE_ANTIALIAS_ON);
       }

       if (shady) {
           graphics.setColor(shadowColorA);
           graphics.fillRoundRect(
                   shadowOffset,// X position
                   shadowOffset,// Y position
                   width - strokeSize - shadowOffset, // width
                   height - strokeSize - shadowOffset, // height
                   arcs.width, arcs.height);// arc Dimension
       } else {
           shadowGap = 1;
       }

       //Draws the rounded opaque panel with borders.
       graphics.setColor(getBackground());
       graphics.fillRoundRect(0, 0, width - shadowGap, height - shadowGap, arcs.width, arcs.height);
       graphics.setColor(getForeground());
       graphics.setStroke(new BasicStroke(strokeSize));
       graphics.drawRoundRect(0, 0, width - shadowGap, height - shadowGap, arcs.width, arcs.height);

       //Sets strokes to default, is better.
       graphics.setStroke(new BasicStroke());
   }
} 
