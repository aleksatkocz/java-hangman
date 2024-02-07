package pl.edu.agh.hangman;
import java.util.*;
import java.util.Random;
import java.util.ArrayList;


public class ChooseWord {
    public String chooseWord (ArrayList<String> words) {
        Random random = new Random();

        System.out.println("Wylosuj losowe słowo bądź wprowadź długość słowa do odgadnięcia.");
        System.out.println("1 -> losowe słowo");
        System.out.println("2 -> wprowadź długość słowa samodzielnie");
        System.out.print("Twój wybór: ");
        int userChoice = getInt();

        switch (userChoice) {
            case 1 -> {
                int randomWord = random.nextInt(words.size());
                return words.get(randomWord);
            }
            case 2 -> {
                System.out.print("Jak długie słowo chcesz wylosować?: ");
                int wordLengthUserChoice = getInt();
                ArrayList<String> selectedWords = selectWords(words,wordLengthUserChoice);
                while (selectedWords.isEmpty()) {
                    System.out.print("Nie ma wyrazów w bazie o podanej długości liter. Podaj inną długość: ");
                    wordLengthUserChoice = getInt();
                    selectedWords = selectWords(words,wordLengthUserChoice);
                }
                System.out.println("Losuję pośród liczby wyrazów w bazie: " + selectedWords.size() + ".");
                countDown();
                int randomSelectedWord = random.nextInt(selectedWords.size());
                return selectedWords.get(randomSelectedWord);
            }
            default -> {
                System.out.println("Wprowadziłeś złą odpowiedź. Długość słowa została wylosowana.");
                int randomWord = random.nextInt(words.size());
                return words.get(randomWord);
            }
        }
    }

    public int getInt() {
        try {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.print("Możesz wpisać tylko cyfrę. Spróbuj ponownie: ");
            return getInt();
        }
    }

    private ArrayList<String> selectWords (ArrayList<String> words, int selectedLength) {
        ArrayList<String> selectedWords = new ArrayList<>();
        for (String word : words) {
            if (word.length() == selectedLength) {
                selectedWords.add(word);
            }
        }
        return selectedWords;
    }

    private void countDown () {
        for (int i = 0; i<3; i++) {
            System.out.println("...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

