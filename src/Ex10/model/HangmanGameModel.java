package Ex10.model;

//This class will manage the entire game (without any user interaction code).
//It should contain methods that allow starting the game (picking randomly
//a new word), trying/verifying a letter, checking the end of the game,
//managing game progress information: number of attempts, already tried letters, ...

public class HangmanGameModel {
    private static final int MAX_ERRORS = 7;
    private static final String HIDDEN_CHARACTER = ".";

    private String wordToGuess;
    private StringBuffer currentSituation;
    private StringBuilder attemptedCharacters;
    private int nAttempts, nFound;

    public HangmanGameModel(){
        initializer();
    }

    public void initializer(){
        int i = (int)(Math.random()*HangmanGameDictionary.numberOfWords());
        wordToGuess = HangmanGameDictionary.getWord(i);

        currentSituation = new StringBuffer(HIDDEN_CHARACTER.repeat(wordToGuess.length()));
        attemptedCharacters = new StringBuilder();
        nAttempts = nFound = 0;
    }

    public void newGame(){
        initializer();
    }

    public boolean isConcluded() {
        return isWordFound() || getNErrors() >= MAX_ERRORS;
    }

    public String getCurrentSituation() {
        return currentSituation.toString();
    }

    public int getNAttempts() {
        return nAttempts;
    }

    public int getNErrors() {
        return nAttempts - nFound;
    }

    public int getMaxErrors() {
        return MAX_ERRORS;
    }

    public String getAttemptedCharacters() {
        return attemptedCharacters.toString();
    }

    public boolean isWordFound() {
        return wordToGuess.equalsIgnoreCase(currentSituation.toString());
    }

    public String getWordToGuess() {
        if (isConcluded())
            return wordToGuess;
        return null;
    }

    public boolean tryOption(String option) {
        if (option == null || isConcluded() || option.isBlank())
            return false;

        boolean found = false;
        option = option.toUpperCase();
        nAttempts++;

        if (option.length() > 1){ //it is a word
            if (option.equals(wordToGuess)){
                nFound++;
                currentSituation = new StringBuffer(wordToGuess);
                found = true;
            }
        }
        else{ //it is a character
            char op = option.charAt(0);
            attemptedCharacters.append(op);

            for (int i = 0; i < wordToGuess.length(); i++){
                char c = wordToGuess.charAt(i);
                if (op == c){
                    found = true;
                    currentSituation.setCharAt(i,op);
                }
            }
            if (found)
                nFound++;
        }
        return found;
    }
}

