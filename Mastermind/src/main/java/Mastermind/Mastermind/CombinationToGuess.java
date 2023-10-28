package Mastermind.Mastermind;

import java.awt.Color;
import java.util.Arrays;
import java.util.Random;

class CombinationToGuess {
    private Color[] combinationToGuess;
    private Color[] avariableColors;

    public CombinationToGuess(Color[] avariableColors) {
        this.avariableColors = avariableColors;
        this.combinationToGuess = generarCombinacion(avariableColors.length);
    }

    public Color[] getCombinacion() {
        return combinationToGuess;
    }

    private Color[] generarCombinacion(int totalColors) {
        Color[] combinationToGuess = new Color[totalColors];
        Random random = new Random();

        for (int i = 0; i < totalColors; i++) {
            int colorIndex = random.nextInt(totalColors);
            combinationToGuess[i] = avariableColors[colorIndex]; 
        }
        return combinationToGuess;
    }
}