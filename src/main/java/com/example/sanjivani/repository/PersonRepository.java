package com.example.sanjivani.repository;

import com.example.sanjivani.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
//    @Query(value = "select * from person where email_id = :oldEmail", nativeQuery = true)
//    public Person getPersonByEmail(String oldEmail);

    Person findByEmailId(String oldEmail);

    @Query(value = "select * from person where age > :age", nativeQuery = true)
    List<Person> findPersonAboveAge(int age);
}
