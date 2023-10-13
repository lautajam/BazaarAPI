package com.lautajam.BazaarAPI.contoller;

import com.lautajam.BazaarAPI.model.Sale;
import com.lautajam.BazaarAPI.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
     * @param product
     */
    @PostMapping("/create")
    public void createProduct(@RequestBody Product product) {
        productService.saveProduct(product);
    }

    /**
     * Get all products from "product" table in the database.
     * @return List of products.
     */
    @GetMapping("")
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
    @GetMapping("/{product_code}")
    @ResponseBody
    public Product getProductById(@PathVariable long product_code) {
        Product product = productService.getProductById(product_code);
        return product;
    }

    /**
     * Updates a product with the give a client.
     *
     * @param product The client to be updated
     */
    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product){
        productService.updateProduct(product);

        Product productUpdated = productService.getProductById(product.getProduct_code());

        return productUpdated;
    }

    /**
     *  Deletes a product with the given id.
     *  @param product_code The id of the product to be deleted
     */
    @DeleteMapping("delete/{product_code}")
    public void deleteProductById(@PathVariable("product_code") long product_code) {
        productService.deleteProductById(product_code);
    }

    /**
     * Return a list of products with the stock less than 5
     * @return A list of products with the stock less than 5
     */
    @GetMapping("/stockless")
    @ResponseBody
    public List<Product> getProductsByStockLess(){
        List<Product> listProductsStockLess = productService.getProductsByStockLess();

        return listProductsStockLess;
    }

}
