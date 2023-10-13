package com.lautajam.BazaarAPI.contoller;

import com.lautajam.BazaarAPI.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lautajam.BazaarAPI.model.Product;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * Create a product
     * @param product
     * @return String message of the operation success
     */
    @PostMapping("/product/create")
    public void createProduct(@RequestBody Product product) {
        productService.saveProduct(product);
    }
}
