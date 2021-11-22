package com.example.warehouseproject.repository;

import com.example.warehouseproject.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByClientId(@Param("id") Long id);

}
