package Mastermind.Mastermind;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class HistorialSeleccion {
    private List<Color[]> historial;
    private List<Color[]> resultados;

    public HistorialSeleccion() {
        historial = new ArrayList<>();
        resultados = new ArrayList<>();
    }

    public void add(Color[] suposicion, Color[] resultado) {
        historial.add(suposicion);
        resultados.add(resultado);
    }

    public List<Color[]> getHistorial() {
        return historial;
    }

    public List<Color[]> getResultados() {
        return resultados;
    }

    public void limpiarHistorial() {
        historial.clear();
        resultados.clear();
    }
    
    public void verificarSolucion() {
    	
    }

    public void mostrarHistorial() {
    	System.out.print(":3");
        for (int i = 0; i < historial.size(); i++) {
            System.out.print("Intento " + (i + 1) + ": ");
            Color[] suposicion = historial.get(i);
            Color[] resultado = resultados.get(i);
            System.out.print("Cosa");
            for (int j = 0; j < suposicion.length; j++) {
            	System.out.print("Test");
                if (resultado[j] != null) {
                    if (resultado[j].equals(Color.BLACK)) {
                        System.out.print("⬛ "); // Color negro
                        System.out.println("negro");
                    } else if (resultado[j].equals(Color.WHITE)) {
                        System.out.print("⬜ "); // Color blanco
                        System.out.println("color piel");
                    }
                } else {
                    System.out.print(suposicion[j] + " "); // Color normal
                }
            }
            System.out.println();
        }
    }
}
