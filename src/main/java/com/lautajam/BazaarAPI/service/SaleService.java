package com.lautajam.BazaarAPI.service;

import com.lautajam.BazaarAPI.repository.ISaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService {

    @Autowired
    private ISaleRepository saleRepository;
}
