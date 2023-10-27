package Mastermind.Mastermind;

import java.awt.Color;
import java.util.Arrays;
import java.util.Random;

class CombinacionMaestra {
    private Color[] combinacion;

    public CombinacionMaestra(int numColores) {
        combinacion = generarCombinacion(numColores);
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
            int colorIndex = random.nextInt(numColores) + 1;
            combinacion[i] = obtenerColor(colorIndex);
        }

        return combinacion;
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

}