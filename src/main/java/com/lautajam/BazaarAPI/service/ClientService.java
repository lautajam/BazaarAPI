package com.lautajam.BazaarAPI.service;

import com.lautajam.BazaarAPI.repository.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private IClientRepository clientRepository;
}
