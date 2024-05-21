package com.gabrielpassos;

import com.gabrielpassos.dao.ProductDAO;
import com.gabrielpassos.services.ProductService;

public class Main {

    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();
        ProductService productService = new ProductService(productDAO);

        // CREATE
        productService.create("Mouse Optico", "description do mouse optico multlaser 4000 DPI.", 2, 125.99);
        //
        // READ ALL PRODUCTS
        //List<Product> products = productService.findAll();
        System.out.println(productService.findAll());
        //
    }
}
