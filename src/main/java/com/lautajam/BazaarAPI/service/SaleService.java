package com.lautajam.BazaarAPI.service;

import com.lautajam.BazaarAPI.model.Sale;
import com.lautajam.BazaarAPI.repository.ISaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService {

    @Autowired
    private ISaleRepository saleRepository;

    /**
     * Saves a sale to the database
     * @param sale The sale to be saved
     */
    public void saveSale(Sale sale) {
        saleRepository.save(sale);
    }
}
