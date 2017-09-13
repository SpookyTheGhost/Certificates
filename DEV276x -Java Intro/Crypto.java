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
        System.out.println(encryptedText);
        String decryptedText = decrypt(encryptedText, shift * -1);
        System.out.println(decryptedText);
    }

    private static String normalizeText(String text) {
        return text.replaceAll("[^a-zA-Z]", "").toUpperCase();
    }

    private static String Obfuscation(String text) {
        String Obfus = "";
        int i = 0;
        while (i < text.length()) {
            String ch = Character.toString(text.charAt(i));
            if (ch.contains("A") || ch.contains("E") || ch.contains("I") || ch.contains("O") || ch.contains("U")
                    || ch.contains("Y")) {
                Obfus += "OB";
            }
            Obfus += text.charAt(i);
            i++;
        }
        return Obfus;
    }

    private static String Unobfuscation(String text) {
        return text.replaceAll("(OB)([AEIOUY])", "$2");
    }

    private static String shiftAlphabet(int shift) {
        int start = 0;
        if (shift < 0) {
            start = (int) 'Z' + shift + 1;
        } else {
            start = 'A' + shift;
        }
        String result = "";
        char currChar = (char) start;
        for(; currChar <= 'Z'; ++currChar) {
            result = result + currChar;
        }
        if(result.length() < 26) {
            for(currChar = 'A'; result.length() < 26; ++currChar) {
                result = result + currChar;
            }
        }
        return result;
    }

    private static String caesarify(String text, int shift) {
        String cipher = "";
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String newKeys = shiftAlphabet(shift);

        for (int i = 0; i < text.length(); i++) {
            int index = alpha.indexOf(text.charAt(i)); // get original index
            cipher += newKeys.charAt(index); // add shifted to cipher result
        }
        return cipher;
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
        return Codegroups(encrypted, size);
    }

    private static String decrypt(String text, int shift) {
        String cleanup = text.replaceAll("x", "");
        String join = cleanup.replaceAll(" ", ""); // join chunk into single string
        String decrypted = caesarify(join, shift); // decrypt
        return Unobfuscation(decrypted); // remove obfuscation
    }
}
