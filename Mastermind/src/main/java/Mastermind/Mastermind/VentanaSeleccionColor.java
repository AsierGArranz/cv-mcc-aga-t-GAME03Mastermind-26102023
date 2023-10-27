package Mastermind.Mastermind;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

public class VentanaSeleccionColor extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<JButton> botonesPersonalizar;
    private VentanaGame ventanaGame;

    public VentanaSeleccionColor(VentanaGame ventanaGame) {
    	this.ventanaGame = ventanaGame;
    	
    	setTitle("Personalizar Colores");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 200);
        setLayout(new GridLayout(0,2));
        
        botonesPersonalizar = new ArrayList<>();
        for (int i = 0; i < ventanaGame.numSeleccion; i++) {
            JButton botonPersonalizar = new JButton("Color " + (i + 1));
            botonesPersonalizar.add(botonPersonalizar);
            botonPersonalizar.setBackground(ventanaGame.coloresPersonalizar[i]);
            add(botonPersonalizar);
            add(new JPanel());
        }
        
        for (int i = 0; i < botonesPersonalizar.size(); i++) {
        	JButton boton = botonesPersonalizar.get(i);
            final int indice = i;
        	
        	ActionListener botonAl = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Color nuevoColor = JColorChooser.showDialog(VentanaSeleccionColor.this, "Seleccionar Color", ventanaGame.coloresSeleccionados[indice]);
                    if (nuevoColor != null) {
                        ventanaGame.coloresPersonalizar[indice] = nuevoColor;
                        actualizarColoresMostrados();
                    }
                }
            };
        	
        	
            
            boton.addActionListener(botonAl);
        }
        JButton guardarButton = new JButton("Guardar");
        
        ActionListener guardarBtnAl = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	// TODO : renovar array de colores coloresPersonalizar
                ventanaGame.actualizarColoresPersonalizados();
                dispose();
            }
        };
        guardarButton.addActionListener(guardarBtnAl);

        add(guardarButton);

        actualizarColoresMostrados();
    }

    private void actualizarColoresMostrados() {
        for (int i = 0; i < botonesPersonalizar.size(); i++) {
            JButton boton = botonesPersonalizar.get(i);
            Color color = ventanaGame.coloresPersonalizar[i];
            boton.setBackground(color);
        }
    }
}