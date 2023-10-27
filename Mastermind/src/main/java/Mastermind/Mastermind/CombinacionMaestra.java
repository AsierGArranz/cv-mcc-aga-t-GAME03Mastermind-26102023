package Mastermind.Mastermind;

import java.awt.Color;
import java.util.Arrays;
import java.util.Random;

class CombinacionMaestra {
    private Color[] combinacion;
    private Color[] coloresPersonalizar;

   
    
    public CombinacionMaestra(Color[] coloresPersonalizar) {
        this.coloresPersonalizar = coloresPersonalizar; // Asigna la matriz recibida a la variable de instancia
        combinacion = generarCombinacion(coloresPersonalizar.length);
    }

    public Color[] getCombinacion() {
        return combinacion;
    }

    public Color[] comprobarAdivinanza(Color[] suposicion) {
        Color[] resultado = new Color[suposicion.length];

        for (int i = 0; i < suposicion.length; i++) {
            if (suposicion[i].equals(combinacion[i])) {
                resultado[i] = Color.BLACK;
            } else if (Arrays.asList(combinacion).contains(suposicion[i])) {
                resultado[i] = Color.WHITE;
            } else {
                resultado[i] = null;
            }
        }

        return resultado;
    }

    private Color[] generarCombinacion(int numColores) {
        Color[] combinacion = new Color[numColores];
        Random random = new Random();

        for (int i = 0; i < numColores; i++) {
            int colorIndex = random.nextInt(numColores);
            combinacion[i] = coloresPersonalizar[colorIndex]; 
        }

        return combinacion;
    }
}