package com.example.clients.repository;

import com.example.clients.model.entities.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ClientRepository extends MongoRepository<Client, UUID> {
    List<Client> findByNameContaining(String name);
}
