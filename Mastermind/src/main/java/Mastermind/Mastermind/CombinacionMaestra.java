package Mastermind.Mastermind;

import java.awt.Color;
import java.util.Arrays;
import java.util.Random;

public class CombinacionMaestra {
	private Color[] combinacion;

    public CombinacionMaestra(int numColores) {
        combinacion = generarCombinacion(numColores);
    }

    public Color[] getCombinacion() {
        return combinacion;
    }

    private Color[] generarCombinacion(int numColores) {
        Color[] combinacion = new Color[numColores];
        Random random = new Random();

        for (int i = 0; i < numColores; i++) {
            int colorIndex = random.nextInt(numColoresPosibles());
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
    
    public String toString() {
        return Arrays.toString(combinacion);
    }

    private int numColoresPosibles() {
        return 10;
    }
}
