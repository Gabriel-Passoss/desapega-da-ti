package com.gabrielpassos;

import com.gabrielpassos.dao.ProductDAO;
import com.gabrielpassos.services.ProductService;

public class Main {

    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();
        ProductService productService = new ProductService(productDAO);

        // CREATE
        //productService.create("Mouse Optico", "description do mouse optico multlaser 4000 DPI.", 2, 125.99);
        //
        // READ ALL PRODUCTS
        //System.out.println(productService.findAll());
        //
        // READ ONE PRODUCT
        //System.out.println(productService.findById(1));
        //
        // DELETE
        //productService.delete(1);
        //
        // UPDATE
        productService.update(1, "Teclado Mecânico ", "description.", 2, 125.99);

    }
}
