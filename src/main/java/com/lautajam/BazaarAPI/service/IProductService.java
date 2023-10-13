package com.lautajam.BazaarAPI.service;

import com.lautajam.BazaarAPI.model.Product;

public interface IProductService {

    /**
     * Saves a client to the database
     * @param product The product to be saved
     */
    public void saveClient(Product product);
}
