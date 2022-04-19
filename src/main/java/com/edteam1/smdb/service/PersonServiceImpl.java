package com.edteam1.smdb.service;

import com.edteam1.smdb.domain.Occupation;
import com.edteam1.smdb.domain.Person;
import com.edteam1.smdb.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PersonServiceImpl extends BaseServiceImpl<Person> implements PersonService{

    private final PersonRepository personRepository;

    @Override
    public JpaRepository<Person, Long> getRepository() {
        return personRepository;
    }

    @Override
    public List<Person> findByOccupation(Occupation occupation) {
        return null;
    }

    @Override
    public List<Person> findByName(String name) {
        return null;
    }

    @Override
    public List<Person> findByAge(String age) {
        return null;
    }
}
