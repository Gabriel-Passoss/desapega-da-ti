package com.gabrielpassos.dao;

import com.gabrielpassos.database.MySqlDriver;
import com.gabrielpassos.entities.Product;
import com.gabrielpassos.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements ProductRepository{
    
    private final MySqlDriver db;
    private final List<Product> productList;

    public ProductDAO() {
        this.db = new MySqlDriver();
        this.productList = new ArrayList<>();
    }
}
