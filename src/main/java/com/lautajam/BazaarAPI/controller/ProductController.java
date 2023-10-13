package com.lautajam.BazaarAPI.controller;

import com.lautajam.BazaarAPI.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.lautajam.BazaarAPI.model.Product;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * Create a new product in "product" table in the database.
     * @param product The product to be created.
     * @return ResponseEntity with a status code and a message.
     */
    @PostMapping("/create")
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        try {
            productService.saveProduct(product);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Get all products from "product" table in the database.
     * @return ResponseEntity with a list of products or a 204 No Content response if no products are found.
     */
    @GetMapping("")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> allProductList = productService.getAllProducts();

        if (!allProductList.isEmpty()) {
            return new ResponseEntity<>(allProductList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    /**
     * Returns a product with the given id.
     * @param product_code The id of the product to be returned.
     * @return ResponseEntity with the product or a 404 Not Found response if no product with the given ID exists.
     */
    @GetMapping("/{product_code}")
    public ResponseEntity<Product> getProductById(@PathVariable long product_code) {
        Product product = productService.getProductById(product_code);

        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Updates a product with the given product.
     * @param product The product to be updated.
     * @return ResponseEntity with the updated product or an Internal Server Error (500) response if an error occurs.
     */
    @PutMapping("/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        try {
            productService.updateProduct(product);
            Product productUpdated = productService.getProductById(product.getProduct_code());

            if (productUpdated != null) {
                return new ResponseEntity<>(productUpdated, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Deletes a product with the given id.
     * @param product_code The id of the product to be deleted.
     * @return ResponseEntity with a success message or an Internal Server Error (500) response if an error occurs.
     */
    @DeleteMapping("delete/{product_code}")
    public ResponseEntity<String> deleteProductById(@PathVariable("product_code") long product_code) {
        try {
            if (productService.getProductById(product_code) == null)
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            else {
                productService.deleteProductById(product_code);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Return a list of products with the stock less than 5.
     * @return ResponseEntity with a list of products with stock less than 5 or a 204 No Content response if no such products are found.
     */
    @GetMapping("/stockless")
    public ResponseEntity<List<Product>> getProductsByStockLess() {
        List<Product> listProductsStockLess = productService.getProductsByStockLess();

        if (!listProductsStockLess.isEmpty()) {
            return new ResponseEntity<>(listProductsStockLess, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
