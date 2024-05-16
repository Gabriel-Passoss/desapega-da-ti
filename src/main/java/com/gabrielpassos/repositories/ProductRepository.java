package com.gabrielpassos.repositories;

import com.gabrielpassos.entities.Product;
import java.util.ArrayList;

import java.util.Optional;

public interface ProductRepository {

    public Optional<Product> findProductByName(String name);

    public ArrayList findAll();

    public boolean create(Product product);

    public boolean update(Product product);

    public boolean delete(Product product);
}
