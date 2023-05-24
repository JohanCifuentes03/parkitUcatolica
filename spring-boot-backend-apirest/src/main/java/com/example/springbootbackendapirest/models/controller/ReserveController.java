package com.example.springbootbackendapirest.models.controller;


import com.example.springbootbackendapirest.models.entity.Reserve;
import com.example.springbootbackendapirest.models.repository.ReserveRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ReserveController {
    private final ReserveRepository reserveRepository;

    public ReserveController(ReserveRepository reserveRepository) {
        this.reserveRepository = reserveRepository;
    }

    @GetMapping("/reserves")
    public List<Reserve> getAllReserves() {
        return reserveRepository.findAll();
    }
}
