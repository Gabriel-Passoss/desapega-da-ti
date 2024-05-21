package com.gabrielpassos.dao;

import com.gabrielpassos.database.MySqlDriver;
import com.gabrielpassos.entities.Product;
import com.gabrielpassos.repositories.ProductRepository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements ProductRepository {

    private final MySqlDriver db;
    private final List<Product> productList;

    public ProductDAO() {
        this.db = new MySqlDriver();
        this.productList = new ArrayList<>();
    }

    public int getMaxID() {
        String sql = "SELECT MAX(id) id FROM products";

        try (PreparedStatement stmt = db.getConnection().prepareStatement(sql)) {
            ResultSet res = stmt.executeQuery();

            if (res.next()) {

                return res.getInt("id");
            } else {
                return 0;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao obter o maior ID: " + e.getMessage());
        }
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
        String sql = "INSERT INTO products(id, name, description, quantity, price, created_at) VALUES(?,?,?,?,?,?)";

        try (PreparedStatement stmt = db.getConnection().prepareStatement(sql)) {

            stmt.setInt(1, product.getId());
            stmt.setString(2, product.getName());
            stmt.setString(3, product.getDescription());
            stmt.setInt(4, product.getQuantity());
            stmt.setDouble(5, product.getPrice());
            stmt.setDate(6, new java.sql.Date(product.getCreatedAt().getTime()));

            stmt.execute();

            return true;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar o produto: " + e.getMessage());
        }
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
