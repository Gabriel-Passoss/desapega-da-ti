package com.gabrielpassos.dao;

import com.gabrielpassos.database.MySqlDriver;
import com.gabrielpassos.entities.Product;
import com.gabrielpassos.repositories.ProductRepository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductDAO implements ProductRepository {

    private final MySqlDriver db;

    public ProductDAO() {
        this.db = new MySqlDriver();
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
    public Product findById(int id) {
        String sql = "SELECT * FROM products WHERE id = ?";

        try (PreparedStatement stmt = db.getConnection().prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();

            if (res.next()) {
                int productId = res.getInt("id");
                String name = res.getString("name");
                String description = res.getString("description");
                int quantity = res.getInt("quantity");
                double price = res.getDouble("price");
                Date createdAt = res.getDate("created_at");

                return new Product(productId, name, description, quantity, price, createdAt);
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar o produto: " + e.getMessage());
        }

    }

    @Override
    public List findAll() {
        String sql = "SELECT * FROM products";
        List<Product> productList = new ArrayList<>();

        try (PreparedStatement stmt = db.getConnection().prepareStatement(sql); ResultSet res = stmt.executeQuery()) {

            while (res.next()) {
                int id = res.getInt("id");
                String name = res.getString("name");
                String description = res.getString("description");
                int quantity = res.getInt("quantity");
                double price = res.getDouble("price");
                Date createdAt = res.getDate("created_at");

                Product product = new Product(id, name, description, quantity, price, createdAt);
                productList.add(product);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar todos os produtos: " + e.getMessage());
        }

        return productList;
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
        String sql = "UPDATE products SET name = ?, description = ?, quantity = ?, price = ?, created_at = ?  WHERE id = ?";

        try (PreparedStatement stmt = db.getConnection().prepareStatement(sql)) {

            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setInt(3, product.getQuantity());
            stmt.setDouble(4, product.getPrice());
            stmt.setDate(5, new java.sql.Date(product.getCreatedAt().getTime()));
            stmt.setInt(6, product.getId());

            stmt.execute();

            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar o produto: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM products WHERE id = ?";

        try (PreparedStatement stmt = db.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);

            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException erro) {
            throw new RuntimeException("Erro ao deletar o produto com ID " + id + ": " + erro.getMessage());
        }
    }
}
