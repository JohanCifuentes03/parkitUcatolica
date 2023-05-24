package com.example.springbootbackendapirest.models.controller;

import com.example.springbootbackendapirest.models.entity.Parking;
import com.example.springbootbackendapirest.models.repository.ParkingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/api/parkings")
public class ParkingController {

    private final ParkingRepository parkingRepository;

    public ParkingController(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    @GetMapping("")
    public List<Parking> getAllParqueaderos() {
        return parkingRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Parking> getParkingById(@PathVariable Long id) {
        Parking parking = parkingRepository.findById(id).orElse(null);
        if (parking != null) {
            return new ResponseEntity<>(parking, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Parking> createParking(@RequestBody Parking parking) {
        Parking savedParking = parkingRepository.save(parking);
        return new ResponseEntity<>(savedParking, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Parking> updateParking(@PathVariable Long id, @RequestBody Parking parkingDetails) {
        Parking parking = parkingRepository.findById(id).orElse(null);
        if (parking != null) {
            parking.setNombre(parkingDetails.getNombre());
            parking.setDireccion(parkingDetails.getDireccion());
            parking.setTelefono(parkingDetails.getTelefono());
            parking.setCorreoElectronico(parkingDetails.getCorreoElectronico());
            parking.setCuposTotales(parkingDetails.getCuposTotales());
            parking.setIdDueno(parkingDetails.getIdDueno());
            parking.setIdLocalidad(parkingDetails.getIdLocalidad());
            parking.setPrecioMinuto(parkingDetails.getPrecioMinuto());

            Parking updatedParking = parkingRepository.save(parking);
            return new ResponseEntity<>(updatedParking, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParking(@PathVariable Long id) {
        Parking parking = parkingRepository.findById(id).orElse(null);
        if (parking != null) {
            parkingRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
