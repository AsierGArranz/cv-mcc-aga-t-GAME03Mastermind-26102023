package Mastermind.Mastermind;

import java.awt.Color;
import java.util.Random;
//this class generate the random colors, form the player chose if they change the colors, and return random combination of them
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
        Color[] combinationToGuess = new Color[4];
        Random random = new Random();

        for (int i = 0; i < 4; i++) {
            int colorIndex = random.nextInt(totalColors);
            combinationToGuess[i] = avariableColors[colorIndex]; 
        }
        return combinationToGuess;
    }
}