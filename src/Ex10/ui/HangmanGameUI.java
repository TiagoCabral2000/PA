package Ex10.ui;

import Ex10.model.HangmanGameModel;

import java.util.Scanner;

//all interaction with the user will be implemented
public class HangmanGameUI {
    HangmanGameModel game;
    Scanner sc;
    public HangmanGameUI(HangmanGameModel game) {
        this.game = game;
    }

    public void play() {
        sc = new Scanner(System.in);

        while (!game.isConcluded()) {
            System.out.println("\nCurrent situation: " + game.getCurrentSituation());  // mostrar as letras descobertas
            // se a palavra for CAFE
            // inicialmente deverá mostrar:  ....
            System.out.println("Number of attempts: " + game.getNAttempts()); // inicio: 0
            System.out.printf("Errors: %d (máx.: %d)\n", game.getNErrors(), game.getMaxErrors());
            System.out.println("Attempted characteres: " + game.getAttemptedCharacters());

            System.out.print("\nSuggestion: ");

            String option = sc.nextLine().trim();

            if (option.length()>0)
                game.tryOption(option);
        }

        if (game.isWordFound())
            System.out.printf("Congratulations! You guessed the word %s in %d attempts\n",
                    game.getWordToGuess(), game.getNAttempts());
        else
            System.out.println("Game over!!! The word to guess was: "+ game.getWordToGuess());
    }
}

