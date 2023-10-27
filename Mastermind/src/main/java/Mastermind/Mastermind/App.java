package Mastermind.Mastermind;

import java.awt.EventQueue;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaDificultad frame = new VentanaDificultad();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}