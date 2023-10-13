package com.lautajam.BazaarAPI.service;

import com.lautajam.BazaarAPI.dto.TopSaleDTO;
import com.lautajam.BazaarAPI.model.Product;
import com.lautajam.BazaarAPI.model.Sale;
import com.lautajam.BazaarAPI.repository.ISaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class SaleService implements ISaleService{

    private static final double INIT_DOUBLE = 0.0;
    private static final List<Product> listSaleProducts = new ArrayList<>();
    private static final Map<String, Double> mapSumOfAmountAndTotalAmountOfSales = new HashMap<>();
    private static final TopSaleDTO topSaleDTO = new TopSaleDTO();;

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

    /**
     *  Updates a sale with the given sale.
     *  @param sale The sale to be updated
     */
    @Override
    public void updateSale(Sale sale){
        this.saveSale(sale);
    }

    /**
     *  Deletes a sale with the given id.
     *  @param sale_code The id of the sale to be deleted
     */
    @Override
    public void deleteSaleById(long sale_code) {
        saleRepository.deleteById(sale_code);
    }

    /**
     * Return a list of products that are on sale
     * @param sale_code The id of the sale to be returned a list of products
     * @return A list of products that are on sale
     */
    public List<Product> getProductsOnSale(long sale_code){
        Sale productsOnSale = this.getSaleById(sale_code);
        listSaleProducts.clear();

        listSaleProducts.addAll(productsOnSale.getSale_products_list());

        return listSaleProducts;
    }

    /**
     * Return the sum of the amount and also the total amount of sales for a given day.
     * @param date The date to be returned the sum of the amount and also the total amount of sales
     * @return The sum of the amount and also the total amount of sales for a given day
     */
    public Map<String, Double> getSumOfAmountAndTotalAmountOfSales(LocalDate date){

        List<Sale> listAllSale = this.getAllSales();
        double sumAmountPrice  = INIT_DOUBLE;
        double salesQuantity   = INIT_DOUBLE;
        mapSumOfAmountAndTotalAmountOfSales.clear();

        for (Sale sale: listAllSale) {
            if (sale.getSale_date().equals(date)) {
                sumAmountPrice += sale.getSale_total();
                salesQuantity++;
            }
        }

        mapSumOfAmountAndTotalAmountOfSales.put("sumAmountPrice", sumAmountPrice);
        mapSumOfAmountAndTotalAmountOfSales.put("salesQuantity", salesQuantity);

        return mapSumOfAmountAndTotalAmountOfSales;
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
    public TopSaleDTO getTopSale(){
        List<Sale> listAllSale = this.getAllSales();
        double higherPrice  = INIT_DOUBLE;
        topSaleDTO.setTotalPrice(INIT_DOUBLE);

        for (Sale sale: listAllSale) {
            if (sale.getSale_total() > higherPrice) {
                higherPrice = topSaleDTO.getTotalPrice();
                topSaleDTO.setSale_code(sale.getSale_code());
                topSaleDTO.setTotalPrice(sale.getSale_total());
                topSaleDTO.setAmountOfProducts(sale.getSale_products_list().size());
                topSaleDTO.setClient_name(sale.getSale_client().getClient_name());
                topSaleDTO.setClient_surname(sale.getSale_client().getClient_surname());
            }
        }

        return topSaleDTO;
    }
}
