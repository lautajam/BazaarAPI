package com.lautajam.BazaarAPI.contoller;

import com.lautajam.BazaarAPI.model.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lautajam.BazaarAPI.service.SaleService;

import java.util.List;

@RestController
public class SaleController {

    @Autowired
    private SaleService saleService;

    /**
     * Create a new sale in "sale" table in the database.
     * @param sale
     */
    @PostMapping("/sales/create")
    public void createSale(@RequestBody Sale sale){
        saleService.saveSale(sale);
    }

    /**
     * Get all sales from "sale" table in the database.
     * @return List of all sales.
     */
    @GetMapping("/sales")
    @ResponseBody
    public List<Sale> getSales(){
        return saleService.getAllSales();
    }

}
