// Name: Jordan Belinsky
// File: Part 1
// Purpose: Performs various actions to analyze a text file.

import java.io.*;
import java.util.*;

public class part1 {
    private static int wordCount = 0;
    private static int sentenceCount = 0;
    private static boolean foundWordResult;
    private static String[][] topWordsResult;
    private static ArrayList<String> uniqueWords = new ArrayList<String>();
    private static ArrayList<Integer> uniqueWordCount = new ArrayList<Integer>();

    public static void countWords(String[] words) {
        // A function to count the number of words from an input file.
        // String[] -> void
        for(String i : words) {
            wordCount++;
        }
    }

    public static void countSentences(String[] sentences) {
        // A function to count the number of sentences from an input file.
        // String[] -> void
        for(String i : sentences) {
            sentenceCount++;
        }
    }

    public static int existsInUniqueWords(String word) {
        // A function to check if a word is already in unique word lists, and if so returns the index at which it is found.
        // String -> Integer
        for (int i = 0; i < uniqueWords.size(); i++) {
            if((uniqueWords.get(i)).toLowerCase().equals(word.toLowerCase())) {
                return i;
            } else {
                continue;
            }
        }
        return -1;
    }

    public static String[][] top10Words(String[] words) {
        // A function to find the top 10 most used words and their frequencies from an input file.
        // String[] -> String[][]
        String[][] top10 = new String[10][2];
        for (String i : words) {
            int index = existsInUniqueWords(i);
            if (index == -1) {
                uniqueWords.add(i);
                uniqueWordCount.add(1);
            } else {
                uniqueWordCount.set(index, uniqueWordCount.get(index) + 1);
            }
        }
        bubbleSort(uniqueWords, uniqueWordCount);
        for (int i = 0; i < top10.length; i++) {
            top10[i][0] = uniqueWords.get(i);
            top10[i][1] = uniqueWordCount.get(i).toString();
        }

        return top10;
    }

    public static void bubbleSort(ArrayList<String> wordArray, ArrayList<Integer> countArray) {
        // An implementation of bubble sorting method to sort a 2 dimensional array in parallel.
        // ArrayList<String>, ArrayList<Integer> -> void
        int len = countArray.size();
        for(int i = 0; i < len - 1; i++) {
            for(int j = 0; j < len - i - 1; j++) {
                if(countArray.get(j) < countArray.get(j+1)) {
                    int tempInt = countArray.get(j);
                    countArray.set(j, countArray.get(j + 1));
                    countArray.set(j + 1, tempInt);
                    String tempString = wordArray.get(j);
                    wordArray.set(j, wordArray.get(j + 1));
                    wordArray.set(j + 1, tempString);
                }
            }
        }
    }

    public static boolean wordFound(String[] words, String word) {
        // A function to check if an inputted word is found in the input file.
        // String[], String -> Boolean
        word = word.toLowerCase();
        for (int i = 0; i < words.length; i++) {
            if(word.contains(words[i])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String [] args) {
        // Initialize string and counter variables
        String fileName = "/Users/jordanbelinsky/Documents/GitHub/cisc124-summer2020/Assignments/Coding Assignment 1/assets/PoliticalSpeech.txt";
        String line = null;

        // File IO using FileReader and BufferedReader
        try {
            FileReader fileReader =
                new FileReader(fileName);

            BufferedReader bufferedReader =
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                // Split line into arrays to count
                String[] words = line.split(" ");
                String[] sentences = line.split("[.\\?\\!]");
                // Call counting methods
                countWords(words);
                countSentences(sentences);
                topWordsResult = top10Words(words);
                foundWordResult = wordFound(words,"responsibilities");
            }
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" +
                fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '"
                + fileName + "'");

        }
        // Output handling
        System.out.println("The number of words in the file is: " + wordCount);
        System.out.println();
        System.out.println("The number of sentences in the file is: " + sentenceCount);
        System.out.println();
        System.out.println("The top 10 words, and their respective frequencies, are as follows: ");

        for (int i = 0; i < topWordsResult.length; i++) {
            System.out.println(topWordsResult[i][0] + ": " + topWordsResult[i][1] + " times.");
        }

        // Try outputting top 10 words to an output file
        try {
            FileWriter fileOut = new FileWriter("top10Words.txt");
            for (int i = 0; i < topWordsResult.length; i++) {
                fileOut.write(topWordsResult[i][0] + ": " + topWordsResult[i][1] + " times." + "/n");
            }
            fileOut.close();
        } catch (IOException e1) {
            // If the file cannot be found or created, display error
            System.out.println("Error during reading/writing");
        }

        System.out.println();
        System.out.println("Checking if word 'responsibilities' is in the file: " + foundWordResult);
    }
}