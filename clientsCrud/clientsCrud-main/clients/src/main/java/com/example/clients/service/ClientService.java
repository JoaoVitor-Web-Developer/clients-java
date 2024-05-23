package com.example.clients.service;

import com.example.clients.model.entities.Client;
import com.example.clients.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> listAll() {
        return clientRepository.findAll();
    }

    public Client findById(UUID id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.orElse(null);
    }

    public List<Client> findByName(String name) {
        return clientRepository.findByNameContaining(name);
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public Client update(UUID id, Client client) throws Exception {
        Optional<Client> existingClient = clientRepository.findById(id);
        if (existingClient.isEmpty()) {
            throw new Exception("Cliente não encontrado");
        }
        client.setId(existingClient.get().getId(id));
        return clientRepository.save(client);
    }



    public void delete(UUID id) throws Exception {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
        } else {
            throw new Exception("Client não encontrado");
        }
    }
}
