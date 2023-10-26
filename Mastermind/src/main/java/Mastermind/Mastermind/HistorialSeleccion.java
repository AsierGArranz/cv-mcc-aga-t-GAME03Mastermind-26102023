package Mastermind.Mastermind;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class HistorialSeleccion {
	private List<Color[]> historial;

	public HistorialSeleccion() {
		historial = new ArrayList<>();
	}

	public void add(Color[] suposicion) {
		historial.add(suposicion);
	}

	public List<Color[]> getHistorial() {
		return historial;
	}
	

	public void mostrarHistorial() {
		for (int i = 0; i < historial.size(); i++) {
			System.out.print("Intento " + (i + 1) + ": ");
			Color[] suposicion = historial.get(i);
			for (Color color : suposicion) {
				System.out.print(color + " ");
			}
			System.out.println();
		}
	}

	public Color[] obtenerUltimaSeleccion() {
		if (!historial.isEmpty()) {
			return historial.get(historial.size() - 1);
		}
		return null; 
	}

	public void limpiarHistorial() {
		historial.clear();
	}
}

