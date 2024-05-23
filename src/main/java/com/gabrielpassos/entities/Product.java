package com.gabrielpassos.entities;

import java.util.Date;

public class Product {

    private int id;
    private String name;
    private String description;
    private int quantity;
    private Double price;
    private Date createdAt;

    public Product() {
    }

    public Product(String name, String description, int quantity, Double price) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.createdAt = new Date();
    }

    public Product(int id, String name, String description, int quantity, Double price, Date createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date date) {

        this.createdAt = date;
    }

    @Override
    public String toString() {

        return "Name: " + this.name
                + "\nDescription: " + this.description
                + "\nQuantity: " + this.quantity
                + "\nPrice: " + this.price
                + "\nCreated at: " + this.createdAt;
    }
}
