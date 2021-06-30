/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Datos.JugadorJDBC;
import Dominio.*;
import java.awt.Color;
import java.awt.Image;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 *
 * @author mateo
 */
public class TriquiFrame extends javax.swing.JFrame {

    private Juego juego;
    private JLabel[][] tablero;
    private Jugador jugador1;
    private Jugador jugador2;
    private int j1Puntos;
    private int j2Puntos;
    private boolean primerJuego;

    /**
     * Creates new form TriquiFrame
     */
    public TriquiFrame() {
        initComponents();
        this.juego = new Juego();
        JLabel[][] t = {
            {lbl00, lbl01, lbl02},
            {lbl10, lbl11, lbl12},
            {lbl20, lbl21, lbl22},};
        this.tablero = t;
        this.j1Puntos = 0;
        this.j2Puntos = 0;
        this.primerJuego = true;
        this.inicializarTablero();
    }

    public void inicializarTablero() {

        for (int i = 0; i < this.tablero.length; i++) {
            for (int j = 0; j < this.tablero[0].length; j++) {

                Border border = BorderFactory.createLineBorder(Color.BLACK, 1);

                Image img = new ImageIcon("img/vacio.png").getImage();
                ImageIcon img2 = new ImageIcon(img.getScaledInstance(
                        this.tablero[i][j].getWidth(),
                        this.tablero[i][j].getHeight(),
                        Image.SCALE_SMOOTH)
                );

                this.tablero[i][j].setIcon(img2);
                this.tablero[i][j].setBorder(border);
            }
        }

    }

    public void elegirPosicion(int i, int j) {
        if (this.juego.obtenerSimbolo(i, j) == this.juego.getTableroJuego().getVacio()) {
            juego.insertarSimbolo(i, j);
            Image img;
            if (this.juego.isTurno()) {
                img = new ImageIcon("imagenes/X.png").getImage();
            } else {
                img = new ImageIcon("imagenes/O.png").getImage();
            }
            ImageIcon img2 = new ImageIcon(img.getScaledInstance(
                    this.tablero[i][j].getWidth(),
                    this.tablero[i][j].getHeight(),
                    Image.SCALE_SMOOTH)
            );

            this.tablero[i][j].setIcon(img2);

            this.juego.cambiarTurno();

            if (this.juego.finPartida()) {
                char ganador = juego.ganador();
                if (ganador == 'N') {
                    JOptionPane.showMessageDialog(rootPane, "Empate");
                } else if (ganador == this.juego.getTableroJuego().getX()) {

                    // this.jugador1.setPuntaje(this.jugador1.getPuntaje()+1);
                    j1Puntos++;
                    JOptionPane.showMessageDialog(rootPane, "Gana Jugador 1" + "\n" + "Puntaje: " + this.j1Puntos);
                } else {
                    j2Puntos++;
                    //  this.jugador2.setPuntaje(this.jugador2.getPuntaje()+1);
                    JOptionPane.showMessageDialog(rootPane, "Gana Jugador 2" + "\n" + "Puntaje: " + this.j2Puntos);
                }
//                if (primerJuego) {
//                    this.primerJuego=false;
//                    String a=JOptionPane.showInputDialog( "Toma el dato");
//                    System.out.println("Primer juego"+primerJuego+a);
//                }
                this.reinicio();
            }
        }
    }

    public void mostrarJugadoresBd() {
        JugadorJDBC jugadordbc = new JugadorJDBC();

        List<Jugador> jugadores = jugadordbc.select();
        for (Jugador jugador : jugadores) {
            System.out.println("Jugador: " + jugador);
        }
    }

    /*
    Almacena el jugador con el nombre en la base de datos
     */
    public void almacenarEnBaseDatos() {

        JugadorJDBC jugadordbc = new JugadorJDBC();

        if (this.j1Puntos > this.j2Puntos) {

            Jugador jugador1 = new Jugador(JOptionPane.showInputDialog("Intruduzca su Nombre Jugador 1"), this.j1Puntos);
            jugadordbc.insert(jugador1);
        } else if (this.j1Puntos < this.j2Puntos) {

            Jugador jugador2 = new Jugador(JOptionPane.showInputDialog("Intruduzca su Nombre Jugador 2"), this.j2Puntos);
            jugadordbc.insert(jugador2);
        }
        JOptionPane.showMessageDialog(rootPane, "Hay un Empate de puntos");

    }

    public void reinicio() {
        this.juego = new Juego();
        this.inicializarTablero();

    }

