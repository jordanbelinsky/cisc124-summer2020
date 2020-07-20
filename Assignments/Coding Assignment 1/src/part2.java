// Name: Jordan Belinsky
// File: Part 2
// Purpose: A two player game in which players guess randomized scrambled words to win!

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class part2 {
    private static int player1Turns = 5;
    private static int player2Turns = 5;
    private static int player1Score = 0;
    private static int player2Score = 0;
    private static ArrayList<String> words = new ArrayList<>();
    private static String selectedWord;
    private static String scrambledWord;
    private static boolean player1 = true;
    private static boolean player2 = false;

    public static String selectWord(ArrayList<String> words) {
        // Randomly selects a word from the word array.
        // ArrayList<String> -> String
        Random randNum = new Random();
        int index = randNum.nextInt((100 - 0) + 1) + 0;
        return words.get(index);
    }

    public static String scrambledWord(String word) {
        // Generates a scrambled word.
        // String -> String
        scrambledWord = scramble(word);
        return scrambledWord;
    }

    public static String scramble(String word) {
        // An algorithm for randomly scrambling a string.
        // String -> String
        Random randLetters = new Random();
        char splitWord[] = word.toCharArray();
        for (int i = 0; i < splitWord.length; i++) {
            int j = randLetters.nextInt(splitWord.length);
            char temporary = splitWord[i];
            splitWord[i] = splitWord[j];
            splitWord[j] = temporary;
        }
        return new String(splitWord);

    }

    public static void main(String[] args) {
        // Initialize string and counter variables
        String fileName = "/Users/jordanbelinsky/Documents/GitHub/cisc124-summer2020/Assignments/Coding Assignment 1/assets/google-10000-english-usa-no-swears-medium.txt";
        String line = null;

        // File IO using FileReader and BufferedReader
        try {
            FileReader fileReader =
                    new FileReader(fileName);

            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while (bufferedReader.ready()) {
                words.add(bufferedReader.readLine());
            }

            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
        }

        // Run the game until score reaches 40
        while(player1Score <= 40 && player2Score <= 40) {

            // Player 1 turn
            while (player1 == true && player2 == false) {
                selectedWord = selectWord(words);
                scrambledWord = scrambledWord(selectedWord);
                System.out.println("Your word to guess is: " + scrambledWord);
                int turnsTaken = 0;
                // Run through remaining turns
                for (int i = player1Turns; i > 0; i--) {
                    turnsTaken += 1;
                    System.out.println("Player 1: " + player1Turns + " remaining.");
                    Scanner guessInput = new Scanner(System.in);
                    System.out.println("Enter guess: ");
                    String wordGuess = guessInput.nextLine();
                    player1Turns -= 1;
                    // Calculate score
                    if (wordGuess.equals(selectedWord)) {
                        player1Score += (6 - turnsTaken);
                        System.out.println("You guessed correctly! The word was: " + selectedWord);
                        System.out.println("Player 1 Score: " + player1Score);
                        player1 = false;
                        player2 = true;
                        break;
                    } else if(player1Turns != 0) {
                        continue;
                    } else {
                        System.out.println("You ran out of turns!");
                        System.out.println("Your word was: " + selectedWord);
                        System.out.println("Player 1 Score: " + player1Score);
                        player1 = false;
                        player2 = true;
                    }
                }
            }



            // Player 2 turn
            while (player2 == true && player1 == false) {
                selectedWord = selectWord(words);
                scrambledWord = scrambledWord(selectedWord);
                System.out.println("Your word to guess is: " + scrambledWord);
                int turnsTaken = 0;
                // Runs through remaining turns
                for (int i = player2Turns; i > 0; i--) {
                    turnsTaken += 1;
                    System.out.println("Player 2: " + player2Turns + " remaining.");
                    Scanner guessInput = new Scanner(System.in);
                    System.out.println("Enter guess: ");
                    String wordGuess = guessInput.nextLine();
                    player2Turns -= 1;
                    // Calculate score
                    if (wordGuess.equals(selectedWord)) {
                        player2Score += (6 - turnsTaken);
                        System.out.println("You guessed correctly! The word was: " + selectedWord);
                        System.out.println("Player 2 Score: " + player2Score);
                        player2 = false;
                        player1 = true;
                        break;
                    } else if(player2Turns != 0) {
                        continue;
                    } else {
                        System.out.println("You ran out of turns!");
                        System.out.println("Your word was: " + selectedWord);
                        System.out.println("Player 2 Score: " + player2Score);
                        player2 = false;
                        player1 = true;
                    }
                }
            }
        }
    }
}

