// Name: Jordan Belinsky
// File: Part 3
// Purpose: A file to encode and decode a string based on a specific cipher shift key.

public class part3 {
    private static String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

    public static boolean checkIfLetter(String character, String[] letters) {
        // A function to check if the character is a letter.
        // String, String[] -> Boolean
        for(int i = 0; i < letters.length; i++) {
            if(character.contains(letters[i].toUpperCase()) || character.contains(letters[i].toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public static String encode(String message, int key) {
        // A function to encode the message based on the shift cipher key.
        // String, Integer -> String
        String codedText = "";
        // Run through the characters
        for(int i = 0; i < message.length(); i++) {
            String currentLetter = Character.toString(message.charAt(i));
            if(checkIfLetter(currentLetter, alphabet)) {
                char entry = (char) (message.charAt(i) + key);
                if (entry > 'z') {
                    codedText += (char) (message.charAt(i) - (26 - key));
                } else {
                    codedText += (char) (message.charAt(i) + key);
                }
            } else {
                codedText += currentLetter;
                continue;
            }
        }
        return codedText;
    }

    public static String decode(String codedText, int key) {
        // A function to decode the coded message based on the shift cipher key.
        // String, Integer -> String
        String decodedText = "";
        // Run through the characters
        for(int i = 0; i < codedText.length(); i++) {
            String currentLetter = Character.toString(codedText.charAt(i));
            if(checkIfLetter(currentLetter, alphabet)) {
                char entry = (char) (codedText.charAt(i) - key);
                if (entry > 'z') {
                    decodedText += (char) (codedText.charAt(i) - (26 - key));
                } else {
                    decodedText += (char) (codedText.charAt(i) - key);
                }
            } else {
                decodedText += currentLetter;
                continue;
            }
        }
        return decodedText;
    }

    public static void main(String[] args) {
        // Test outputs
        System.out.println(encode("A-BC.DEF F", 2));
        System.out.println(decode("C-DE.FGH H", 2));
    }
}

