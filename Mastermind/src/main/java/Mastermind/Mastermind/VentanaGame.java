package Mastermind.Mastermind;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class VentanaGame extends JFrame {

	// env Variables
	private static final long serialVersionUID = 1L;
	public int numBotones = 6;
	public int numIntentos = 10;
	public int numSeleccion = 4;

	// Counters
	private int colorSeleccionadoIndex;
	private int intentosRestantes;

	// JFame variables
	public JButton[] seleccionColores;
	private JLabel colorSeleccionadoLabel;
	private JPanel historialColoresPanel;

	// refactorizado
	private CombinacionMaestra combinacionMaestra;
	private HistorialSeleccion historialSeleccion;

	// process
	private Color[] coloresSeleccionados;
	private JPanel colorSeleccionadoPanel;

	public VentanaGame() {

		combinacionMaestra = new CombinacionMaestra(numSeleccion);
		historialSeleccion = new HistorialSeleccion();

		getContentPane().setLayout(null);
		setTitle("MasterMind");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 400);

		seleccionColores = new JButton[numBotones];
		coloresSeleccionados = new Color[numBotones];
		colorSeleccionadoIndex = 0;
		intentosRestantes = numIntentos;

		colorSeleccionadoLabel = new JLabel();
		colorSeleccionadoLabel.setBounds(10, 46, 300, 25);
		colorSeleccionadoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(colorSeleccionadoLabel);

		colorSeleccionadoPanel = new JPanel();
		colorSeleccionadoPanel.setBounds(114, 46, 144, 25);
		colorSeleccionadoPanel.setLayout(new GridLayout(1, numSeleccion));

		historialColoresPanel = new JPanel();
		historialColoresPanel.setLayout(new BoxLayout(historialColoresPanel, BoxLayout.Y_AXIS));
		historialColoresPanel.setBounds(10, 150, 147, 322);
		getContentPane().add(historialColoresPanel);

		getContentPane().add(colorSeleccionadoPanel);

		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(30 * (numBotones + 1), 10, 80, 25);
		getContentPane().add(btnBorrar);

		JButton btnAdivinar = new JButton("Adivinar");
		btnAdivinar.setBounds(294, 10, 80, 25);
		getContentPane().add(btnAdivinar);

		
		ActionListener clickBorrarAl = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coloresSeleccionados = new Color[numBotones];
				colorSeleccionadoIndex = 0;
				actualizarEtiquetaColorSeleccionado();
			}
		};
		
		btnBorrar.addActionListener(clickBorrarAl);

		System.out.println("Combinación maestra: " + combinacionMaestra.toString());

		ActionListener btnNewButtonAl = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (colorSeleccionadoIndex < numSeleccion) {
					JButton botonPresionado = (JButton) e.getSource();
					Color colorBoton = botonPresionado.getBackground();
					coloresSeleccionados[colorSeleccionadoIndex] = colorBoton;
					colorSeleccionadoIndex++;
					actualizarEtiquetaColorSeleccionado();
				}
			}
		};

		for (int i = 0; i < numBotones; i++) {
			JButton btnNewButton = new JButton();
			btnNewButton.setBounds(30 * (i + 1), 10, 25, 25);
			btnNewButton.setBackground(obtenerColor(i + 1));
			getContentPane().add(btnNewButton);
			seleccionColores[i] = btnNewButton;

			btnNewButton.addActionListener(btnNewButtonAl);
		}

		ActionListener btnAdivinarAl = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Arrays.equals(coloresSeleccionados, combinacionMaestra.getCombinacion())) {
					JOptionPane.showMessageDialog(null, "¡Has adivinado la combinación!", "¡Felicidades!",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					intentosRestantes--;
					if (intentosRestantes == 0) {
						JOptionPane.showMessageDialog(null, "¡Te has quedado sin intentos!", "Juego Terminado",
								JOptionPane.ERROR_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null,
								"Combinación incorrecta. Intentos restantes: " + intentosRestantes, "Intento Fallido",
								JOptionPane.WARNING_MESSAGE);
					}
				}

				historialSeleccion.add(Arrays.copyOf(coloresSeleccionados, coloresSeleccionados.length));
				llenarHistorial();
				coloresSeleccionados = new Color[numBotones];
				colorSeleccionadoIndex = 0;
				actualizarEtiquetaColorSeleccionado();
			}
		};

		btnAdivinar.addActionListener(btnAdivinarAl);
	}

	private void llenarHistorial() {
		JPanel historialPanel = new JPanel();
		historialPanel.setLayout(new BoxLayout(historialPanel, BoxLayout.Y_AXIS));

		for (Color[] seleccion : historialSeleccion.getHistorial()) {
			JPanel colorPanel = new JPanel();
			for (Color color : seleccion) {
				if (color != null) {
					JPanel colorSeleccionado = new JPanel();
					colorSeleccionado.setBackground(color);
					colorSeleccionado.setPreferredSize(new Dimension(25, 25));
					colorPanel.add(colorSeleccionado);
				}
			}
			historialPanel.add(colorPanel);
		}
		historialColoresPanel.removeAll();
		historialColoresPanel.add(historialPanel);
	}

	private void actualizarEtiquetaColorSeleccionado() {
		colorSeleccionadoPanel.removeAll(); // Limpiamos el panel antes de agregar los colores seleccionados

		for (Color color : coloresSeleccionados) {
			if (color != null) {
				JPanel colorPanel = new JPanel();
				colorPanel.setBackground(color);
				colorPanel.setPreferredSize(new Dimension(25, 25)); // Ajusta el tamaño de los colores seleccionados
				JLabel spacio = new JLabel(" ");
				colorSeleccionadoPanel.add(colorPanel);
				colorSeleccionadoPanel.add(spacio);
			}
		}

		colorSeleccionadoPanel.revalidate();
		colorSeleccionadoPanel.repaint();
	}

	private Color obtenerColor(int indice) {
		switch (indice) {
		case 1:
			return Color.RED;
		case 2:
			return Color.BLUE;
		case 3:
			return Color.GREEN;
		case 4:
			return Color.YELLOW;
		case 5:
			return Color.ORANGE;
		case 6:
			return Color.PINK;
		case 7:
			return Color.BLACK;
		case 8:
			return Color.CYAN;
		case 9:
			return Color.MAGENTA;
		case 10:
			return Color.DARK_GRAY;
		default:
			return Color.GRAY;
		}
	}

}
