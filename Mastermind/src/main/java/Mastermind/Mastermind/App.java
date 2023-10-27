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
					VistaDificultad frame = new VistaDificultad();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}