package com.example.sanjivani.services;

import com.example.sanjivani.DTO.RequestDTO.BookDose1RequestDTO;
import com.example.sanjivani.DTO.ResponseDTO.BookDose1Response;
import com.example.sanjivani.enums.DoseName;
import com.example.sanjivani.exception.dose1AlreadyTakenException;
import com.example.sanjivani.exception.personNotFound;
import com.example.sanjivani.model.Dose;
import com.example.sanjivani.model.Person;
import com.example.sanjivani.repository.DoseRepository;
import com.example.sanjivani.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DoseService {
    @Autowired
    PersonRepository personRepository;
//    public Dose bookDose1(int personId, DoseName doseName) {
//        Optional<Person> optionalPerson = personRepository.findById(personId);
//        // check if the person exists?
//
//        if(optionalPerson.isEmpty()){
//            throw new personNotFound("Invalid personId");
//        }
//
//        // check if dose 1 already taken
//        Person person = optionalPerson.get();
//        if(person.isDose1Taken()){
//            throw new dose1AlreadyTakenException("Dose 1 already taken");
//        }
//
//        // give dose to person
//        Dose dose = new Dose();
//        dose.setDoseName(doseName);
//        dose.setPerson(person);
//        dose.setDoseId(String.valueOf(UUID.randomUUID()));
//
//        person.setDose1Taken(true);
//        person.getDoseList().add(dose);
//        Person savedPerson = personRepository.save(person);
//        return savedPerson.getDoseList().get(0);
//    }
public BookDose1Response bookDose1(BookDose1RequestDTO bookDose1RequestDTO) {
    Optional<Person> optionalPerson = personRepository.findById(bookDose1RequestDTO.getId());
    // check if the person exists?

    if(optionalPerson.isEmpty()){
        throw new personNotFound("Invalid personId");
    }

    // check if dose 1 already taken
    Person person = optionalPerson.get();
    if(person.isDose1Taken()){
        throw new dose1AlreadyTakenException("Dose 1 already taken");
    }

    // give dose to person
    Dose dose = new Dose();
    dose.setDoseName(bookDose1RequestDTO.getDoseName());
    dose.setPerson(person);
    dose.setDoseId(String.valueOf(UUID.randomUUID()));

    person.setDose1Taken(true);
    person.getDoseList().add(dose);
    Person savedPerson = personRepository.save(person);

    BookDose1Response bookDose1Response = new BookDose1Response();
    bookDose1Response.setName(savedPerson.getName());
    bookDose1Response.setDoseName(dose.getDoseName());
    bookDose1Response.setEmailId(savedPerson.getEmailId());

    return bookDose1Response;
}
}
