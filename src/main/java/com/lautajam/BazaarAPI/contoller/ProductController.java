package com.lautajam.BazaarAPI.contoller;

import com.lautajam.BazaarAPI.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lautajam.BazaarAPI.model.Product;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * Create a new product in "product" table in the database.
     * @param product
     */
    @PostMapping("/products/create")
    public void createProduct(@RequestBody Product product) {
        productService.saveProduct(product);
    }

    /**
     * Get all products from "product" table in the database.
     * @return List of products.
     */
    @GetMapping("/products")
    @ResponseBody
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
}
