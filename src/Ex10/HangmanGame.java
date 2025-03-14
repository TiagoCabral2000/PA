package Ex10;

import Ex10.model.HangmanGameModel;
import Ex10.ui.HangmanGameUI;

public class HangmanGame {
    public static void main(String[] args) {
        HangmanGameModel game = new HangmanGameModel();
        HangmanGameUI gameUI = new HangmanGameUI(game);
        gameUI.play();
    }
}
