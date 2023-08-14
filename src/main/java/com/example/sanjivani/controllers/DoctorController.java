package com.example.sanjivani.controllers;

import com.example.sanjivani.DTO.RequestDTO.AddDoctorRequest;
import com.example.sanjivani.DTO.ResponseDTO.AddDoctorResponse;
import com.example.sanjivani.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @PostMapping("/add_doctor")
    public ResponseEntity addDoctor(@RequestBody AddDoctorRequest addDoctorRequest){
        try{
            AddDoctorResponse addDoctorResponse = doctorService.addDoctor(addDoctorRequest);
            return new ResponseEntity(addDoctorResponse, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
