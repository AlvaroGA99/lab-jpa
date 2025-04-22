package com.ironhack.lab_jpa.repositories;

import com.ironhack.lab_jpa.models.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void testSave() {
        // Implement the test logic here
        Person person = new Person("John Doe", 30);
        personRepository.save(person);

        Optional<Person> foundPerson = personRepository.findById(person.getId());
        assertNotNull(foundPerson);
        System.out.println("Found person: " + foundPerson);
        assertNotNull(foundPerson.get().getId());
        assertEquals("John Doe", foundPerson.get().getName());
        assertEquals(30, foundPerson.get().getAge());

    }

    @Test
    public void testFindAll() {
        // Implement the test logic here
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("Ditto", 10));
        people.add(new Person("John", 20));
        people.add(new Person("Pepe", 10));
        personRepository.saveAll(people);

        List<Person> all = personRepository.findAll();
        System.out.println("All people: " + all);
        assertNotNull(all);
        assertEquals(3, all.size());
        assertEquals("Ditto", all.get(0).getName());
        assertEquals(30, all.get(0).getAge());


    }

    @Test
    public void testDelete() {
        Person person = new Person("John Doe", 30);
        personRepository.save(person);
        Optional<Person> foundPerson = personRepository.findById(person.getId());
        assertNotNull(foundPerson);
        personRepository.delete(person);
        Optional<Person> notfoundPerson = personRepository.findById(person.getId());
        assertTrue(notfoundPerson.isEmpty());

        System.out.println("Found person: " + foundPerson);


    }

    @Test
    public void testUpdate() {
        // Implement the test logic here
        Person person = new Person("John Doe", 15);
        personRepository.save(person);
        Optional<Person> foundPerson = personRepository.findById(person.getId());
        assertNotNull(foundPerson);
        person.setName("Nuevo nombre");
        person.setAge(30);
        personRepository.save(person);
        Optional<Person> foundPerson2 = personRepository.findById(person.getId());
        assertNotNull(foundPerson2);
        System.out.println("Found person: " + foundPerson2);
        assertNotNull(foundPerson2.get().getId());
        assertEquals("Nuevo nombre", foundPerson2.get().getName());
        assertEquals(30, foundPerson2.get().getAge());

    }
}
