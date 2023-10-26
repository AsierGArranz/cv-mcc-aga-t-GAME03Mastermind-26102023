package Mastermind.Mastermind;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class VentanaJuego extends JFrame {
    private int numColores = 6;
    private int numFichas = 4; 
    private int intentosMaximos = 10; 

    private int[] codigoSecreto;
    private int numIntentos;
    private int intentosRestantes;

    private JButton[] seleccionColores,coloresSeleccionados;
    private JButton botonComprobar;
    private JLabel resultadoLabel;
    private JPanel panelJuego;
    private JPanel panelSeleccion;

    public VentanaJuego() {
        numIntentos = 0;
        intentosRestantes = intentosMaximos;

        // Genera el código secreto
        codigoSecreto = generarCodigoSecreto();

        setTitle("MasterMind");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        panelJuego = new JPanel();
        panelSeleccion = new JPanel();
        resultadoLabel = new JLabel("");
        botonComprobar = new JButton("Comprobar");

        seleccionColores = new JButton[numColores];
        coloresSeleccionados = new JButton[numColores];
        
        
        for (int i = 0; i < numColores; i++) {
            seleccionColores[i] = new JButton();
            seleccionColores[i].setBackground(obtenerColor(i));
            final int colorSeleccionado = i;
            seleccionColores[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    seleccionarColor(colorSeleccionado);
                }
            });
            panelSeleccion.add(seleccionColores[i]);
        }

        botonComprobar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comprobarIntento();
            }
        });

        panelJuego.add(resultadoLabel);
        panelJuego.add(botonComprobar);

        setLayout(new BorderLayout());
        add(panelSeleccion, BorderLayout.NORTH);
        add(panelJuego, BorderLayout.CENTER);

        reiniciarJuego();
    }

    private int[] generarCodigoSecreto() {
        Random random = new Random();
        int[] codigo = new int[numFichas];

        for (int i = 0; i < numFichas; i++) {
            codigo[i] = random.nextInt(numColores);
        }

        return codigo;
    }

    private Color obtenerColor(int indice) {
        switch (indice) {
            case 0:
                return Color.RED;
            case 1:
                return Color.BLUE;
            case 2:
                return Color.GREEN;
            case 3:
                return Color.YELLOW;
            case 4:
                return Color.ORANGE;
            case 5:
                return Color.PINK;
            default:
                return Color.GRAY;
        }
    }
    
    private int[] intentoActual = new int[numFichas];
    private void seleccionarColor(int color) {
    	if(numIntentos<intentosMaximos) {
    		intentoActual[numIntentos] = color;
    		coloresSeleccionados[numIntentos].setBackground(obtenerColor(color));
        	panelSeleccion.add(coloresSeleccionados[numIntentos]);
    		numIntentos++;
        	if(numIntentos == numFichas) {
        		botonComprobar.setEnabled(true);
        	}
    	}
    	
    }

    private void comprobarIntento() {
    }

    private void reiniciarJuego() {
        numIntentos = 0;
        intentosRestantes = intentosMaximos;
        resultadoLabel.setText("");
    }
}