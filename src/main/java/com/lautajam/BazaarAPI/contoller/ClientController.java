package com.lautajam.BazaarAPI.contoller;

import com.lautajam.BazaarAPI.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lautajam.BazaarAPI.service.ClientService;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    /**
     * Create a new client in "client" table in the database.
     *
     * @param client
     */
    @PostMapping("/clients/create")
    public void createCliente(@RequestBody Client client) {
        clientService.saveClient(client);
    }

    /**
     * Get all clients from "client" table in the database.
     *
     * @return List of clients.
     */
    @GetMapping("/clients")
    @ResponseBody
    public List<Client> getAllClients() {
        List<Client> allClientList = clientService.getAllClients();
        return allClientList;
    }

    /**
     * Returns a client with the given id.
     * @param client_id The id of the client to be returned
     * @return The client with the given id or null if no client with the given id exists
     */
    @GetMapping("/clients/{client_id}")
    @ResponseBody
    public Client getClientById(@PathVariable long client_id) {
        Client clientById = clientService.getClientById(client_id);
        return clientById;
    }
}
