package org.example.model;

public class Dish {
    private int id;
    private String name;
    private double price;

    public Dish(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return String.format(" %d | Name: %-25s | Price: ₹%.2f", id, name, price);
    }
}
