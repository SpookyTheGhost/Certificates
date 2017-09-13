import java.util.*;
public class Crypto {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        String normalize = normalizeText(text);
        System.out.println(normalize);
    }

    private static String normalizeText(String text) {
        return text.replaceAll("[^a-zA-Z]", "").toUpperCase();
    }
    
    private static String Obfuscation(String text) {
        String Obfus = "";
        int i = 0;
        while (i < text.length()) {
            String ch = Character.toString(text.charAt(i));
            if (ch.contains("A") || ch.contains("E") || ch.contains("I") || ch.contains("O") || ch.contains("U")) {
                Obfus += "OB";
            }
            Obfus += text.charAt(i);
            i++;
        }
        return Obfus;
    }

    private static String Unobfuscation(String text) {
        return text.replaceAll("OB", "");
    }
    
    private static String Codegroups(String text, int size) {
        String temp = "";

        if (text.length() == 0) {
            return text;
        }

        for (int i = 0; i <= text.length()/size; i++) {
            int chunk = Math.min((1 + i) * size, text.length());
            String piece = text.substring(i*size, chunk);
            if (piece.length() != 0 && piece.length() < size) {
                piece += "x";
            }
            temp += piece;
            temp += " ";
        }
        return temp;
    }
}
 
