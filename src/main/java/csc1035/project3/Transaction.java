package csc1035.project3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Transaction {

    public void purchase(){
        float cost;
        float paid = 0;
        float change;

        List<List> listItemAndQuantity = new ArrayList();

        listItemAndQuantity = itemPurchased(listItemAndQuantity);

        cost = pricing();

        //If paid is more than cost, print out change and take away from the stock

        if(paid > cost ){
            change = paid - cost;
            //Need to finish. Database takes away from stock

            System.out.println(change);
        }

        //If paid is less than cost, print out not enough given and show how much more is needed

        else if (paid < cost){
            System.out.println("Not enough money given");
            change = cost - paid;
            System.out.println("The customer needs to pay " + change + " more");
        }

        //Else paid is equal to cost and no change must be given.

        else{
            System.out.println("No change to be given");
        }

        //Goes to receipt method with a list that has a lists in it. The inner lists have the item, quantity and price
        //inside it. The outer list is there in case there are multiple items that have been bought of different types.
        receipt(listItemAndQuantity);

    }

    //This methods gets all the items which have been purchased and their quantity.

    public List itemPurchased(List listItemAndQuantity){
        List itemAndQuantity = new ArrayList();

        Scanner input = new Scanner(System.in);

        //Lets user input an item that has been purchased.

        System.out.print("Please input the next item which has been purchased");
        String item = input.nextLine();

        //Lets user input the quantity of that item purchased.

        System.out.print("Please quantity of the next item which has been purchased");
        int Quantity = input.nextInt();
        itemAndQuantity.add(Quantity, item);

        //Inputs a list containing the Quantity of an Item and the Item into a list that can be returned
        // in order to work out the cost of all the items.

        listItemAndQuantity.add(itemAndQuantity);

        //Allows the user to input multiple items which have been purchased into the list of purchased items and
        // the quantity.

        listItemAndQuantity = anotherPurchase(input, listItemAndQuantity);

        return listItemAndQuantity;

    }

    //Allows the user to make a choice if there is another item which has been purchased. If they mistype or misspell
    // then this can be used for validation so that the user can go back and put in the correct choice.

    public List anotherPurchase(Scanner input, List listItemAndQuantity){
        String choice;

        System.out.print("Has another item been purchased? (yes or no)");
        choice = input.nextLine().toUpperCase();

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

    public float pricing(){
        float cost = 0;

        //Need to finish, gets price from database.
        //Could do this inside itemPurchased instead.

        return cost;
    }

    //Produces a receipt for the user which could be given to the customer.

    public void receipt(List Items){
        System.out.println("|---------------------+--------------------+---------------------|");
        System.out.println("|        Item         |      Quantity      |        Price        |");
        System.out.println("|---------------------+--------------------+---------------------|");

        //For Loop that prints out the Item, Quantity and Price based on their index with the item List.
        for(int i = 0; i < Items.size(); i++){
            System.out.println("|" + String.format("%-20s ", Items.get(i)) + "|" +
                    String.format("%-20s", Items.get(i)) + "|" +
                    String.format("%-20s ", Items.get(i)) + "|");
        }

        System.out.println("|---------------------+--------------------+---------------------|");
    }
}
