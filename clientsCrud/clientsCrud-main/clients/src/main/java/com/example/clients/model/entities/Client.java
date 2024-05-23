package com.example.clients.model.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Client {

    public Client() {
        this.id = UUID.randomUUID();
    }
    private UUID id;
    private String name;
    private Long cpf;
    private String email;
    private String address;
    private String district;
    private Long cep;
    private String city;

    public Client(UUID id, String name, Long cpf, String email, String address, String district, Long cep, String city) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.address = address;
        this.district = district;
        this.cep = cep;
        this.city = city;
    }

    public void setId(UUID id) {
    }

    public UUID getId(UUID id) {
        return id;
    }
}
