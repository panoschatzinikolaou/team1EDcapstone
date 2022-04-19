package com.edteam1.smdb.repository;

import com.edteam1.smdb.domain.Production;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductionRepository extends JpaRepository<Production,Long> {
    @Query("select p from Production p join fetch p.persons where p.id = ?1")
    Optional<Production> getLazy(Long id);

    @Query("select p from Production p join fetch p.persons")
    List<Production> findAllLazy();
}
