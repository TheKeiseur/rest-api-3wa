package com.example.restapi.demorestapi.service;

import com.example.restapi.demorestapi.model.Client;
import com.example.restapi.demorestapi.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public Client getClient( Long id) {
        return clientRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> createMultipleClients(List<Client> clients) {
        return clientRepository.saveAll(clients);
    }

    public Client updateClient(Long id, Client client) {
        Client currentClient = getClient(id);
        currentClient.setName(client.getName());
        currentClient.setEmail(client.getEmail());
        currentClient = clientRepository.save(client);
        return currentClient;
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
