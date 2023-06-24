/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pantallas;

import clases.Funciones;

/**
 *
 * @author juanc
 */
public class Pantalla extends javax.swing.JFrame {

    /**
     * Creates new form Pantalla
     */
    public Pantalla() {
        initComponents();
        addComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        Fondo = new Pantallas.BackgroundPanel();
        header = new javax.swing.JPanel();
        roundedPanel1 = new Pantallas.RoundedPanel();
        title = new javax.swing.JLabel();
        left = new javax.swing.JPanel();
        roundedPanel3 = new Pantallas.RoundedPanel();
        lamboP1Label = new javax.swing.JLabel();
        lamboP1 = new javax.swing.JTextField();
        lamboP2Label = new javax.swing.JLabel();
        lamboP2 = new javax.swing.JTextField();
        lamboP3Label = new javax.swing.JLabel();
        lamboP3 = new javax.swing.JTextField();
        lamboRLabel = new javax.swing.JLabel();
        lamboR = new javax.swing.JTextField();
        body = new javax.swing.JPanel();
        roundedPanel2 = new Pantallas.RoundedPanel();
        right = new javax.swing.JPanel();
        roundedPanel4 = new Pantallas.RoundedPanel();
        bugattiP1Label = new javax.swing.JLabel();
        bugattiP4 = new javax.swing.JTextField();
        bugattiP2Label = new javax.swing.JLabel();
        bugattiP5 = new javax.swing.JTextField();
        bugattiP3Label = new javax.swing.JLabel();
        bugattiP6 = new javax.swing.JTextField();
        bugattiRLabel = new javax.swing.JLabel();
        bugattiR = new javax.swing.JTextField();
        footer = new javax.swing.JPanel();
        Slider = new javax.swing.JSlider();
        SliderLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simulación");
        setResizable(false);

        header.setOpaque(false);
        header.setPreferredSize(new java.awt.Dimension(1000, 100));
        header.setLayout(new java.awt.GridBagLayout());

        roundedPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundedPanel1.setPreferredSize(new java.awt.Dimension(500, 80));

        title.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        title.setForeground(new java.awt.Color(0, 0, 0));
        title.setText("Lamborghini VS Bugatti");

        javax.swing.GroupLayout roundedPanel1Layout = new javax.swing.GroupLayout(roundedPanel1);
        roundedPanel1.setLayout(roundedPanel1Layout);
        roundedPanel1Layout.setHorizontalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(roundedPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(title)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        roundedPanel1Layout.setVerticalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
            .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(roundedPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(title)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        header.add(roundedPanel1, new java.awt.GridBagConstraints());

        left.setOpaque(false);
        left.setPreferredSize(new java.awt.Dimension(300, 400));
        left.setLayout(new java.awt.GridBagLayout());

        roundedPanel3.setBackground(new java.awt.Color(255, 255, 255));
        roundedPanel3.setPreferredSize(new java.awt.Dimension(250, 350));
        roundedPanel3.setLayout(new java.awt.GridBagLayout());

        lamboP1Label.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lamboP1Label.setForeground(new java.awt.Color(0, 0, 0));
        lamboP1Label.setText("Prioridad Alta");
        lamboP1Label.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 5, 5));
        roundedPanel3.add(lamboP1Label, new java.awt.GridBagConstraints());

        lamboP1.setEditable(false);
        lamboP1.setBackground(new java.awt.Color(255, 255, 255));
        lamboP1.setColumns(12);
        lamboP1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lamboP1.setForeground(new java.awt.Color(0, 0, 0));
        lamboP1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lamboP1.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        roundedPanel3.add(lamboP1, gridBagConstraints);

        lamboP2Label.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lamboP2Label.setForeground(new java.awt.Color(0, 0, 0));
        lamboP2Label.setText("Prioridad Media");
        lamboP2Label.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 5, 5, 5));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        roundedPanel3.add(lamboP2Label, gridBagConstraints);

        lamboP2.setEditable(false);
        lamboP2.setBackground(new java.awt.Color(255, 255, 255));
        lamboP2.setColumns(12);
        lamboP2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lamboP2.setForeground(new java.awt.Color(0, 0, 0));
        lamboP2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lamboP2.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        roundedPanel3.add(lamboP2, gridBagConstraints);

        lamboP3Label.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lamboP3Label.setForeground(new java.awt.Color(0, 0, 0));
        lamboP3Label.setText("Prioridad Baja");
        lamboP3Label.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 5, 5, 5));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        roundedPanel3.add(lamboP3Label, gridBagConstraints);

        lamboP3.setEditable(false);
        lamboP3.setBackground(new java.awt.Color(255, 255, 255));
        lamboP3.setColumns(12);
        lamboP3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lamboP3.setForeground(new java.awt.Color(0, 0, 0));
        lamboP3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lamboP3.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        roundedPanel3.add(lamboP3, gridBagConstraints);

        lamboRLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lamboRLabel.setForeground(new java.awt.Color(0, 0, 0));
        lamboRLabel.setText("Refuerzo");
        lamboRLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 5, 5, 5));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        roundedPanel3.add(lamboRLabel, gridBagConstraints);

        lamboR.setEditable(false);
        lamboR.setBackground(new java.awt.Color(255, 255, 255));
        lamboR.setColumns(12);
        lamboR.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lamboR.setForeground(new java.awt.Color(0, 0, 0));
        lamboR.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lamboR.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        roundedPanel3.add(lamboR, gridBagConstraints);

        left.add(roundedPanel3, new java.awt.GridBagConstraints());

        body.setOpaque(false);
        body.setPreferredSize(new java.awt.Dimension(400, 400));
        body.setLayout(new java.awt.GridBagLayout());

        roundedPanel2.setBackground(new java.awt.Color(255, 255, 255));
        roundedPanel2.setPreferredSize(new java.awt.Dimension(350, 350));

        javax.swing.GroupLayout roundedPanel2Layout = new javax.swing.GroupLayout(roundedPanel2);
        roundedPanel2.setLayout(roundedPanel2Layout);
        roundedPanel2Layout.setHorizontalGroup(
            roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        roundedPanel2Layout.setVerticalGroup(
            roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );

        body.add(roundedPanel2, new java.awt.GridBagConstraints());

        right.setOpaque(false);
        right.setPreferredSize(new java.awt.Dimension(300, 400));
        right.setLayout(new java.awt.GridBagLayout());

        roundedPanel4.setBackground(new java.awt.Color(255, 255, 255));
        roundedPanel4.setPreferredSize(new java.awt.Dimension(250, 350));
        roundedPanel4.setLayout(new java.awt.GridBagLayout());

        bugattiP1Label.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        bugattiP1Label.setForeground(new java.awt.Color(0, 0, 0));
        bugattiP1Label.setText("Prioridad Alta");
        bugattiP1Label.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 5, 5));
        roundedPanel4.add(bugattiP1Label, new java.awt.GridBagConstraints());

        bugattiP4.setEditable(false);
        bugattiP4.setBackground(new java.awt.Color(255, 255, 255));
        bugattiP4.setColumns(12);
        bugattiP4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        bugattiP4.setForeground(new java.awt.Color(0, 0, 0));
        bugattiP4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bugattiP4.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        roundedPanel4.add(bugattiP4, gridBagConstraints);

        bugattiP2Label.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        bugattiP2Label.setForeground(new java.awt.Color(0, 0, 0));
        bugattiP2Label.setText("Prioridad Media");
        bugattiP2Label.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 5, 5, 5));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        roundedPanel4.add(bugattiP2Label, gridBagConstraints);

        bugattiP5.setEditable(false);
        bugattiP5.setBackground(new java.awt.Color(255, 255, 255));
        bugattiP5.setColumns(12);
        bugattiP5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        bugattiP5.setForeground(new java.awt.Color(0, 0, 0));
        bugattiP5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bugattiP5.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        roundedPanel4.add(bugattiP5, gridBagConstraints);

        bugattiP3Label.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        bugattiP3Label.setForeground(new java.awt.Color(0, 0, 0));
        bugattiP3Label.setText("Prioridad Baja");
        bugattiP3Label.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 5, 5, 5));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        roundedPanel4.add(bugattiP3Label, gridBagConstraints);

        bugattiP6.setEditable(false);
        bugattiP6.setBackground(new java.awt.Color(255, 255, 255));
        bugattiP6.setColumns(12);
        bugattiP6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        bugattiP6.setForeground(new java.awt.Color(0, 0, 0));
        bugattiP6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bugattiP6.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        roundedPanel4.add(bugattiP6, gridBagConstraints);

        bugattiRLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        bugattiRLabel.setForeground(new java.awt.Color(0, 0, 0));
        bugattiRLabel.setText("Refuerzo");
        bugattiRLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 5, 5, 5));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        roundedPanel4.add(bugattiRLabel, gridBagConstraints);

        bugattiR.setEditable(false);
        bugattiR.setBackground(new java.awt.Color(255, 255, 255));
        bugattiR.setColumns(12);
        bugattiR.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        bugattiR.setForeground(new java.awt.Color(0, 0, 0));
        bugattiR.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bugattiR.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED)));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        roundedPanel4.add(bugattiR, gridBagConstraints);

        right.add(roundedPanel4, new java.awt.GridBagConstraints());

        footer.setOpaque(false);
        footer.setPreferredSize(new java.awt.Dimension(1000, 100));
        footer.setLayout(new java.awt.GridBagLayout());

        Slider.setBackground(new java.awt.Color(255, 255, 255));
        Slider.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true), javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        Slider.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        footer.add(Slider, gridBagConstraints);

        SliderLabel.setBackground(new java.awt.Color(255, 255, 255));
        SliderLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        SliderLabel.setForeground(new java.awt.Color(255, 255, 255));
        SliderLabel.setText("Velocidad");
        SliderLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 6, 6, 6));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        footer.add(SliderLabel, gridBagConstraints);

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(FondoLayout.createSequentialGroup()
                .addComponent(left, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(body, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(right, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(footer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(left, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(body, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(right, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(footer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pantalla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Pantallas.BackgroundPanel Fondo;
    private javax.swing.JSlider Slider;
    private javax.swing.JLabel SliderLabel;
    private javax.swing.JPanel body;
    private javax.swing.JLabel bugattiP1Label;
    private javax.swing.JLabel bugattiP2Label;
    private javax.swing.JLabel bugattiP3Label;
    private javax.swing.JTextField bugattiP4;
    private javax.swing.JTextField bugattiP5;
    private javax.swing.JTextField bugattiP6;
    private javax.swing.JTextField bugattiR;
    private javax.swing.JLabel bugattiRLabel;
    private javax.swing.JPanel footer;
    private javax.swing.JPanel header;
    private javax.swing.JTextField lamboP1;
    private javax.swing.JLabel lamboP1Label;
    private javax.swing.JTextField lamboP2;
    private javax.swing.JLabel lamboP2Label;
    private javax.swing.JTextField lamboP3;
    private javax.swing.JLabel lamboP3Label;
    private javax.swing.JTextField lamboR;
    private javax.swing.JLabel lamboRLabel;
    private javax.swing.JPanel left;
    private javax.swing.JPanel right;
    private Pantallas.RoundedPanel roundedPanel1;
    private Pantallas.RoundedPanel roundedPanel2;
    private Pantallas.RoundedPanel roundedPanel3;
    private Pantallas.RoundedPanel roundedPanel4;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables

    private void addComponents() {
        this.setLocationRelativeTo(null);
        Funciones.setWindowIcon(this, "logo.jpg");
    }
}