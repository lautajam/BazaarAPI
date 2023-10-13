package com.lautajam.BazaarAPI.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/*
 * Class representing the product model of the application
 */
@Getter @Setter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    long   product_code;
    String product_name;
    String product_brand;
    double product_price;
    double product_quantity_available;

    @ManyToMany(mappedBy = "sale_products_list")
    private List<Sale> product_sales_list;

    /**
     * Empty constructor for the product model
     */
    public Product() {
    }

    /**
     * Constructor for the product model
     * @param product_code The code of the product
     * @param product_name The name of the product
     * @param product_brand The brand of the product
     * @param product_price The price of the product
     * @param product_quantity_available The quantity available of the product
     * @param product_sales_list The list of sales of the product
     */
    public Product(long product_code, String product_name, String product_brand,
                   double product_price, double product_quantity_available, List<Sale> product_sales_list) {
        this.product_code = product_code;
        this.product_name = product_name;
        this.product_brand = product_brand;
        this.product_price = product_price;
        this.product_quantity_available = product_quantity_available;
        this.product_sales_list = product_sales_list;
    }
}
