package com.edteam1.smdb.repository;

import com.edteam1.smdb.domain.Occupation;
import com.edteam1.smdb.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person,Long> {

    @Query("select p from Person p join fetch p.productions where p.id = ?1")
    Optional<Person> getLazy(Long id);

    @Query("select p from Person p join fetch p.productions")
    List<Person> findAllLazy();

    List<Person> findAllByName(String name);

    List<Person> findAllByOccupation(Occupation occupation);

    List<Person> findAllByAge(String age);
}
