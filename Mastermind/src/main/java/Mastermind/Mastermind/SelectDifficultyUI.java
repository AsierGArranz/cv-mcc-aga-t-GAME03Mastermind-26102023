package Mastermind.Mastermind;

import javax.swing.*;

import java.awt.Font;
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
		setSize(338, 151);
		setLocationRelativeTo(null);
		
		//create the buttons and their position on the scene
		JPanel panel = new JPanel();
		JButton beginnerBtn = new JButton("Principiante");
		beginnerBtn.setBounds(10, 78, 104, 23);
		JButton intermediateBtn = new JButton("Medio");
		intermediateBtn.setBounds(124, 78, 81, 23);
		JButton difficultBtn = new JButton("Difícil");
		difficultBtn.setBounds(215, 78, 97, 23);
		panel.setLayout(null);

		panel.add(beginnerBtn);
		panel.add(intermediateBtn);
		panel.add(difficultBtn);

		getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Master  Mind");
        lblNewLabel.setFont(new Font("Georgia", Font.PLAIN, 30));
        lblNewLabel.setBounds(67, 11, 194, 36);
        panel.add(lblNewLabel);
		
		//if you press the button they call openUIGame and send the parameters, depending on the option they choose
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
