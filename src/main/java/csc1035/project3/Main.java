package csc1035.project3;
import java.util.Scanner;

// This class has only been used for testing currently. Will probably be deleted later.


public class Main {
    public static void main(String[] args) {
        boolean exit = false;   //Used so that the menu will repeat
        Scanner userInput = new Scanner(System.in);
        while (!exit) {
            // Print the menu options out to the user
            System.out.println("\nAvailable options:\n" +
                    "makepurchase   -   Start a new purchase.\n" +
                    "checkstock     -   Check the current stock in the database\n" +
                    "updatestock    -   Update the stock in the database.\n" +
                    "readfile       -   Read a CSV file into a table.\n" +
                    "profit         -   Enter items and quantity to work out profit you will receive.\n" +
                    "exit           -   Exit the program.\n");
            System.out.print("Please enter your choice: ");
            String choice = userInput.next();   // stores user menu choice
            switch (choice) {
                case "exit":

                    // This will exit from the program

                    exit = true;
                    break;

                case "makepurchase":

                    // This will be used to start a transaction

                    Transaction.purchase();
                    break;

                case "checkstock":

                    // This code will output the stock of all items in the Item table

                    Output output = new Output();
                    output.outputResults(Output.getAllDBStock());
                    break;

                case "updatestock":

                    // This code is used to update the stock of an entity in the table

                    System.out.print("Please enter the ID of the item which you wish to update: ");
                    int itemID = Integer.parseInt(userInput.next());
                    System.out.print("Please enter the new stock of the item: ");
                    int newStock = Integer.parseInt(userInput.next());
                    Input.updateEntity(5, itemID, newStock);
                    System.out.println("Stock has been updated");
                    break;


                case "readfile":

                    // This code will write data from a CSV file to a table

                    System.out.print("Please enter the file to use: ");
                    String fileDirectory = userInput.next();
                    Input.readFile(fileDirectory);
                    break;

                case "profit":

                    // This code will run the profit calculator

                    Profit profit = new Profit();
                    profit.calcProfit();

                    break;

                default:
                    break;
            }
        }
    }
}
