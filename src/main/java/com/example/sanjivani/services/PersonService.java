package com.example.sanjivani.services;

import com.example.sanjivani.DTO.RequestDTO.AddPersonRequest;
import com.example.sanjivani.DTO.ResponseDTO.AddPersonResponse;
import com.example.sanjivani.DTO.ResponseDTO.GetPersonListAboveAgeResponse;
import com.example.sanjivani.exception.personNotFound;
import com.example.sanjivani.model.Person;
import com.example.sanjivani.repository.PersonRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

//    public Person addPerson(Person person) {
//        return personRepository.save(person);
//    }

    public AddPersonResponse addPerson(AddPersonRequest addPersonRequest){
        Person person = new Person();
        person.setName(addPersonRequest.getName());
        person.setAge(addPersonRequest.getAge());
        person.setEmailId(addPersonRequest.getEmailId());
        person.setGender(addPersonRequest.getGender());

        Person savedPerson = personRepository.save(person);

        AddPersonResponse response = new AddPersonResponse();
        response.setId(savedPerson.getId());
        response.setName(savedPerson.getName());
        response.setEmailId(savedPerson.getEmailId());
        response.setMessage("Great!! Details added successfully.");

        return response;
    }

    public void updateEmail(String oldEmailId, String newEmailId) {
        Person person = personRepository.findByEmailId(oldEmailId);
        if(person == null)
            throw new personNotFound("Invaild Email!");
        person.setEmailId(newEmailId);
        personRepository.save(person);
    }

    public List<Person> getPersonAbove(int age) {
        List<Person> personList = personRepository.findPersonAboveAge(age);
        return personList;
    }
//    public GetPersonListAboveAgeResponse getPersonAbove(int age) {
//        List<Person> personList = personRepository.findPersonAboveAge(age);
//        System.out.println(personList);
//        GetPersonListAboveAgeResponse response = new GetPersonListAboveAgeResponse();
//        for(Person person : personList)
//            response.getPersonList().add(person);
//
//        return response;
//    }
}
