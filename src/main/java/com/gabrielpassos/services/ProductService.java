package com.gabrielpassos.services;

import com.gabrielpassos.entities.Product;
import com.gabrielpassos.dao.ProductDAO;

import java.util.Date;
import java.util.List;

public class ProductService {

    private final ProductDAO dao;

    public ProductService(ProductDAO dao) {
        this.dao = dao;
    }

    public int getMaxID() {
        try {
            int maxID = dao.getMaxID();

            return maxID;
        } catch (Exception e) {
            System.out.println("Erro ao obter o máximo ID: " + e.getMessage());
            return -1;
        }

    }

    public boolean create(String name, String description, int quantity, double price) {
        try {
            if (name == null || name.isEmpty() || name.length() < 2) {
                throw new IllegalArgumentException("Nome do produto não pode ser nulo, vazio ou menor que dois caracteres");
            }

            if (description == null || description.isEmpty() || description.length() < 10) {
                throw new IllegalArgumentException("Descrição do produto não pode ser nula, vazia ou menor que dez caracteres");
            }

            if (quantity <= 0) {
                throw new IllegalArgumentException("Quantidade tem que ser maior que zero");
            }
            if (price <= 0) {
                throw new IllegalArgumentException("Preço tem que ser maior que zero");
            }

            int id = this.getMaxID() + 1;

            Date date = new Date();

            Product product = new Product(id, name, description, quantity, price, date);

            boolean isCreated = dao.create(product);
            if (isCreated) {
                System.out.println("Produto cadastrado com sucesso!");
                return true;
            } else {
                System.out.println("Falha ao cadastrar o produto.");
                return false;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erro na validação dos dados informados: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Erro ao criar o produto: " + e.getMessage());
            return false;
        }
    }

    public List findAll() {
        try {
            List<Product> products = dao.findAll();
            
            if (products.isEmpty()) {
                System.out.println("Nenhum produto encontrado.");
            } else {
                System.out.println(products.size() + " produtos encontrados.");
            }
            return products;
        } catch (Exception e) {
            System.out.println("Erro ao buscar todos os produtos: " + e.getMessage());
            return List.of();
        }
    }
}
