package com.lautajam.BazaarAPI.service;

import com.lautajam.BazaarAPI.model.Client;

public interface IClientService {

    /**
     * Saves a client to the database
     * @param client The client to be saved
     */
    public void saveClient(Client client);
}