    public void mostrarJugador() {
        this.jLabel3.setText(this.juego.mostrarTurnoJugadorActual());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl00 = new javax.swing.JLabel();
        lbl01 = new javax.swing.JLabel();
        lbl02 = new javax.swing.JLabel();
        lbl10 = new javax.swing.JLabel();
        lbl11 = new javax.swing.JLabel();
        lbl12 = new javax.swing.JLabel();
        lbl20 = new javax.swing.JLabel();
        lbl21 = new javax.swing.JLabel();
        lbl22 = new javax.swing.JLabel();
        btnReinicio = new javax.swing.JButton();
        btnRegistro = new javax.swing.JButton();
        txtJ2puntos = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TRIQUI Mateo Ospina");
        setMinimumSize(new java.awt.Dimension(400, 600));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridLayout(5, 3));
        getContentPane().add(jLabel1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Turno:");
        getContentPane().add(jLabel2);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Jugador 1");
        getContentPane().add(jLabel3);

        lbl00.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl00MouseClicked(evt);
            }
        });
        getContentPane().add(lbl00);

        lbl01.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl01MouseClicked(evt);
            }
        });
        getContentPane().add(lbl01);

        lbl02.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl02MouseClicked(evt);
            }
        });
        getContentPane().add(lbl02);

        lbl10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl10MouseClicked(evt);
            }
        });
        getContentPane().add(lbl10);

        lbl11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl11MouseClicked(evt);
            }
        });
        getContentPane().add(lbl11);

        lbl12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl12MouseClicked(evt);
            }
        });
        getContentPane().add(lbl12);

        lbl20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl20MouseClicked(evt);
            }
        });
        getContentPane().add(lbl20);

        lbl21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl21MouseClicked(evt);
            }
        });
        getContentPane().add(lbl21);

        lbl22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl22MouseClicked(evt);
            }
        });
        getContentPane().add(lbl22);

        btnReinicio.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnReinicio.setText("Reinicio");
        btnReinicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReinicioActionPerformed(evt);
            }
        });
        getContentPane().add(btnReinicio);

        btnRegistro.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnRegistro.setText("Finalizar");
        btnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistro);

        txtJ2puntos.setEditable(false);
        getContentPane().add(txtJ2puntos);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl00MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl00MouseClicked
        elegirPosicion(0, 0);
        mostrarJugador();
    }//GEN-LAST:event_lbl00MouseClicked

    private void lbl01MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl01MouseClicked
        elegirPosicion(0, 1);
        mostrarJugador();
    }//GEN-LAST:event_lbl01MouseClicked

    private void lbl02MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl02MouseClicked
        elegirPosicion(0, 2);
        mostrarJugador();
    }//GEN-LAST:event_lbl02MouseClicked

    private void lbl10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl10MouseClicked
        elegirPosicion(1, 0);
        mostrarJugador();
    }//GEN-LAST:event_lbl10MouseClicked

    private void lbl11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl11MouseClicked
        elegirPosicion(1, 1);
        mostrarJugador();
    }//GEN-LAST:event_lbl11MouseClicked

    private void lbl12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl12MouseClicked
        elegirPosicion(1, 2);
        mostrarJugador();
    }//GEN-LAST:event_lbl12MouseClicked

    private void lbl20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl20MouseClicked
        elegirPosicion(2, 0);
        mostrarJugador();
    }//GEN-LAST:event_lbl20MouseClicked

    private void lbl21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl21MouseClicked
        elegirPosicion(2, 1);
        mostrarJugador();
    }//GEN-LAST:event_lbl21MouseClicked

    private void lbl22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl22MouseClicked
        elegirPosicion(2, 2);
        mostrarJugador();
    }//GEN-LAST:event_lbl22MouseClicked

    private void btnReinicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReinicioActionPerformed
        reinicio();
    }//GEN-LAST:event_btnReinicioActionPerformed

    private void btnRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroActionPerformed
        this.almacenarEnBaseDatos();
        this.mostrarJugadoresBd();
    }//GEN-LAST:event_btnRegistroActionPerformed

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
            java.util.logging.Logger.getLogger(TriquiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TriquiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TriquiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TriquiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TriquiFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistro;
    private javax.swing.JButton btnReinicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbl00;
    private javax.swing.JLabel lbl01;
    private javax.swing.JLabel lbl02;
    private javax.swing.JLabel lbl10;
    private javax.swing.JLabel lbl11;
    private javax.swing.JLabel lbl12;
    private javax.swing.JLabel lbl20;
    private javax.swing.JLabel lbl21;
    private javax.swing.JLabel lbl22;
    private javax.swing.JTextField txtJ2puntos;
    // End of variables declaration//GEN-END:variables
}
