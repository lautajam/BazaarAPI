package com.lautajam.BazaarAPI.service;

import com.lautajam.BazaarAPI.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {

    /**
     * Saves a client to the database
     * @param product The product to be saved
     */
    public void saveProduct(Product product);

    /**
     * Gets all clients from the database
     * @return The all clients list
     */
    public List<Product> getAllProducts();
}
