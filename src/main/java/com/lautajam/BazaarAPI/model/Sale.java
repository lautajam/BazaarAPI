package com.lautajam.BazaarAPI.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

/**
 * Class representing the sale model of the application
 */
@Getter @Setter
@Entity
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    long sale_code;

    LocalDate sale_date;
    double sale_total;

    @ManyToMany
    @JoinTable(
            name = "sale_product",
            joinColumns = @JoinColumn(name = "sale_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> sale_products_list;

    @OneToOne
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    Client sale_client;

    /**
     * Empty constructor for the sale model
     */
    public Sale() {
    }

    /**
     * Constructor for the sale model
     * @param sale_code The code of the sale
     * @param sale_date The date of the sale
     * @param sale_total The total of the sale
     * @param sale_products_list The list of products of the sale
     * @param sale_client The client of the sale
     */
    public Sale(long sale_code, LocalDate sale_date, double sale_total,
                List<Product> sale_products_list, Client sale_client) {
        this.sale_code = sale_code;
        this.sale_date = sale_date;
        this.sale_total = sale_total;
        this.sale_products_list = sale_products_list;
        this.sale_client = sale_client;
    }
}
