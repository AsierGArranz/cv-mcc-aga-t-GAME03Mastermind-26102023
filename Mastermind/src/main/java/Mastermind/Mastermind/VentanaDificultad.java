package Mastermind.Mastermind;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaDificultad extends JFrame {

    public VentanaDificultad() {
        setTitle("Seleccionar Dificultad");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);

        // Crear un panel para los botones
        JPanel panel = new JPanel();

        // Crear botones para seleccionar la dificultad
        JButton btnPrincipiante = new JButton("Principiante");
        JButton btnMedio = new JButton("Medio");
        JButton btnDificil = new JButton("Difícil");

        // Agregar los botones al panel
        panel.add(btnPrincipiante);
        panel.add(btnMedio);
        panel.add(btnDificil);

        // Agregar el panel a la ventana
        getContentPane().add(panel);

        // Agregar ActionListener para los botones
        ActionListener btnPrincipianteAl = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirVentanaGame(4, 10);
            }
        };
        
        btnPrincipiante.addActionListener(btnPrincipianteAl);

        
        ActionListener btnMedioAl = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirVentanaGame(5, 8);
            }
        };
        
        btnMedio.addActionListener(btnMedioAl);

        
        ActionListener btnDificilAl = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	abrirVentanaGame(6, 6);
            }
        };
        btnDificil.addActionListener(btnDificilAl);
    }

    private void abrirVentanaGame(int numSeleccion, int numIntentos) {
        VentanaGame ventanaGame = new VentanaGame(numSeleccion, numIntentos);
        ventanaGame.setVisible(true);
        dispose();
    }
}
