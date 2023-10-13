package com.lautajam.BazaarAPI.service;

import com.lautajam.BazaarAPI.model.Client;
import com.lautajam.BazaarAPI.repository.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * Returns a list of all clients in the database.
     * @return A list of all clients in the database
     */
    @Override
    public List<Client> getAllClients() {
       List<Client> allClientList = clientRepository.findAll();
       return allClientList;
    }
}
