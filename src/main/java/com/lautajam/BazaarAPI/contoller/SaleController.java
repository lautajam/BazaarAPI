package com.lautajam.BazaarAPI.contoller;

import com.lautajam.BazaarAPI.dto.TopSaleDTO;
import com.lautajam.BazaarAPI.model.Product;
import com.lautajam.BazaarAPI.model.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
     * @param sale The sale object to be created.
     * @return ResponseEntity with a status code and a message.
     */
    @PostMapping("/create")
    public ResponseEntity<String> createSale(@RequestBody Sale sale) {
        try {
            saleService.saveSale(sale);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Get all sales from "sale" table in the database.
     * @return ResponseEntity with a list of all sales.
     */
    @GetMapping("")
    public ResponseEntity<List<Sale>> getSales() {
        List<Sale> allSales = saleService.getAllSales();

        if (allSales.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(allSales, HttpStatus.OK);
        }
    }

    /**
     * Returns a sale with the given id.
     * @param sale_code The id of the sale to be returned.
     * @return ResponseEntity with the sale or a 404 Not Found response if no sale with the given id exists.
     */
    @GetMapping("/{sale_code}")
    public ResponseEntity<Sale> getSale(@PathVariable("sale_code") int sale_code) {
        Sale sale = saleService.getSaleById(sale_code);

        if (sale != null) {
            return new ResponseEntity<>(sale, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Deletes a sale with the given id.
     * @param sale_code The id of the sale to be deleted.
     * @return ResponseEntity with a status code and a message.
     */
    @DeleteMapping("delete/{sale_code}")
    public ResponseEntity<String> deleteSale(@PathVariable("sale_code") int sale_code) {
        try {
            if (saleService.getSaleById(sale_code) == null)
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            else {
                saleService.deleteSaleById(sale_code);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Updates a sale with the given sale.
     * @param sale The sale to be updated.
     * @return ResponseEntity with the updated sale or a 404 Not Found response if no sale with the given ID exists.
     */
    @PutMapping("/update")
    public ResponseEntity<Sale> updateSale(@RequestBody Sale sale) {
        try {
            saleService.updateSale(sale);
            Sale saleUpdated = saleService.getSaleById(sale.getSale_code());

            if (saleUpdated != null) {
                return new ResponseEntity<>(saleUpdated, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Return a list of products that are on sale.
     * @param sale_code The id of the sale to be returned a list of products.
     * @return ResponseEntity with a list of products that are on sale or a 404 Not Found response if no products are found for the given sale.
     */
    @GetMapping("/products/{sale_code}")
    public ResponseEntity<List<Product>> getProductsOnSale(@PathVariable long sale_code) {
        try {
            List<Product> listSaleProducts = saleService.getProductsOnSale(sale_code);
            return new ResponseEntity<>(listSaleProducts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    /**
     * Return the sum of the amount and also the total amount of sales for a given day.
     * @param date The date to be returned the sum of the amount and also the total amount of sales
     * @return The sum of the amount and also the total amount of sales for a given day
     */
    @GetMapping("/date/{date}")
    public ResponseEntity<Map<String, Double>> getSumOfAmountAndTotalAmountOfSales(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        Map<String, Double> salesByDate = saleService.getSumOfAmountAndTotalAmountOfSales(date);

        if (salesByDate != null) {
            return new ResponseEntity<>(salesByDate, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Return the top sale, the sale with the highest price.
     * Uses the DTO TopSaleDTO that has the attributes:
     * private long sale_code;
     * private double totalPrice;
     * private int amountOfProducts;
     * private String client_name;
     * private String client_surname;
     * @return ResponseEntity with the top sale or a 404 Not Found response if no top sale is found.
     */
    @GetMapping("/top")
    public ResponseEntity<TopSaleDTO> getTopSale() {
        TopSaleDTO topSale = saleService.getTopSale();

        if (topSale != null) {
            return new ResponseEntity<>(topSale, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
