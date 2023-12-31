package Mastermind.Mastermind;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
//this generate a new array for the colors the player chose and safe them to show what they chose
public class UserGameHistory {
    private List<Color[]> allUserColorGuesses;
    private List<Color[]> allUserColorGuessesResult;

    public UserGameHistory() {
        allUserColorGuesses = new ArrayList<>();
        allUserColorGuessesResult = new ArrayList<>();
    }

    public void add(Color[] userColorGuess, Color[] userColorGuessResult) {
        this.allUserColorGuesses.add(userColorGuess);
        this.allUserColorGuessesResult.add(userColorGuessResult);
    }

    public List<Color[]> getAllUserColorGuesses() {
        return allUserColorGuesses;
    }

    public List<Color[]> getAllUserColorGuessesResult() {
        return allUserColorGuessesResult;
    }

    public void clearGameHistory() {
        allUserColorGuesses.clear();
        allUserColorGuessesResult.clear();
    }
}
