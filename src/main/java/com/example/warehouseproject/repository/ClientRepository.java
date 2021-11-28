package com.example.warehouseproject.repository;

import com.example.warehouseproject.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("select c from Client c where c.id =:id")
    Client findClientById(@Param("id")Long id);
}
