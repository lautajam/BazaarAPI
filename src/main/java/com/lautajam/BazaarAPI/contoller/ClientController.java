package com.lautajam.BazaarAPI.contoller;

import com.lautajam.BazaarAPI.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lautajam.BazaarAPI.service.ClientService;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/client/create")
    public String createCliente(@RequestBody Client client) {
        clientService.saveClient(client);
        return "Client created";
    }


}
