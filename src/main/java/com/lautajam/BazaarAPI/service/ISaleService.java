package com.lautajam.BazaarAPI.service;

import com.lautajam.BazaarAPI.dto.TopSaleDTO;
import com.lautajam.BazaarAPI.model.Product;
import com.lautajam.BazaarAPI.model.Sale;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public interface ISaleService {

    /**
     * Saves a sale to the database
     * @param sale The sale to be saved
     */
    public void saveSale(Sale sale);

    /**
     * Gets all sales from the database
     * @return A list of all sales
     */
    public List<Sale> getAllSales();

    /**
     * Returns a sale with the given id.
     * @param sale_code The id of the client to be returned
     * @return The sale with the given id or null if no sale with the given id exists
     */
    public Sale getSaleById(long sale_code);

    /**
     *  Deletes a sale with the given id.
     *  @param sale_code The id of the sale to be deleted
     */
    public void deleteSaleById(long sale_code);

    /**
     *  Updates a sale with the given sale.
     *  @param sale The sale to be updated
     */
    public void updateSale(Sale sale);

    /**
     * Return a list of products that are on sale
     * @param sale_code The id of the sale to be returned a list of products
     * @return A list of products that are on sale
     */
    public List<Product> getProductsOnSale(long sale_code);

    /**
     * Return the sum of the amount and also the total amount of sales for a given day.
     * @param date The date to be returned the sum of the amount and also the total amount of sales
     * @return The sum of the amount and also the total amount of sales for a given day
     */
    public Map<String, Double> getSumOfAmountAndTotalAmountOfSales(LocalDate date);

    /**
     * Return the top sale, the sale with the highest price
     * Uses the DTO TopSaleDTO that has the attributes:
     * private long sale_code;
     * private double totalPrice;
     * private int amountOfProducts;
     * private String client_name;
     * private String client_surname;
     * @return The top sale, the sale with the highest price
     */
    public TopSaleDTO getTopSale();
}
