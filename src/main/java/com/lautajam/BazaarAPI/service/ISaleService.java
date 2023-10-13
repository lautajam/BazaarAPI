package com.lautajam.BazaarAPI.service;

import com.lautajam.BazaarAPI.model.Sale;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
