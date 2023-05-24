package com.example.springbootbackendapirest.models.controller;


import com.example.springbootbackendapirest.models.entity.Client;
import com.example.springbootbackendapirest.models.repository.ClientRepository;
import com.example.springbootbackendapirest.models.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ClientController {

    // Attributes
    private final ClientService    clientService;
    private final ClientRepository clientRepository;


    // Constructor
    public ClientController(ClientService clientService, ClientRepository clientRepository) {
        this.clientService = clientService;
        this.clientRepository = clientRepository;
    }

    // Methods
    // CRUD
    // Search all clients
    @GetMapping("/clients")
    public List<Client> findAllClients (){
        return clientService.findAllClients();
    }

    // Search By id
    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id){
        Optional<Client> clienteOptional = clientRepository.findById(id);
        if (clienteOptional.isPresent()){
            return ResponseEntity.ok(clienteOptional.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create Client
    @PostMapping("/clients")
    public Client createClient(@RequestBody Client cliente){
        clientRepository.save(cliente);
        return cliente;
    }

    // Update Client
    @PutMapping("/clients/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client cliente) {
        Optional<Client> clienteOptional = clientRepository.findById(id);
        if (clienteOptional.isPresent()) {
            Client existingCliente = clienteOptional.get();
            existingCliente.setNombre(cliente.getNombre());
            existingCliente.setApellido(cliente.getApellido());
            existingCliente.setCorreoElectronico(cliente.getCorreoElectronico());
            existingCliente.setTelefono(cliente.getTelefono());
            existingCliente.setDireccion(cliente.getDireccion());
            existingCliente.setContrasenia(cliente.getContrasenia());

            Client updatedClient = clientRepository.save(existingCliente);
            return ResponseEntity.ok(updatedClient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    // Delete By id
    @DeleteMapping("/clients/{id}")
    public ResponseEntity<Client> deleteClientById (@PathVariable Long id){
        clientRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}

