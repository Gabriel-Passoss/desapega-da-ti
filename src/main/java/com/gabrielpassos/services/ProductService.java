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

            Product product = new Product(name, description, quantity, price);

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

    public Product findById(int id) {
        try {
            if (id <= 0) {
                throw new IllegalArgumentException("ID do produto deve ser maior que zero");
            }

            Product product = dao.findById(id);

            if (product != null) {
                System.out.println("Produto com ID: " + id + " encontrado com sucesso!");
                return product;

            } else {
                System.out.println("Produto com ID: " + id + " não encontrado.");
                return null;
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Erro na validação do ID: " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.out.println("Erro ao buscar o produto: " + e.getMessage());
            return null;
        }
    }

    public boolean delete(int id) {
        try {
            if (id <= 0) {
                throw new IllegalArgumentException("ID do produto deve ser positivo");
            }

            boolean isDeleted = dao.delete(id);

            if (isDeleted) {
                System.out.println("Produto com ID: " + id + " deletado com sucesso!");
                return true;
            } else {
                System.out.println("Não foi possível cadastrar o produto.");
                return false;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erro na validação do ID: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Erro ao deletar o produto: " + e.getMessage());
            return false;
        }
    }

    public boolean update(int id, String name, String description, int quantity, double price) {
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

            Product productExists = dao.findById(id);

            if (productExists == null) {
                System.out.println("Produto com ID: " + id + " não encontrado.");
                return false;
            }

            Product product = new Product(productExists.getId(), name, description, quantity, price, productExists.getCreatedAt());

            boolean isUpdated = dao.update(product);

            if (isUpdated) {
                System.out.println("Produto com ID: " + id + " atualizado com sucesso!");
                return true;
            } else {
                System.out.println("Falha ao atualizar o produto com ID: " + id);
                return false;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erro na validação dos dados informados: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Erro ao atualizar o produto: " + e.getMessage());
            return false;
        }
    }
}
