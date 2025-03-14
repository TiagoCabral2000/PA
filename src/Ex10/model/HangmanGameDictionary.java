package Ex10.model;

//Allows providing the words to use in the game.
//It should have only static members to store a table
//with the words, and two methods, one to obtain the quantity of
//stored words and another to get a word through its index
public class HangmanGameDictionary {
    private static final String[] words = {
            "TOMORROW", "ARCHIMEDES", "LION", "TIGER", "ZEBRA", "PLATE",
            "BROWN", "ORANGE", "PEA", "OTTER", "BALLAST", "ORANGUTAN",
            "DISCIPLINE", "PROGRAMMING", "POTATO", "CLOWN", "BRAIN",
            "TUNA", "PORTUGAL", "WILD", "ANIMAL", "IRRATIONAL",
            "MATHEMATICS", "DISCREET", "EFFICIENT", "EFFECTIVE", "MARVEL",
            "SYNOPSIS", "DEVICE", "LINEAR", "LEMON", "LAMP","EAR",
            "BUFFALO", "SHOE", "LOBSTER", "RISKY", "SCRATCHED",
            "CARNIVAL", "BOLD", "RELEASED", "SIMPLE", "COMPLEX",
            "STAPLER", "MONITOR", "KEYBOARD", "KEY", "CLOCK",
            "HANDKERCHIEF", "WINDOW", "ROPE", "VIOLA", "GUITAR",
            "POINTER", "ARGUER", "SAGACIOUS", "ERRONEOUS", "INSTITUTE",
            "UPPER", "ENGINEERING", "DEPARTMENT", "INFORMATICS", "SYSTEM",
            "CALL", "PRESIDENT", "FEBRUARY", "INCREASE", "SALARY",
            "MONEY", "IMMEDIATE", "FLAMINGO", "RHINOCEROS",
            "HIPPOPOTAMUS", "CODFISH", "PORGIE", "SARDINE", "SNAIL",
            "INSECT", "FLYING", "ORANGE", "SPRINKLING", "EXTINCT",
            "EXTERNAL","AMBIGUOUS"
    };

    private HangmanGameDictionary(){};

    public static int numberOfWords(){
        return words.length;
    }

    public static String getWord(int index){
        if (index < 0 || index >= words.length)
            return null;
        return words[index];
    }

}
