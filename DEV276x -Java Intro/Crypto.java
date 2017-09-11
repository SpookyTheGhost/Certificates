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

}
 
