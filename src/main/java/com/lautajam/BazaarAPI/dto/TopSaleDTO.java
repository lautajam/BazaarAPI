package com.lautajam.BazaarAPI.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class TopSaleDTO implements Serializable {

    private long sale_code;
    private double totalPrice;
    private int amountOfProducts;
    private String client_name;
    private String client_surname;

    public TopSaleDTO() {
    }

    public TopSaleDTO(long sale_code, double totalPrice, int amountOfProducts, String client_name, String client_surname) {
        this.sale_code = sale_code;
        this.totalPrice = totalPrice;
        this.amountOfProducts = amountOfProducts;
        this.client_name = client_name;
        this.client_surname = client_surname;
    }
}
