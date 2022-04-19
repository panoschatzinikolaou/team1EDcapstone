package com.edteam1.smdb.service;

import com.edteam1.smdb.domain.Occupation;
import com.edteam1.smdb.domain.Person;

import java.util.List;

public interface PersonService extends BaseService<Person,Long>{

    List<Person> findByOccupation(Occupation occupation);

    List<Person> findByName(String name);

    List<Person> findByAge(String age);
}
