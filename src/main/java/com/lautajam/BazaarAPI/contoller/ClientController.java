package com.lautajam.BazaarAPI.contoller;

import com.lautajam.BazaarAPI.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lautajam.BazaarAPI.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    /**
     * Create a new client in "client" table in the database.
     *
     * @param client
     */
    @PostMapping("/create")
    public void createCliente(@RequestBody Client client) {
        clientService.saveClient(client);
    }

    /**
     * Get all clients from "client" table in the database.
     *
     * @return List of clients.
     */
    @GetMapping("")
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
    @GetMapping("/{client_id}")
    @ResponseBody
    public Client getClientById(@PathVariable long client_id) {
        Client clientById = clientService.getClientById(client_id);
        return clientById;
    }

    /**
     * Deletes a client with the given id.
     * @param client_id The id of the client to be deleted
     */
    @DeleteMapping("/delete/{client_id}")
    public void deleteClientById(@PathVariable long client_id){
        clientService.deleteClientById(client_id);
    }
}
