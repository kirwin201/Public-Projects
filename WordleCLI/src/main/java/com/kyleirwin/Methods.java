package com.kyleirwin;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Methods {

    List<String> wordList = new ArrayList<>();

    public void readWordFile() {

        String wordFile = "5LetterWords.txt";
        File file = new File(wordFile);

        try(Scanner readWordFile = new Scanner(file)) {
            while (readWordFile.hasNextLine()) {
                String word = readWordFile.nextLine();

                String[] splitWord = word.split(",");

                wordList.add(splitWord[0]);
            }
        }
        catch (FileNotFoundException fnf) {
            System.out.println("File error: " + fnf.getMessage());
        }
    }

    public String randomWord() {
        Collections.shuffle(wordList);
        return wordList.get(0);
    }

    public void displayMap(Map<Integer, String> map) {
        for(Map.Entry<Integer, String> row : map.entrySet()) {
            System.out.println(row.getValue());
        }
    }

    public String getUserInput() {
        Scanner userInput = new Scanner(System.in);
        String userWord = userInput.nextLine().toUpperCase();
        String validLetters = "ABCDEFGHIJKLMNOPQURSTUVWXYZ";
        boolean wordContainsValidLetters = true;

        for (int i = 0; i < userWord.length(); i++) {
            if (!validLetters.contains(userWord.subSequence(i, i+1))) {
                wordContainsValidLetters = false;
            }
        }

        while (userWord.length() != 5 || !wordContainsValidLetters) {
            System.out.print("Input was not valid: Enter a 5-letter word: ");
            userWord = userInput.nextLine().toUpperCase();

            wordContainsValidLetters = true;
            for (int i = 0; i < userWord.length(); i++) {
                if (!validLetters.contains(userWord.subSequence(i, i+1))) {
                    wordContainsValidLetters = false;
                }
            }
        }
        return userWord;
    }

    public String lettersRemaining(String userWord, String lettersRemaining) {
        for (int i = 0; i < userWord.length(); i++) {
            char guessedLetter = userWord.charAt(i);
            lettersRemaining = lettersRemaining.replace(guessedLetter, ' ');
        }
        return lettersRemaining;
    }
}
