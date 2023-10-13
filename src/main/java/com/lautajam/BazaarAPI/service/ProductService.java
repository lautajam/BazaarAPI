package com.lautajam.BazaarAPI.service;

import com.lautajam.BazaarAPI.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lautajam.BazaarAPI.model.Product;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService{

    final double LESS_STOCK = 5.0;
    private final List<Product> voidList = new ArrayList<>();

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
        List<Product> allProductList = productRepository.findAll();
        return allProductList;
    }

    /**
     * Returns a product with the given id.
     * @param product_code The id of the product to be returned
     * @return The product with the given id or null if no product with the given id exists
     */
    public Product getProductById(long product_code) {
        Product product = productRepository.findById(product_code).orElse(null);
        return product;
    }

    /**
     * Updates a product with the give a product.
     * @param product The client to be updated
     */
    public void updateProduct(Product product){
        this.saveProduct(product);
    }

    /**
     *  Deletes a product with the given id.
     *  @param product_code The id of the product to be deleted
     */
    public void deleteProductById(long product_code) {
        productRepository.deleteById(product_code);
    }

    /**
     * Return a list of products with the stock less than 5
     * @return A list of products with the stock less than 5
     */
    public List<Product> getProductsByStockLess(){

        List<Product> listAllProducts = getAllProducts();
        List<Product> listProductsStockLess =  voidList;

        for (Product product:
             listAllProducts) {
            if (product.getProduct_quantity_available() < LESS_STOCK)
                listProductsStockLess.add(product);
        }
        return listProductsStockLess;
    }
}
