package com.lautajam.BazaarAPI.contoller;

import com.lautajam.BazaarAPI.model.Client;
import com.lautajam.BazaarAPI.model.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lautajam.BazaarAPI.service.SaleService;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    /**
     * Create a new sale in "sale" table in the database.
     * @param sale
     */
    @PostMapping("/create")
    public void createSale(@RequestBody Sale sale){
        saleService.saveSale(sale);
    }

    /**
     * Get all sales from "sale" table in the database.
     * @return List of all sales.
     */
    @GetMapping("")
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
    @GetMapping("/{sale_code}")
    @ResponseBody
    public Sale getSale(@PathVariable("sale_code") int sale_code){
        Sale sale = saleService.getSaleById(sale_code);
        return sale;

    }

    /**
     *  Deletes a sale with the given id.
     *  @param sale_code The id of the sale to be deleted
     */
    @DeleteMapping("delete/{sale_code}")
    public void deleteSale(@PathVariable("sale_code") int sale_code){
        saleService.deleteSaleById(sale_code);
    }

    /**
     *  Updates a sale with the given sale.
     *  @param sale The sale to be updated
     */
    @PutMapping("/update")
    public Sale updateSale(@RequestBody Sale sale){

        saleService.updateSale(sale);

        Sale saleUpdated = saleService.getSaleById(sale.getSale_code());

        return saleUpdated;
    }
}
