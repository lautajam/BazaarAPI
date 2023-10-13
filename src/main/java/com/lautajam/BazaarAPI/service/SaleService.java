package com.lautajam.BazaarAPI.service;

import com.lautajam.BazaarAPI.model.Sale;
import com.lautajam.BazaarAPI.repository.ISaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService implements ISaleService{

    @Autowired
    private ISaleRepository saleRepository;

    /**
     * Saves a sale to the database
     * @param sale The sale to be saved
     */
    public void saveSale(Sale sale) {
        saleRepository.save(sale);
    }

    /**
     * Gets all sales from the database
     * @return A list of all sales
     */
    @Override
    public List<Sale> getAllSales() {
        List<Sale> allSales = saleRepository.findAll();
        return allSales;
    }

    /**
     * Returns a sale with the given id.
     * @param sale_code The id of the sale to be returned
     * @return The sale with the given id or null if no sale with the given id exists
     */
    @Override
    public Sale getSaleById(long sale_code) {
        Sale sale = saleRepository.findById(sale_code).orElse(null);
        return sale;
    }
}
