package csc1035.project3;
import java.util.Scanner;

// This class has only been used for testing currently. Will probably be deleted later.


public class Main {
    public static void main(String[] args) {
        boolean exit = false;   //Used so that the menu will repeat
        Scanner userInput = new Scanner(System.in);
        while (!exit) {
            // Print the menu options out to the user
            System.out.println("Available options:\n" +
                    "makepurchase   -   Start a new purchase.\n" +
                    "checkstock     -   Check the current stock in the database\n" +
                    "updatestock    -   Update the stock in the database.\n" +
                    "readfile       -   Read a CSV file into a table.\n" +
                    "exit           -   Exit the program.\n");
            System.out.print("Please enter your choice: ");
            String choice = userInput.next();   // stores user menu choice
            switch (choice) {
                case "exit":
                    exit = true;
                case "makepurchase":
                    break;

                case "checkstock":
                    Output output = new Output();
                    output.outputResults(Output.getAllDBStock());
                    break;

                case "updatestock":
                    break;

                case "readfile":
                    System.out.print("Please enter the file to use: ");
                    String fileDirectory = userInput.next();
                    Input.readFile(fileDirectory);
                    break;
            }
        }
    }
}
