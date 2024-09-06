package pruebaslab;

import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.GridLayout;

public class BatallaNaval extends javax.swing.JFrame {
    private Tablero tablero; // Lógica del tablero
    private JLabel[][] campos; // Array de etiquetas que representan el tablero visual

    /**
     * Creates new form BatallaNaval
     */
    public BatallaNaval() {
        initComponents();
        tablero = new Tablero(5); // Crear la instancia del tablero con tamaño 5x5
        tablero.colocarBarcos(4); // Colocar 4 barcos de forma aleatoria
        inicializarCampos(); // Inicializar las etiquetas del tablero para visualización
    }

    // Inicializa las etiquetas visuales del tablero
    private void inicializarCampos() {
        campos = new JLabel[5][5]; // Crear una matriz de JLabel de 5x5
        jPanel1.setLayout(new GridLayout(5, 5)); // Configura el layout del panel como una cuadrícula 5x5
        
        // Creando las celdas del tablero visual
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                campos[i][j] = new JLabel("", SwingConstants.CENTER); // Crear las etiquetas
                campos[i][j].setBorder(BorderFactory.createLineBorder(java.awt.Color.BLACK)); // Borde para cada celda
                campos[i][j].setOpaque(true); // Permitir color de fondo
                campos[i][j].setBackground(java.awt.Color.CYAN); // Color inicial del fondo
                jPanel1.add(campos[i][j]); // Añadimos la celda al panel
            }
        }
    }

    // Método para manejar el disparo cuando el usuario ingresa coordenadas
    private void disparar() {
        try {
            // Obtener las coordenadas desde los campos de texto
            int fila = Integer.parseInt(text_filas.getText()) - 1; // Restamos 1 para adaptarlo al índice del array
            int columna = Integer.parseInt(txt_columna.getText()) - 1;

            // Validar que las coordenadas estén dentro del rango permitido
            if (fila >= 0 && fila < 5 && columna >= 0 && columna < 5) {
                mostrarLugarAdivinado(fila, columna); // Muestra la ubicación que se adivinó
                procesarDisparo(fila, columna);       // Procesa el disparo
            } else {
                JOptionPane.showMessageDialog(this, "Coordenadas fuera de los límites. Intenta nuevamente.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa números válidos para las coordenadas.");
        }
    }

    // Método para procesar el disparo en el tablero
    private void procesarDisparo(int fila, int col) {
        // Procesamos el disparo utilizando la lógica del tablero
        String resultado = tablero.procesarDisparo(fila, col);

        // Actualizar el JLabel correspondiente en la interfaz para reflejar el resultado del disparo
        if (resultado.contains("BARCO")) {
            campos[fila][col].setText("B"); // Mostrar "B" si se toca un barco
            campos[fila][col].setBackground(java.awt.Color.RED); // Fondo rojo para barco
        } else if (resultado.contains("AGUA")) {
            campos[fila][col].setText("X"); // Mostrar "X" si fue agua
            campos[fila][col].setBackground(java.awt.Color.BLUE); // Fondo azul para agua
        } else {
            JOptionPane.showMessageDialog(this, resultado); // Mostrar el mensaje si ya se disparó aquí
            return;
        }

        // Mostrar el resultado del disparo en un cuadro de diálogo
        JOptionPane.showMessageDialog(this, resultado);

        // Verificar si todos los barcos han sido hundidos
        if (tablero.todosBarcosHundidos()) {
            JOptionPane.showMessageDialog(this, "¡Felicidades! Hundiste todos los barcos.");
            System.exit(0); // Termina el juego
        }
    }

    // Muestra la ubicación que fue adivinada
    private void mostrarLugarAdivinado(int fila, int columna) {
        JOptionPane.showMessageDialog(this, "Adivinaste el lugar: Fila " + (fila + 1) + ", Columna " + (columna + 1));
    }

   

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        TextoBienvenido = new javax.swing.JLabel();
        txt_columna = new javax.swing.JTextField();
        text_filas = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        AdivinarLugar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        f0 = new javax.swing.JLabel();
        f1 = new javax.swing.JLabel();
        f2 = new javax.swing.JLabel();
        f3 = new javax.swing.JLabel();
        f4 = new javax.swing.JLabel();
        f5 = new javax.swing.JLabel();
        f6 = new javax.swing.JLabel();
        f7 = new javax.swing.JLabel();
        f8 = new javax.swing.JLabel();
        f9 = new javax.swing.JLabel();
        f10 = new javax.swing.JLabel();
        f11 = new javax.swing.JLabel();
        f12 = new javax.swing.JLabel();
        f13 = new javax.swing.JLabel();
        f14 = new javax.swing.JLabel();
        f15 = new javax.swing.JLabel();
        f16 = new javax.swing.JLabel();
        f17 = new javax.swing.JLabel();
        f18 = new javax.swing.JLabel();
        f19 = new javax.swing.JLabel();
        f20 = new javax.swing.JLabel();
        f21 = new javax.swing.JLabel();
        f22 = new javax.swing.JLabel();
        f23 = new javax.swing.JLabel();
        f24 = new javax.swing.JLabel();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        TextoBienvenido.setText("Bienvenido a Batalla Naval");

        txt_columna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_columnaActionPerformed(evt);
            }
        });

        text_filas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_filasActionPerformed(evt);
            }
        });

        jLabel1.setText("Columna");

        jLabel2.setText("Fila");

        AdivinarLugar.setText("Adivinar Lugar!");
        AdivinarLugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdivinarLugarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setMaximumSize(new java.awt.Dimension(5, 5));
        jPanel1.setMinimumSize(new java.awt.Dimension(5, 5));
        jPanel1.setPreferredSize(new java.awt.Dimension(250, 250));
        jPanel1.setLayout(new java.awt.GridLayout(5, 5));
        jPanel1.add(f0);
        jPanel1.add(f1);
        jPanel1.add(f2);
        jPanel1.add(f3);
        jPanel1.add(f4);
        jPanel1.add(f5);
        jPanel1.add(f6);
        jPanel1.add(f7);
        jPanel1.add(f8);
        jPanel1.add(f9);
        jPanel1.add(f10);
        jPanel1.add(f11);
        jPanel1.add(f12);
        jPanel1.add(f13);
        jPanel1.add(f14);
        jPanel1.add(f15);
        jPanel1.add(f16);
        jPanel1.add(f17);
        jPanel1.add(f18);
        jPanel1.add(f19);
        jPanel1.add(f20);
        jPanel1.add(f21);
        jPanel1.add(f22);
        jPanel1.add(f23);
        jPanel1.add(f24);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TextoBienvenido)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text_filas, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AdivinarLugar)
                            .addComponent(txt_columna, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(74, 74, 74)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 23, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(TextoBienvenido)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_columna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(text_filas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AdivinarLugar))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_columnaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_columnaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_columnaActionPerformed

    private void text_filasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_filasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_filasActionPerformed

    private void AdivinarLugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdivinarLugarActionPerformed
      disparar();
    }//GEN-LAST:event_AdivinarLugarActionPerformed

     public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BatallaNaval.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BatallaNaval.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BatallaNaval.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BatallaNaval.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BatallaNaval().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdivinarLugar;
    private javax.swing.JLabel TextoBienvenido;
    private javax.swing.JLabel f0;
    private javax.swing.JLabel f1;
    private javax.swing.JLabel f10;
    private javax.swing.JLabel f11;
    private javax.swing.JLabel f12;
    private javax.swing.JLabel f13;
    private javax.swing.JLabel f14;
    private javax.swing.JLabel f15;
    private javax.swing.JLabel f16;
    private javax.swing.JLabel f17;
    private javax.swing.JLabel f18;
    private javax.swing.JLabel f19;
    private javax.swing.JLabel f2;
    private javax.swing.JLabel f20;
    private javax.swing.JLabel f21;
    private javax.swing.JLabel f22;
    private javax.swing.JLabel f23;
    private javax.swing.JLabel f24;
    private javax.swing.JLabel f3;
    private javax.swing.JLabel f4;
    private javax.swing.JLabel f5;
    private javax.swing.JLabel f6;
    private javax.swing.JLabel f7;
    private javax.swing.JLabel f8;
    private javax.swing.JLabel f9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField text_filas;
    private javax.swing.JTextField txt_columna;
    // End of variables declaration//GEN-END:variables
}
