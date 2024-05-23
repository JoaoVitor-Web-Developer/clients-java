package com.example.clients.controllers;

import com.example.clients.model.entities.Client;
import com.example.clients.service.ClientService;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping()
    public ResponseEntity<List<Client>> listAll() {
        return ResponseEntity.ok(clientService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable UUID id) {
        Client client = clientService.findById(id);
        return client != null ? ResponseEntity.ok(client) : ResponseEntity.notFound().build();
    }

    @GetMapping("/find")
    public ResponseEntity<List<Client>> findByName(@RequestParam String name) {
        return ResponseEntity.ok(clientService.findByName(name));
    }

    @PostMapping
    public ResponseEntity<Client> save(@RequestBody Client client) {
        System.out.println("JSON Recebido: " + new Gson().toJson(client));
        return new ResponseEntity<>(clientService.save(client), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@PathVariable UUID id, @RequestBody Client client) {
        try {
            return ResponseEntity.ok(clientService.update(id, client));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        try {
            clientService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
