public class part3 {
    private static String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    public static String encode(String message, int key) {
        String[] chars = message.split("");
        for(String i : chars) {
            for(String j : alphabet) {
                if(chars[i] = alphabet[j]) {
                    chars[i] = alphabet[j+key];
                }
                else {
                    continue;
                }
            }
        }
    }

    public static String decode(String codedText, int key) {

    }
}

