package csc1035.project3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Profit {
    private class ItemAndQuantity{
        String item;
        int quantity;
        public String getItem() {
            return item;
        }

        public void setItem(String item) {
            this.item = item;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
        public ItemAndQuantity(String[] list){
            this.item = list[0];
            this.quantity = Integer.parseInt(list[1]);
        }
    }
    public static void main(String[] args){
        Profit profit = new Profit();
        profit.calcProfit();
    }
    public void calcProfit(){
        double profit = 0;
        List<ItemAndQuantity> list = new ArrayList<>();
        System.out.println("Enter item name and quantity (item,quantity), or enter x to exit");
        Scanner scanner = new Scanner(System.in);
        String line;
        while(!(line = scanner.nextLine()).equals("x")){
            System.out.println(line);
            list.add(new ItemAndQuantity(line.split(",")));

        }
        for(ItemAndQuantity x:list){
            profit += (Output.getDBSellPrice(x.getItem()) - Output.getDBCost(x.getItem())) * x.getQuantity();
        }
        System.out.println(profit);
    }
}
