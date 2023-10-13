package com.lautajam.BazaarAPI.contoller;

import com.lautajam.BazaarAPI.model.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lautajam.BazaarAPI.service.SaleService;

@RestController
public class SaleController {

    @Autowired
    private SaleService saleService;

    @PostMapping("/sale/create")
    public String createSale(@RequestBody Sale sale){
        saleService.saveSale(sale);

        return "Sale created";
    }
}
