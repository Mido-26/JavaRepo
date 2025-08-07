package DataStructure;
import java.util.*;
public class Main {
 public static void main(String[] args) {
        String text = "Hello, this is a sample text to demonstrate finding the fifth letter before the letter T in a string.";
        int index = findFifthLetterBeforeT(text);
        
        if (index != -1) {
            System.out.println("Index of 5th letter before T: " + index);
            System.out.println("Character: " + text.charAt(index));
        } else {
            System.out.println("Not enough letters before 'T'.");
        }
    }

    public static int findFifthLetterBeforeT(String text) {
        Stack<Integer> letterIndexes = new Stack<>();

        for (int i = 0; i < text.length(); i++) {
            if (Character.isLetter(text.charAt(i))) {
                letterIndexes.push(i);
            }

            if (text.charAt(i) == 'T') {
                if (letterIndexes.size() >= 5) {
                    // Pop 4 times, 5th is our target
                    for (int j = 0; j < 4; j++) {
                        letterIndexes.pop();
                    }
                    return letterIndexes.pop();
                } else {
                    return -1; // Not enough letters before T
                }
            }
        }

        return -1; // 'T' not found
    }
    
}


   
