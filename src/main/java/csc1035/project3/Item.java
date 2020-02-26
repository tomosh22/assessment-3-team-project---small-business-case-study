package csc1035.project3;

import javax.persistence.*;

@Entity
@Table(name = "Items")
public class Item {

    public Item(int id, String name, String category, boolean perishable, float cost, int stock, float sell_price){
        this.id = id;
        this.name = name;
        this.category = category;
        this.perishable = perishable;
        this.cost = cost;
        this.stock = stock;
        this.sell_price = sell_price;
    }

    public float getCost() {
        return cost;
    }

    public float getSell_price() {
        return sell_price;
    }

    public boolean isPerishable() {
        return perishable;
    }

    public int getId() {
        return id;
    }

    public int getStock() {
        return stock;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }
}
