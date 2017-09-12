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
}
 
