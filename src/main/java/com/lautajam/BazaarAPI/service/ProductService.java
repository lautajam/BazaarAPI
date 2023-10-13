package com.lautajam.BazaarAPI.service;

import com.lautajam.BazaarAPI.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lautajam.BazaarAPI.model.Product;

import java.util.List;

@Service
public class ProductService implements IProductService{

    @Autowired
    private IProductRepository productRepository;

    /**
     * Saves a product to the database.
     * @param product The product to be saved
     */
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    /**
     * Returns a list of all products in the database.
     * @return A list of all products in the database
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
