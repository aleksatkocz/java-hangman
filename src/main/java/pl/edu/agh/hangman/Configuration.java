package pl.edu.agh.hangman;

import static pl.edu.agh.hangman.Hangman.HANGMANPICS;

public class Configuration {



    private static Configuration instance;

    private Configuration() {}

    public static Configuration getInstance() {
        if (instance == null) {
            instance = new Configuration();
        }
        return instance;
    }

    public String dataSource() {
       return new ReadTextFromInternet("https://www.wordnik.com/words").readFile().toUpperCase();
        // return new ChooseWord().chooseWord(new ReadTextFromfile("/slowa.txt").writeWords());
    }

    public String[] hangedManPic() {
        return Hangman.HANGMANPICS;
       // return Hangman.christmasTree;
    }



}
