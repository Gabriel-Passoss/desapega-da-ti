package com.gabrielpassos.repositories;

import com.gabrielpassos.entities.Product;
import java.util.List;

public interface ProductRepository {

    public Product findById(int id);

    public List findAll();

    public boolean create(Product product);

    public boolean update(Product product);

    public boolean delete(Product product);
}
