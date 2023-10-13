package com.lautajam.BazaarAPI.service;

import com.lautajam.BazaarAPI.model.Sale;

public interface ISaleService {

    /**
     * Saves a sale to the database
     * @param sale The sale to be saved
     */
    public void saveSale(Sale sale);
}
