package Mastermind.Mastermind;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

public class SelectColorUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private List<JButton> customizedButtons;
	private GameUI gameUI;

	public SelectColorUI(GameUI gameUI) {
		this.gameUI = gameUI;

	}

	private void initialize() {
		setTitle("Personalizar Colores");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(400, 200);
		setLayout(new GridLayout(0, 2));

		customizedButtons = new ArrayList<>();
		for (int i = 0; i < gameUI.totalColors; i++) {
			JButton botonPersonalizar = new JButton("Color " + (i + 1));
			customizedButtons.add(botonPersonalizar);
			botonPersonalizar.setBackground(gameUI.coloresPersonalizar[i]);
			add(botonPersonalizar);
			add(new JPanel());
		}

		for (int i = 0; i < customizedButtons.size(); i++) {
			JButton boton = customizedButtons.get(i);
			final int index = i;

			ActionListener botonAl = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Color newColor = JColorChooser.showDialog(SelectColorUI.this, "Seleccionar Color",
							gameUI.userColorGuess[index]);
					if (newColor != null) {
						gameUI.coloresPersonalizar[index] = newColor;
						updateDisplayedButtons();
					}
				}
			};

			boton.addActionListener(botonAl);
		}
		JButton saveBtn = new JButton("Guardar");

		ActionListener saveBtnActionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameUI.updateCustomizedButtons();
				dispose();
			}
		};

		saveBtn.addActionListener(saveBtnActionListener);

		add(saveBtn);

		updateDisplayedButtons();

	}

	private void updateDisplayedButtons() {
		for (int i = 0; i < customizedButtons.size(); i++) {
			JButton boton = customizedButtons.get(i);
			Color color = gameUI.coloresPersonalizar[i];
			boton.setBackground(color);
		}
	}
}