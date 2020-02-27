package csc1035.project3;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        boolean exit = false;   //Used so that the menu will repeat
        Scanner userInput = new Scanner(System.in);
        while (!exit) {
            // Print the menu options out to the user
            System.out.println("Available options:\n" +
                    "makepurchase   -   Read the CSV file to an array.\n" +
                    "checkstock   -   Produce a receipt of the transaction\n" +
                    "updatestock    -   Update the stock in the database.\n" +
                    "exit           -   Exit the program.\n");
            System.out.print("Please enter your choice: ");
            String choice = userInput.next();   // stores user menu choice
            switch (choice) {
                case "exit":
                    exit = true;
                case "makepurchase":
                    break;

                case "checkstock":
                    break;

                case "updatestock":
                    break;
            }

        }
    }

}
