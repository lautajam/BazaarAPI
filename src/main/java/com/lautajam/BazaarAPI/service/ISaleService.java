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
}
