package com.lautajam.BazaarAPI.contoller;

import com.lautajam.BazaarAPI.dto.TopSaleDTO;
import com.lautajam.BazaarAPI.model.Product;
import com.lautajam.BazaarAPI.model.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lautajam.BazaarAPI.service.SaleService;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

    /**
     * Return a list of products that are on sale
     * @param sale_code The id of the sale to be returned a list of products
     * @return A list of products that are on sale
     */
    @GetMapping("/products/{sale_code}")
    @ResponseBody
    public List<Product> getProductsOnSale(@PathVariable long sale_code){
        List<Product> listSaleProducts = saleService.getProductsOnSale(sale_code);
        return listSaleProducts;
    }


    /**
     * Return the sum of the amount and also the total amount of sales for a given day.
     * @param date The date to be returned the sum of the amount and also the total amount of sales
     * @return The sum of the amount and also the total amount of sales for a given day
     */
    @GetMapping("/date/{date}")
    @ResponseBody
    public Map<String, Double> getSumOfAmountAndTotalAmountOfSales(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        Map<String, Double> salesByDate = saleService.getSumOfAmountAndTotalAmountOfSales(date);
        return salesByDate;
    }

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
    @GetMapping("/top")
    @ResponseBody
    public TopSaleDTO getTopSale(){
        TopSaleDTO topSale = saleService.getTopSale();
        return topSale;
    }
}
