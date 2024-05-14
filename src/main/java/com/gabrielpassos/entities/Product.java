package com.gabrielpassos.entities;

public class Product {
    private int id;

    private String name;

    private Double price;

    private String SKU;

    public Product(int id, String name, Double price, String SKU) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.SKU = SKU;
    }

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }
}
