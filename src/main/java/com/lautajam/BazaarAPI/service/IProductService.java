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

    /**
     * Returns a product with the given id.
     * @param product_code The id of the product to be returned
     * @return The product with the given id or null if no client with the given id exists
     */
    public Product getProductById(long product_code);

    /**
     * Updates a product with the give a product.
     * @param product The client to be updated
     */
    public void updateProduct(Product product);

    /**
     *  Deletes a product with the given id.
     *  @param product_code The id of the product to be deleted
     */
    public void deleteProductById(long product_code);

    /**
     * Return a list of products with the stock less than 5
     * @return A list of products with the stock less than 5
     */
    public List<Product> getProductsByStockLess();
}
