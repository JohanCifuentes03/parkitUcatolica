package com.example.springbootbackendapirest.models.repository;

import com.example.springbootbackendapirest.models.entity.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ParkingRepository extends JpaRepository<Parking, Long> {
    @Query("SELECT p FROM Parking p")
    List<Parking> findAllParking();
}
