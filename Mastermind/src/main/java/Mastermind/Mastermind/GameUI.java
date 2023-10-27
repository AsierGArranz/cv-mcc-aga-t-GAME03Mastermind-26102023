package Mastermind.Mastermind;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class GameUI extends JFrame {

	// env Variables
	private static final long serialVersionUID = 1L;
	public int totalColors = 4;
	private boolean sinIntentos = false;
	// Counters
	private int selectedColorIndex;
	public int totalAttempts = 10;
	private int attemptsLeft;

	// JFame variables
	public JButton[] seleccionColores;
	private JLabel selectedColorLabel;
	private JPanel colorHistoryPanel;
	private JLabel remainingAttemptsLabel;

	// refactorizado
	private CombinationToGuess combinationToGuess;
	private UserGameHistory selectionHistory;

	// process
	public Color[] userColorGuess;
	private JPanel selectedColorPanel;

	public Color[] coloresPersonalizar;

	private boolean colorCustomizacionEnabled = false;

	public GameUI(int totalColors, int totalAttempts) {

		this.totalColors = totalColors;
		this.totalAttempts = totalAttempts;
		coloresPersonalizar = new Color[totalColors];

		selectionHistory = new UserGameHistory();

		initialize();
	}

	private void initialize() {
		getContentPane().setLayout(null);
		setTitle("MasterMind");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 600);
		setLocationRelativeTo(null);

		seleccionColores = new JButton[totalColors];
		userColorGuess = new Color[totalColors];
		selectedColorIndex = 0;
		attemptsLeft = totalAttempts;

		remainingAttemptsLabel = new JLabel("Intentos restantes: " + attemptsLeft);
		remainingAttemptsLabel.setBounds(393, 72, 150, 25);
		getContentPane().add(remainingAttemptsLabel);

		selectedColorLabel = new JLabel();
		selectedColorLabel.setBounds(10, 46, 300, 25);
		selectedColorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(selectedColorLabel);

		selectedColorPanel = new JPanel();
		selectedColorPanel.setBounds(114, 46, 144, 25);
		selectedColorPanel.setLayout(new GridLayout(1, totalColors));

		colorHistoryPanel = new JPanel();
		colorHistoryPanel.setLayout(new BoxLayout(colorHistoryPanel, BoxLayout.Y_AXIS));
		colorHistoryPanel.setBounds(40, 95, 358, 322);
		getContentPane().add(colorHistoryPanel);

		getContentPane().add(selectedColorPanel);

		JButton deleteBtn = new JButton("Borrar");
		deleteBtn.setBounds(30 * (totalColors + 1), 10, 80, 25);
		getContentPane().add(deleteBtn);

		JButton guessBtn = new JButton("Adivinar");
		guessBtn.setBounds(294, 10, 80, 25);
		getContentPane().add(guessBtn);

		JButton restartBtn = new JButton("Reiniciar");
		restartBtn.setBounds(408, 108, 91, 25);
		getContentPane().add(restartBtn);

		ActionListener restartGameActionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guessBtn.setEnabled(true);
				restartGame();
			}
		};

		restartBtn.addActionListener(restartGameActionListener);

		JButton returnBtn = new JButton("Seleccionar dificultad");
		returnBtn.setBounds(383, 10, 160, 25);
		getContentPane().add(returnBtn);

		JButton colorCustomizationBtn = new JButton("Personalizar Colores");
		colorCustomizationBtn.setBounds(383, 46, 160, 25);
		getContentPane().add(colorCustomizationBtn);

		returnBtn.addActionListener(returnToDifficultyUIActionListener);

		ActionListener colorCustomizationActionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (colorCustomizacionEnabled) {
					restartGame();
					guessBtn.setEnabled(true);
					openSelectColorUI();
				} else {
					JOptionPane.showMessageDialog(null, "Juega al menos una vez antes de personalizar colores.",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		};

		colorCustomizationBtn.addActionListener(colorCustomizationActionListener);

		ActionListener clearUserColorCombinationActionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userColorGuess = new Color[totalColors];
				selectedColorIndex = 0;
				updateSelectedColorLabel();
			}
		};

		deleteBtn.addActionListener(clearUserColorCombinationActionListener);

		ActionListener btnNewButtonAl = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selectedColorIndex < totalColors) {
					JButton pressedBtn = (JButton) e.getSource();
					Color btnsColor = pressedBtn.getBackground();
					userColorGuess[selectedColorIndex] = btnsColor;
					selectedColorIndex++;
					updateSelectedColorLabel();
				}
			}
		};

		for (int i = 0; i < totalColors; i++) {
			JButton btnNewButton = new JButton();
			btnNewButton.setBounds(30 * (i + 1), 10, 25, 25);
			btnNewButton.setBorder(new LineBorder(Color.LIGHT_GRAY));
			btnNewButton.setBackground(getColor(i + 1));
			coloresPersonalizar[i] = getColor(i + 1);
			getContentPane().add(btnNewButton);
			seleccionColores[i] = btnNewButton;

			btnNewButton.addActionListener(btnNewButtonAl);
		}
		combinationToGuess = new CombinationToGuess(coloresPersonalizar);

		ActionListener guessBtnActionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selectedColorIndex < totalColors) {
					JOptionPane.showMessageDialog(null, "Completa la selección de colores antes de adivinar.", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (!sinIntentos) {
					checkUserAnswer();

					if (Arrays.equals(userColorGuess, combinationToGuess.getCombinacion())) {
						JOptionPane.showMessageDialog(null, "¡Has adivinado la combinación!", "¡Felicidades!",
								JOptionPane.INFORMATION_MESSAGE);
						colorCustomizacionEnabled = true;
						guessBtn.setEnabled(false);
					} else {
						attemptsLeft--;
						if (attemptsLeft == 0) {
							sinIntentos = true;
							guessBtn.setEnabled(false);
							colorCustomizacionEnabled = true;
							JOptionPane.showMessageDialog(null, "¡Te has quedado sin intentos!", "Juego Terminado",
									JOptionPane.ERROR_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null,
									"Combinación incorrecta. Intentos restantes: " + attemptsLeft, "Intento Fallido",
									JOptionPane.WARNING_MESSAGE);
						}
					}
					remainingAttemptsLabel.setText("Intentos restantes: " + attemptsLeft);
					printHistorial();

					userColorGuess = new Color[totalColors];
					selectedColorIndex = 0;
					updateSelectedColorLabel();
				}
			}
		};

		guessBtn.addActionListener(guessBtnActionListener);

	}

	ActionListener returnToDifficultyUIActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			returnToDifficultyUI();
		}
	};

	private void printHistorial() {
		// TODO: cambiar nombre esto
		JPanel historialPanel = new JPanel();
		historialPanel.setLayout(new BoxLayout(historialPanel, BoxLayout.X_AXIS));

		JPanel historialColores = new JPanel();
		historialColores.setLayout(new BoxLayout(historialColores, BoxLayout.Y_AXIS));

		for (Color[] seleccion : selectionHistory.getAllUserColorGuesses()) {
			JPanel colorPanel = new JPanel();
			colorPanel.setLayout(new BoxLayout(colorPanel, BoxLayout.X_AXIS));
			colorPanel.setBorder(new LineBorder(Color.BLACK));
			for (Color color : seleccion) {
				if (color != null) {
					JPanel selectedColor = new JPanel();
					selectedColor.setBackground(color);
					selectedColor.setBorder(new LineBorder(Color.BLACK));
					selectedColor.setPreferredSize(new Dimension(25, 25));
					selectedColor.setMaximumSize(new Dimension(25, 25));
					selectedColor.setMinimumSize(new Dimension(25, 25));
					colorPanel.add(selectedColor);
				}
			}
			historialColores.add(colorPanel);
			historialColores.add(Box.createRigidArea(new Dimension(0, 10)));

		}

		JPanel blackAndWhiteColors = new JPanel();
		blackAndWhiteColors.setLayout(new BoxLayout(blackAndWhiteColors, BoxLayout.Y_AXIS));

		for (Color[] result : selectionHistory.getAllUserColorGuessesResult()) {
			JPanel colorPanel = new JPanel();
			colorPanel.setLayout(new BoxLayout(colorPanel, BoxLayout.X_AXIS));
			colorPanel.setBorder(new LineBorder(Color.BLACK));
			for (Color color : result) {
				if (color != null) {
					JPanel selectedColor = new JPanel();
					selectedColor.setBackground(color);
					selectedColor.setBorder(new LineBorder(Color.LIGHT_GRAY));
					selectedColor.setPreferredSize(new Dimension(25, 25));
					selectedColor.setMaximumSize(new Dimension(25, 25));
					selectedColor.setMinimumSize(new Dimension(25, 25));
					colorPanel.add(selectedColor);
				}
			}
			blackAndWhiteColors.add(colorPanel);
			blackAndWhiteColors.add(Box.createRigidArea(new Dimension(0, 10)));
		}

		historialPanel.add(historialColores);
		historialPanel.add(Box.createRigidArea(new Dimension(20, 0)));
		historialPanel.add(blackAndWhiteColors);

		colorHistoryPanel.removeAll();
		colorHistoryPanel.add(historialPanel);
	}

	private void updateSelectedColorLabel() {
		selectedColorPanel.removeAll();

		for (Color color : userColorGuess) {
			if (color != null) {
				JPanel colorPanel = new JPanel();
				colorPanel.setBackground(color);
				colorPanel.setBorder(new LineBorder(Color.BLACK));
				colorPanel.setPreferredSize(new Dimension(25, 25));
				selectedColorPanel.add(colorPanel);
			}
		}

		selectedColorPanel.revalidate();
		selectedColorPanel.repaint();
	}

	private Color getColor(int index) {
		switch (index) {
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
		case 11:
			return Color.LIGHT_GRAY;
		default:
			return Color.GRAY;
		}
	}

	private void checkUserAnswer() {
		Color[] combinationToGuessColors = combinationToGuess.getCombinacion();
		Color[] userColorGuessResult = new Color[totalColors];

		for (int i = 0; i < totalColors; i++) {
			if (userColorGuess[i].equals(combinationToGuessColors[i])) {
				userColorGuessResult[i] = Color.BLACK;
			}

			if (userColorGuessResult[i] == null) {
				for (int j = 0; j < totalColors; j++) {
					if (i != j && userColorGuess[i].equals(combinationToGuessColors[j])) {
						userColorGuessResult[i] = Color.WHITE;
						break;
					}
				}
			}

			if (userColorGuessResult[i] == null) {
				userColorGuessResult[i] = Color.GRAY;
			}
		}

		selectionHistory.add(Arrays.copyOf(userColorGuess, userColorGuess.length), userColorGuessResult);
	}

	private void returnToDifficultyUI() {
		SelectDifficultyUI selectDifficultyUI = new SelectDifficultyUI();
		selectDifficultyUI.setVisible(true);
		dispose();
	}

	private void openSelectColorUI() {
		SelectColorUI selectColorUI = new SelectColorUI(this);
		selectColorUI.setVisible(true);
	}

	public void updateCustomizedButtons() {
		for (int i = 0; i < seleccionColores.length; i++) {
			seleccionColores[i].setBackground(coloresPersonalizar[i]);
		}
		combinationToGuess = new CombinationToGuess(coloresPersonalizar);
	}

	private void restartGame() {
		selectedColorIndex = 0;
		attemptsLeft = totalAttempts;
		sinIntentos = false;
		userColorGuess = new Color[totalColors];
		updateSelectedColorLabel();
		selectionHistory.clearGameHistory();
		remainingAttemptsLabel.setText("Intentos restantes: " + attemptsLeft);

		if (colorCustomizacionEnabled)
			updateCustomizedButtons();
		else
			combinationToGuess = new CombinationToGuess(coloresPersonalizar);

		colorHistoryPanel.removeAll();
		colorHistoryPanel.revalidate();
		colorHistoryPanel.repaint();

	}

}
