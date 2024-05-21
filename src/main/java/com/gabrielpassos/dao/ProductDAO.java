package com.gabrielpassos.dao;

import com.gabrielpassos.database.MySqlDriver;
import com.gabrielpassos.entities.Product;
import com.gabrielpassos.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements ProductRepository {

    private final MySqlDriver db;
    private final List<Product> productList;

    public ProductDAO() {
        this.db = new MySqlDriver();
        this.productList = new ArrayList<>();
    }

    @Override
    public Product findById(String name) {
        return null;

    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public boolean create(Product product) {
        return true;
    }

    @Override
    public boolean update(Product product) {
        return true;
    }

    @Override
    public boolean delete(Product product) {
        return true;
    }
}
