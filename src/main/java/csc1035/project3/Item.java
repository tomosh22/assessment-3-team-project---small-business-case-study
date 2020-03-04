package csc1035.project3;

import javax.persistence.*;

@Entity(name = "Item")
public class Item {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    @Column(updatable = false, nullable = false)
    private int id;

    @Column
    private String name;

    @Column
    private String category;

    @Column
    private boolean perishable;

    @Column
    private double cost;

    @Column
    private int stock;

    @Column
    private double sell_price;

    public Item(String name, String category, boolean perishable, double cost, int stock, double sell_price){
        this.name = name;
        this.category = category;
        this.perishable = perishable;
        this.cost = cost;
        this.stock = stock;
        this.sell_price = sell_price;
    }

    public Item(){
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost){
        this.cost = cost;
    }

    public double getSell_price() {
        return sell_price;
    }

    public void setSell_price(double sell_price) {
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
