package com.example.restapi.demorestapi.controller;

import com.example.restapi.demorestapi.model.Client;
import com.example.restapi.demorestapi.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    public List<Client> getClients() {
        return clientService.getClients();
    }

    @GetMapping("/clients/{id}")
    public Client getClient(@PathVariable Long id) {
        return clientService.getClient(id);
    }

    @PostMapping("/clients")
    public ResponseEntity createClient(@RequestBody Client client) throws URISyntaxException {
        Client savedClient = clientService.createClient(client);
        return ResponseEntity.created(new URI("/clients/" + savedClient.getId())).body(savedClient);
    }
//    Tried to create a create-multiple method
//    @PostMapping("/create-clients")
//    public ResponseEntity createMultipleClients(@RequestBody List<Client> clients) throws URISyntaxException {
//        List<Client> savedClients = clientService.createMultipleClients(clients);
//        return ResponseEntity.created(new URI("/clients/")).body(savedClients);
//    }

    @PutMapping("/clients/{id}")
    public ResponseEntity updateClient(@PathVariable Long id, @RequestBody Client client) {
        Client currentClient = clientService.updateClient(id, client);

        return ResponseEntity.ok(currentClient);
    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.ok().build();
    }
}
