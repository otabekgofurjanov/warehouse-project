package com.example.warehouseproject.repository;

import com.example.warehouseproject.domain.Output;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OutputRepository extends JpaRepository<Output, Long> {

    @Query("select o from Output o where o.id =:id")
    Output findOutputById(@Param("id") Long id);
}
