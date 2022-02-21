## My Wordle Game - Command Line Interface

This game should look and play similar to the viral word game Wordle.

### Application Features

1. The Application will read a .txt file containing 5-letter words.
   - Note: The list of words was found online and modified to omit unwanted words.
2. The Application will randomize the list of words to select a "wordle" for the user to guess.
3. The Application will display a blank grid of six rows and five columns.
     > ```
     > |_|_|_|_|_|
     > |_|_|_|_|_|
     > |_|_|_|_|_|
     > |_|_|_|_|_|
     > |_|_|_|_|_|
     > |_|_|_|_|_|
     > ```
4. The Application will display a list of letters that have not been guessed.
5. User will be asked to input a word.
    - Word must be only 5 characters.
    - Characters must only be letters a-z.
    - No symbols (. , ! @ , etc.) allowed.
6. A new grid will show results from the player's guess.
      - UPPERCASE letter: correct letter and in correct position. 
      - lowercase letter: wordle contains the letter, but in a different position. 
      - \* : letter is not in the wordle.
7. Guessed letters will be eliminated from the list of un-guessed letters.
8. Player will only have 6 guesses to find the wordle.

### Example
> ```
> wordle = words 
> 
> guess: steam = |s|*|*|*|*|
> guess: drops = |d|r|o|*|S|
> guess: words = |W|O|R|D|S| <-CORRECT
>                |_|_|_|_|_|
>                |_|_|_|_|_|
>                |_|_|_|_|_|
> ```

## Code Revisions

- code and readme written by kirwin201
- Rev 01: 2/18/22 KI - Wrote base functionality
- Rev 02: 2/20/22 KI - Added userInput conditions for word length of 5, and only contains letters a-z.
