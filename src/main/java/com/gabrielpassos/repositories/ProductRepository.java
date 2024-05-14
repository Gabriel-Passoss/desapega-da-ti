package com.gabrielpassos.repositories;

import com.gabrielpassos.entities.Product;

import java.util.Optional;

public interface ProductRepository {
    public Optional<Product> findProductByName(String name);

    public void create(Product product);

    public void update(Product product);

    public void delete(Product product);
}
