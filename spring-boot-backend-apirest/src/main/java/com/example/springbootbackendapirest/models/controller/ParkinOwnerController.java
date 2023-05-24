package com.example.springbootbackendapirest.models.controller;

import com.example.springbootbackendapirest.models.entity.ParkinOwner;
import com.example.springbootbackendapirest.models.repository.ParkinOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ParkinOwnerController {


    private final ParkinOwnerRepository parkinOwnerRepository;

    private ParkinOwnerController(ParkinOwnerRepository parkinOwnerRepository){
        this.parkinOwnerRepository = parkinOwnerRepository;
    }

    @GetMapping("/parkin-owners")
    public List<ParkinOwner> getAllParkinOwners() {
        return parkinOwnerRepository.findAll();
    }

    @GetMapping("/parkin-owners/{id}")
    public ParkinOwner getParkinOwnerById(@PathVariable Long id) {
        return parkinOwnerRepository.findById(id).orElse(null);
    }

    @PostMapping("/parkin-owners")
    public ParkinOwner createParkinOwner(@RequestBody ParkinOwner parkinOwner) {
        return parkinOwnerRepository.save(parkinOwner);
    }

    @PutMapping("/parkin-owners/{id}")
    public ParkinOwner updateParkinOwner(@PathVariable Long id, @RequestBody ParkinOwner parkinOwner) {
        ParkinOwner existingOwner = parkinOwnerRepository.findById(id).orElse(null);
        if (existingOwner != null) {
            existingOwner.setNombre(parkinOwner.getNombre());
            existingOwner.setApellido(parkinOwner.getApellido());
            existingOwner.setContrasena(parkinOwner.getContrasena());
            return parkinOwnerRepository.save(existingOwner);
        }
        return null;
    }

    @DeleteMapping("/parkin-owners/{id}")
    public void deleteParkinOwner(@PathVariable Long id) {
        parkinOwnerRepository.deleteById(id);
    }
}
