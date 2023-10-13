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
        List<Sale> allSales = saleService.getAllSales();
        return allSales;
    }

    /**
     * Returns a sale with the given id.
     * @param sale_code The id of the sale to be returned
     * @return The sale with the given id or null if no sale with the given id exists
     */
    @GetMapping("/sales/{sale_code}")
    @ResponseBody
    public Sale getSale(@PathVariable("sale_code") int sale_code){
        Sale sale = saleService.getSaleById(sale_code);
        return sale;
    }

}
