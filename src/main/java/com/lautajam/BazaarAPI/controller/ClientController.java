package com.lautajam.BazaarAPI.controller;

import com.lautajam.BazaarAPI.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
     * @param client The client to be created.
     * @return ResponseEntity with a success message or an Internal Server Error (500) response if an error occurs.
     */
    @PostMapping("/create")
    public ResponseEntity<String> createCliente(@RequestBody Client client) {
        try {
            clientService.saveClient(client);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Get all clients from "client" table in the database.
     * @return ResponseEntity with a list of clients or a 204 No Content response if no clients are found.
     */
    @GetMapping("")
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> allClientList = clientService.getAllClients();

        if (!allClientList.isEmpty()) {
            return new ResponseEntity<>(allClientList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    /**
     * Returns a client with the given id.
     * @param client_id The id of the client to be returned.
     * @return ResponseEntity with the client or a 404 Not Found response if no client with the given ID exists.
     */
    @GetMapping("/{client_id}")
    public ResponseEntity<Client> getClientById(@PathVariable long client_id) {
        Client clientById = clientService.getClientById(client_id);

        if (clientById != null) {
            return new ResponseEntity<>(clientById, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Updates a client with the given client.
     * @param client The client to be updated.
     * @return ResponseEntity with the updated client or a 404 Not Found response if no client with the given ID exists.
     */
    @PutMapping("/update")
    public ResponseEntity<Client> updateClient(@RequestBody Client client) {
        try {
            clientService.updateClient(client);
            Client clientUpdated = clientService.getClientById(client.getClient_id());

            if (clientUpdated != null) {
                return new ResponseEntity<>(clientUpdated, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Deletes a client with the given id.
     * @param client_id The id of the client to be deleted.
     * @return ResponseEntity with a success message or an Internal Server Error (500) response if an error occurs.
     */
    @DeleteMapping("/delete/{client_id}")
    public ResponseEntity<String> deleteClientById(@PathVariable long client_id) {
        try {
            if (clientService.getClientById(client_id) == null)
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            else {
                clientService.deleteClientById(client_id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
