package Mastermind.Mastermind;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VentanaGame extends JFrame {
	private static final long serialVersionUID = 1L;
	public int numBotones = 4;
	public int numIntentos = 10;
	
	
	public JButton[] seleccionColores;
	
	public VentanaGame() {
		getContentPane().setLayout(null);
		setTitle("MasterMind");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        seleccionColores = new JButton[0];
		
		
		//getContentPane().add(btnNewButton); /*<- esto lo pinta*/
		
		for(int i = 1; i<=numBotones; i++) {
			JButton btnNewButton = new JButton();
			btnNewButton.setBounds(30*i, 10, 25, 25);
			btnNewButton.setBackground(obtenerColor(i));
			getContentPane().add(btnNewButton); 
			//seleccionColores[i] = btnNewButton;
			
		}
		
	}
	
	
	private void seleccionarColor(int color) {
		
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
		default:
			return Color.GRAY;
		}
	}
}
