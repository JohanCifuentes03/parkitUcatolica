package com.example.springbootbackendapirest.models.repository;

import com.example.springbootbackendapirest.models.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {}
