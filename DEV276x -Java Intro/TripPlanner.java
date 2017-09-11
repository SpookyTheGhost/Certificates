import java.util.*;

public class TripPlanner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to vacation planner!");
        System.out.println("What is your name? ");
        String name = input.nextLine();
        System.out.println("Nice to meet you " + name + ", where are you travelling to? ");
        String city = input.nextLine();
        System.out.println("Great! " + city + " sounds like a great trip");
        System.out.println("********************************************************************");
        System.out.println("How many days are you going to spend travelling? ");
        double days = input.nextDouble();
        System.out.println("How much money, in USD, are you planning to spend on your trip? ");
        double spend = input.nextDouble();
        System.out.println("What is the three letter currency symbol for your travel destination? ");
        String currencySymbol = input.next();
        System.out.println("How many " + currencySymbol + " are there in 1 USD? ");
        double conversionRate = input.nextDouble();
        System.out.println();
        double hours = 24 * days;
        System.out.println("if you are travelling for " + days + " days that is the same as " + hours + " hours");
        double USDallowance = spend/days;
        System.out.println("if you are going to spend " + spend + " USD that means per day, you can spend up to " +
                Math.round(USDallowance) + " USD");
        double convertTotal = spend * conversionRate;
        double allowance = convertTotal/days;
        System.out.println("your total budget in " + currencySymbol + " is " + convertTotal + ", which per day is " +
                Math.round(allowance) + " " + currencySymbol);
        System.out.println("********************************************************************");
        System.out.println("What is the time difference, in hours, between your home and your destination? ");
        int timezone = input.nextInt();
        int convert = 12 + timezone;
        String timeConversion = String.format ("%d", convert);
        System.out.println("When it is noon in your country, it will be " + timeConversion + ":00" + " in " + city);

        System.out.println("What is the square area of your destination country in km2? ");
        double area = input.nextDouble();
        System.out.println("in miles2, that is "  + (area * 0.386));
    }
}
