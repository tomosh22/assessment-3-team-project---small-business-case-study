package csc1035.project3;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.String.valueOf;

public class Transaction {

    /**
     * Purchase takes the list of items that have been purchased and compares
     * costs with how much is paid and then passes to receipt.
     */
    public static void purchase(){
        double itemCost = 0;
        double paid;
        double change;

        Scanner input = new Scanner(System.in);

        List<String> listItemAndQuantity = new ArrayList();

        //Makes a list of lists that has the different items, with their stock and quantity.

        listItemAndQuantity = itemPurchased(listItemAndQuantity);

        //This iterates to get all the costs of the items, in order to be printed out on the receipt.
        for (int i = 0; i < listItemAndQuantity.size(); i++){

            itemCost = Double.parseDouble(listItemAndQuantity.get(i).split(",")[2]);
            System.out.println(itemCost);
        }


        boolean paidEqualsCost = false;
        while(!paidEqualsCost) {
            System.out.print("How much has the buyer paid.");
            paid = Double.parseDouble(input.next());

            //If paid is more than cost, print out change and take away from the stock

            if (paid > itemCost) {
                change = paid - itemCost;
                changeStock(listItemAndQuantity);
                System.out.println(change);
                paidEqualsCost = true;
            }

            //If paid is less than cost, print out not enough given and show how much more is needed

            else if (paid < itemCost) {
                System.out.println("Not enough money given");
                change = itemCost - paid;
                System.out.println("The customer needs to pay " + change + " more");
            }

            //Else paid is equal to cost and no change must be given.

            else if (paid == itemCost) {
                System.out.println("No change to be given");
                changeStock(listItemAndQuantity);
                paidEqualsCost = true;
            }

            else {
                System.out.println("This is not a valid answer");
            }
        }

        //Goes to receipt method with a list that has lists in it. The inner lists have the item, quantity and price
        //inside it. The outer list is there in case there are multiple items that have been bought of different types.
        receipt(listItemAndQuantity);

    }

    /**
     * Changes the stock for all the items in the list and deducts the quantity which is bought.
     * @param listItemAndQuantity List of the items, quantity and cost.
     */
    public static void changeStock(List listItemAndQuantity){
        //For loop for size of array.
        for (int i = 0; i < listItemAndQuantity.size(); i++) {
            //Makes element in list a string
            String itemToBeUpdated = listItemAndQuantity.get(i).toString();
            //Splits that element into item and quantity.
            String item = itemToBeUpdated.split(",")[0];
            int quantity = Integer.parseInt(itemToBeUpdated.split(",")[1]);
            //Gets the items unique value
            int key = Output.getDBId(item);
            //Gets the new stock by taking away the quantity
            int stock = Output.getDBStock(item) - quantity;
            //Updates stock.
            Input.updateEntity(5, key, stock);
        }
    }

    //This methods gets all the items which have been purchased and their quantity.

    /**
     * This method adds the item quantity and cost to a list and will keep getting called
     * for everything that is being bought.
     * @param listItemAndQuantity List of the items, quantity and cost.
     * @return List of the items, quantity and cost.
     */

    public static List itemPurchased(List listItemAndQuantity){
        Scanner input = new Scanner(System.in);

        //Lets user input an item that has been purchased.

        System.out.print("Please input the next item which has been purchased");
        String item = input.nextLine();

        //Lets user input the quantity of that item purchased.

        System.out.print("Please quantity of the next item which has been purchased");
        int quantity = input.nextInt();
        double sellPrice = Output.getDBSellPrice(item);
        double cost = sellPrice * quantity;
        String stringCost = valueOf(cost);
        String stringQuantity = valueOf(quantity);
        String itemCostQuantity = (item+","+stringQuantity+","+stringCost);

        //Inputs a String containing the Quantity of an Item and the Item into a list that can be returned
        // in order to work out the cost of all the items.

        listItemAndQuantity.add(itemCostQuantity);

        //Allows the user to input multiple items which have been purchased into the list of purchased items and
        // the quantity.

        listItemAndQuantity = anotherPurchase(input, listItemAndQuantity);

        return listItemAndQuantity;

    }

    //Allows the user to make a choice if there is another item which has been purchased. If they mistype or misspell
    // then this can be used for validation so that the user can go back and put in the correct choice.

    /**
     * Just asks if there is another purchase to be made.
     * @param input This just scans for user input.
     * @param listItemAndQuantity List of the items, quantity and cost.
     * @return List of the items, quantity and cost.
     */

    public static List anotherPurchase(Scanner input, List listItemAndQuantity){
        String choice;

        System.out.print("Has another item been purchased? (yes or no)");
        choice = input.next().toUpperCase();

        //Allows the user to input another item that has been purchased into the list.

        if(choice.equals("YES")){
            itemPurchased(listItemAndQuantity);

        }

        //If no other item has been purchased this returns the list and will continue through the Transaction.

        else if(choice.equals("NO")){
            return listItemAndQuantity;

        }

        //If there is a mistype or misspell then the question will be re-asked using recursion.

        else{
            System.out.println("This is not a valid answer. Please try again.");
            anotherPurchase(input, listItemAndQuantity);

        }
        return listItemAndQuantity;

    }

    //Produces a receipt for the user which could be given to the customer.

    /**
     * Prints a receipt for the user.
     * @param listItemAndQuantity List of the items, quantity and cost.
     */

    public static void receipt(List listItemAndQuantity){
        System.out.println("|---------------------+--------------------+---------------------|");
        System.out.println("|        Item         |      Quantity      |        Price        |");
        System.out.println("|---------------------+--------------------+---------------------|");

        //For Loop that prints out the Item, Quantity and Price based on their index with the item List.
        for(int i = 0; i < listItemAndQuantity.size(); i++){
            String Items = listItemAndQuantity.get(i).toString();
            System.out.println("|" + String.format("%-20s ", Items.split(",")[0]) + "|" +
                    String.format("%-20s", Items.split(",")[1]) + "|" +
                    String.format("%-20s ", Items.split(",")[2]) + "|");
        }

        System.out.println("|---------------------+--------------------+---------------------|");
    }
}
