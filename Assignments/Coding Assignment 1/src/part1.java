import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class part1 {
    public static void main(String [] args) {

        // Initialize string and counter variables
        String fileName = "C:\\Users\\Jordan Belinsky\\Documents\\GitHub\\cisc124-summer2020\\Assignments\\Coding Assignment 1\\assets\\PoliticalSpeech.txt";
        String line = null;
        int wordCount = 0;
        int sentenceCount = 0;

        try {
            FileReader fileReader =
                new FileReader(fileName);

            BufferedReader bufferedReader =
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                // Split line into arrays to count
                String[] words = line.split(" ");
                String[] sentences = line.split("[.\\?\\!]");
                for(String i : words) {
                    wordCount++;
                }
                for(String i : sentences) {
                    sentenceCount++;
                }
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
        System.out.println("The number of sentences in the file is: " + sentenceCount);
    }
}