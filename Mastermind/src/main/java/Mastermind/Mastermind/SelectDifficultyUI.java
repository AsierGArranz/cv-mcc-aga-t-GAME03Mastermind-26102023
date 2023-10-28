package Mastermind.Mastermind;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectDifficultyUI extends JFrame {
	private static final long serialVersionUID = 1L;

	public SelectDifficultyUI() {
		initialize();
	}

	private void initialize() {
		setTitle("Seleccionar Dificultad");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(296, 85);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		JButton beginnerBtn = new JButton("Principiante");
		beginnerBtn.setBounds(28, 11, 87, 23);
		JButton intermediateBtn = new JButton("Medio");
		intermediateBtn.setBounds(120, 11, 61, 23);
		JButton difficultBtn = new JButton("Difícil");
		difficultBtn.setBounds(186, 11, 57, 23);
		panel.setLayout(null);

		panel.add(beginnerBtn);
		panel.add(intermediateBtn);
		panel.add(difficultBtn);

		getContentPane().add(panel);

		beginnerBtn.addActionListener(executeGameBegginerAl);
		intermediateBtn.addActionListener(executeGameDifficultAl);
		difficultBtn.addActionListener(executeGameIntermediateAl);
	}

	ActionListener executeGameBegginerAl = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			openUIGame(4, 10);
		}
	};

	ActionListener executeGameIntermediateAl = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			openUIGame(6, 6);
		}
	};

	ActionListener executeGameDifficultAl = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			openUIGame(5, 8);
		}
	};

	private void openUIGame(int totalColors, int totalAttempts) {
		GameUI gameUI = new GameUI(totalColors, totalAttempts);
		gameUI.setVisible(true);
		dispose();
	}
}
