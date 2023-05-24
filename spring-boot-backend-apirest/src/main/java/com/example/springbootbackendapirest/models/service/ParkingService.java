package com.example.springbootbackendapirest.models.service;


import com.example.springbootbackendapirest.models.entity.Parking;
import com.example.springbootbackendapirest.models.repository.ParkingRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ParkingService {
    private final ParkingRepository parkingRepository;

    public ParkingService(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }


    public List<Parking> findAll (){
        return parkingRepository.findAll();
    }

}
