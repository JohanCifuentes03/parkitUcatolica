package com.example.springbootbackendapirest.models.service;

import com.example.springbootbackendapirest.models.repository.ParkinOwnerRepository;
import org.springframework.stereotype.Service;

@Service
public class ParkinOwnerService {
    ParkinOwnerRepository parkinOwnerRepository;

    public ParkinOwnerService(ParkinOwnerRepository parkinOwnerRepository) {
        this.parkinOwnerRepository = parkinOwnerRepository;
    }
}
