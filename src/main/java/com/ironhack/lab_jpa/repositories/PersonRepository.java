package com.ironhack.lab_jpa.repositories;

import com.ironhack.lab_jpa.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    // Custom query methods can be defined here if needed

}
