import java.util.*;
public class Crypto {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter text to encrypt: ");
        String text = input.nextLine();
        System.out.println("Enter integer shift value: ");
        int shift = input.nextInt();
        System.out.println("Enter chunking size: ");
        int size = input.nextInt();

        String encryptedText = encrypt(text, shift, size);
        String decryptedText = decrypt(text, shift, size);
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

    private static String caesarify(String text, int shift) {

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

    private static String encrypt(String text, int shift, int size) {
        String normalize = normalizeText(text);
        String obf = Obfuscation(normalize);
        String encrypted = caesarify(obf, shift);
        String split = Codegroups(encrypted, size);
        return split;
    }

    private static String decrypt(String text, int shift, int size) {
        String join = Codegroups(text, size);
        String decrypted = caesarify(join, shift * -1);
        String uobf = Unobfuscation(decrypted);
        return uobf;
    }
}
