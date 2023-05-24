package com.example.springbootbackendapirest.models.repository;

import com.example.springbootbackendapirest.models.entity.ParkinOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkinOwnerRepository extends JpaRepository<ParkinOwner, Long> {
}
