import java.util.*;

public class OddsOrEvens {

    public static void main(String[] args) {
        System.out.println("Let’s play a game called \"Odds or Evens\"");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        System.out.println("Hi " + name + ", which do you choose? (O)dds or (E)vens? ");
        String option = (input.nextLine()).toLowerCase();
        if (option.equals("o")) {
            System.out.println(name + " has picked odds! The computer will be evens.");
        }
        else if (option.equals("e")) {
            System.out.println(name + " has picked evens! The computer will be odds.");
        }
        else {
            System.out.println("Unknown option!");
        }

        System.out.println("--------------------------------------------------------------");

        System.out.println("How many “fingers” do you put out?");
        int user = input.nextInt();
        System.out.println("The user plays " + user);
        Random rand = new Random();
        int computer = rand.nextInt(10);
        System.out.println("The computer plays " + computer);

        System.out.println("--------------------------------------------------------------");

        boolean result = ((user + computer) % 2) == 0;
        System.out.println(user + " + " + computer + " is ..." + (user + computer));
        String winner = result ? "The result was even, the computer wins!" : "The result was odd, the user wins!";
        System.out.println(winner);

        System.out.println("--------------------------------------------------------------");

    }
}
