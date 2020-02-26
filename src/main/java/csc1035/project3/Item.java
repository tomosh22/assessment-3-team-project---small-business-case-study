package csc1035.project3;

import javax.persistence.*;

@Entity
@Table(name = "Items")
public class Item {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "ItemId", updatable = false, nullable = false)
    private final int id;

    @Column(name = "Item Name")
    private String name;

    @Column(name = "Category")
    private String category;

    @Column(name = "perishable")
    private boolean perishable;

    @Column(name = "Cost")
    private float cost;

    @Column(name = "Stock")
    private int stock;

    @Column(name = "Sell Price")
    private float sell_price;

    public Item(int id, String name, String category, boolean perishable, float cost, int stock, float sell_price){
        this.id = id;
        this.name = name;
        this.category = category;
        this.perishable = perishable;
        this.cost = cost;
        this.stock = stock;
        this.sell_price = sell_price;
    }

    public Item(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost){
        this.cost = cost;
    }

    public float getSell_price() {
        return sell_price;
    }

    public void setSell_price(float sell_price) {
        this.sell_price = sell_price;
    }

    public boolean isPerishable() {
        return perishable;
    }

    public void setPerishable(boolean perishable) {
        this.perishable = perishable;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
