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

    /**
     * Returns a client with the given id.
     * @param client_id The id of the client to be returned
     * @return The client with the given id or null if no client with the given id exists
     */
    @Override
    public Client getClientById(long client_id) {
        Client clientById = clientRepository.findById(client_id).orElse(null);
        return clientById;
    }

    /**
     * Deletes a client with the given id.
     * @param client_id The id of the client to be deleted
     */
    public void deleteClientById(long client_id){
        clientRepository.deleteById(client_id);
    }


}
