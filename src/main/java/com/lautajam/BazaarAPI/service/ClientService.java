package com.lautajam.BazaarAPI.service;

import com.lautajam.BazaarAPI.model.Client;
import com.lautajam.BazaarAPI.repository.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService implements IClientService{

    @Autowired
    private IClientRepository clientRepository;

    /**
     * Saves a client to the database.
     * @param client The client to be saved
     */
    @Override
    public void saveClient(Client client) {
        clientRepository.save(client);
    }
}
