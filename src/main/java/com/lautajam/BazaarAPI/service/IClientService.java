package com.lautajam.BazaarAPI.service;

import com.lautajam.BazaarAPI.model.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IClientService {

    /**
     * Saves a client to the database
     * @param client The client to be saved
     */
    public void saveClient(Client client);

    /**
     * Returns a list of all clients in the database.
     * @return A list of all clients in the database
     */
    public List<Client> getAllClients();
}
