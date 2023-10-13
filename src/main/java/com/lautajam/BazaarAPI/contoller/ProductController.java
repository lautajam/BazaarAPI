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
        List<Product> allProductList = productService.getAllProducts();
        return allProductList;
    }

    /**
     * Returns a product with the given id.
     * @param product_code The id of the product to be returned
     * @return The product with the given id or null if no product with the given id exists
     */
    @GetMapping("/products/{product_id}")
    @ResponseBody
    public Product getProductById(@PathVariable("product_id") long product_code) {
        Product product = productService.getProductById(product_code);
        return product;
    }
}
