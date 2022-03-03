package com.kyleirwin;

import java.util.HashMap;
import java.util.Map;

public class WordleCLI {

    public static void main(String[] args) {

        Wordle wordle = new Wordle();
        Methods methods = new Methods();

        displayWelcome();
        displayRules();

        //Read 5-letter-word file and get random word
        methods.readWordFile();
        String randomWord = methods.randomWord().toUpperCase();

        //Set Random Wordle
        wordle.setWordle(randomWord);

        wordleGrid wordleGrid = new wordleGrid();
        Map<Integer, String> rowsResults = new HashMap<>();

//        String defaultRow = "|_|_|_|_|_|";
       String allLetters = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z";

        rowsResults = wordleGrid.defaultGrid();
        wordleGrid.displayGrid(rowsResults);
        System.out.println();
        System.out.print("Remaining Letters: ");
        System.out.println(allLetters);
        System.out.println();
        System.out.print("Please guess a 5-letter word: ");

        String userWord = methods.getUserInput();

        int guessNumber = 0;
        boolean isCorrect = (userWord.equals(wordle.getWordle()));

        String lettersRemaining = allLetters;

        while (!isCorrect) {
            String row = "";
            for (int i = 0; i < userWord.length(); i++) {
                row += "|";
                if (userWord.charAt(i) == wordle.getWordle().charAt(i)) {
                    row += userWord.charAt(i);
                } else if (wordle.getWordle().contains(userWord.subSequence(i, i + 1))) {
                    row += userWord.toLowerCase().charAt(i);
                } else {
                    row += "*";
                }
            }
            row += "|";

            rowsResults.put(guessNumber, row);

            guessNumber++;
            if (guessNumber == 6) {
                for (int i = 0; i < userWord.length(); i++) {
                    row += "|" + userWord.charAt(i);
                }
                System.out.println();
                methods.displayMap(rowsResults);
                System.out.println();
                System.out.println("FAIL! The wordle was \"" + wordle.getWordle() + ".\" Please try again");
                System.exit(0);
            }

            System.out.println();
            methods.displayMap(rowsResults);
            System.out.println();

            lettersRemaining = methods.lettersRemaining(userWord, lettersRemaining);

            System.out.print("Remaining Letters: ");
            System.out.println(lettersRemaining);
            System.out.println();
            System.out.print("Please guess another 5-letter word: ");

            userWord = methods.getUserInput();

            isCorrect = (userWord.equals(wordle.getWordle()));
        }

        String row = "";

        for (int i = 0; i < userWord.length(); i++) {
            row += "|" + userWord.charAt(i);
        }
        row += "|";
        System.out.println();
        rowsResults.put(guessNumber, row);
        methods.displayMap(rowsResults);
        System.out.println();
        System.out.println("CORRECT!!");
        System.out.println("It took you " + (guessNumber+1) + " guesses");
    }

    public static void displayWelcome() {
        System.out.println("*************************");
        System.out.println("WELCOME TO MY WORDLE GAME");
        System.out.println("*************************");
        System.out.println();
    }

    public static void displayRules() {
        System.out.println("Guide:");
        System.out.println("UPPERCASE LETTER: is correct letter, and in the correct position");
        System.out.println("lowercase letter: is in the word, but is NOT in the correct position");
        System.out.println("* = letter is not in the word");
        System.out.println();
    }
}
