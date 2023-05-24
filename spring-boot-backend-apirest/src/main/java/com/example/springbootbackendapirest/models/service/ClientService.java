package com.example.springbootbackendapirest.models.service;

import com.example.springbootbackendapirest.models.entity.Client;
import com.example.springbootbackendapirest.models.repository.ClientRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    // Find All
    public List<Client>  findAllClients (){
        return clientRepository.findAll();
    }

    // Find by id
    public Client findById(Long id){
        return clientRepository.findById(id).orElse(null);
    }

}

