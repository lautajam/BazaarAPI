package com.lautajam.BazaarAPI.service;

import com.lautajam.BazaarAPI.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lautajam.BazaarAPI.model.Product;

@Service
public class ProductService {

    @Autowired
    private IProductRepository productRepository;

    /**
     * Saves a product to the database.
     * @param product The product to be saved
     */
    public void saveProduct(Product product) {
        productRepository.save(product);
    }
}
