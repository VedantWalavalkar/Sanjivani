package com.example.sanjivani.controllers;

import com.example.sanjivani.DTO.RequestDTO.AddPersonRequest;
import com.example.sanjivani.DTO.ResponseDTO.AddPersonResponse;
import com.example.sanjivani.DTO.ResponseDTO.GetPersonListAboveAgeResponse;
import com.example.sanjivani.model.Person;
import com.example.sanjivani.services.PersonService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

//    @PostMapping("/add")
//    public ResponseEntity addPerson(@RequestBody Person person){
//        Person response = personService.addPerson(person);
//        return new ResponseEntity(response, HttpStatus.CREATED);
//    }

    @PostMapping("/add")
    public ResponseEntity addPerson(@RequestBody AddPersonRequest addPersonRequest){
        AddPersonResponse response = personService.addPerson(addPersonRequest);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }
    @PutMapping("/update_email")
    public ResponseEntity updateEmail(@RequestParam("old") String oldEmailId, @RequestParam("new") String newEmailId){
        try{
            personService.updateEmail(oldEmailId, newEmailId);
            return new ResponseEntity("Email Changed Successfully!",HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/above_given_age")
    public ResponseEntity getPersonAbove(@RequestParam int age){
        List<Person> response = personService.getPersonAbove(age);
        if(response.size() == 0)
            return new ResponseEntity("No Person Above age ",HttpStatus.NOT_FOUND);
        return new ResponseEntity(response,HttpStatus.OK);
    }
//    @GetMapping("/above_given_age")
//    public ResponseEntity getPersonAbove(@RequestParam int age){
//        GetPersonListAboveAgeResponse response = personService.getPersonAbove(age);
//        if(response.getPersonList().size() == 0)
//            return new ResponseEntity("No Person Above age ",HttpStatus.NOT_FOUND);
//        return new ResponseEntity(response,HttpStatus.OK);
//    }
}
