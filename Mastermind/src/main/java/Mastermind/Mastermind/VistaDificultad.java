package Mastermind.Mastermind;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaDificultad extends JFrame {

    public VistaDificultad() {
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
        btnPrincipiante.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirVentanaGame(4, 10);
            }
        });

        btnMedio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirVentanaGame(5, 9);
            }
        });

        btnDificil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirVentanaGame(6, 8);
            }
        });
    }

    private void abrirVentanaGame(int numSeleccion, int numIntentos) {
        VentanaGame ventanaGame = new VentanaGame(numSeleccion, numIntentos);
        ventanaGame.setVisible(true);
        dispose();
    }
}
