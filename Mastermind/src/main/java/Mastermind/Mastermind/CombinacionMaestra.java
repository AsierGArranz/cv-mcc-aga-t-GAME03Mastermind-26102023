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

/*
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
            case 7:
                return Color.BLACK;
            case 8:
                return Color.CYAN;
            case 9:
                return Color.MAGENTA;
            case 10:
                return Color.DARK_GRAY;
            default:
                return Color.GRAY;
        }
    }
    private String obtenerColorName(int indice) {
        switch (indice) {
            case 1:
                return "Red";
            case 2:
                return "Blue";
            case 3:
                return "Green";
            case 4:
                return "Yellow";
            case 5:
                return "Orange";
            case 6:
                return "Pink";
            case 7:
                return "Black";
            case 8:
                return "Cyan";
            case 9:
                return "Magenta";
            case 10:
                return "Dark Gray";
            default:
                return "Gray";
        }
    }
    */

}