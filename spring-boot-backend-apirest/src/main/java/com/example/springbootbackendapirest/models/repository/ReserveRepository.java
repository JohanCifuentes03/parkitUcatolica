package com.example.springbootbackendapirest.models.repository;

import com.example.springbootbackendapirest.models.entity.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReserveRepository extends JpaRepository<Reserve, Long> {
}
