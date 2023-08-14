package com.example.sanjivani.controllers;

import com.example.sanjivani.DTO.RequestDTO.AddVacinationCenterRequest;
import com.example.sanjivani.DTO.ResponseDTO.AddVacinationCenterResponse;
import com.example.sanjivani.services.VacinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vacination_center")
public class VacinationCenterController {
    @Autowired
    VacinationCenterService vacinationCenterService;
    @PostMapping("/add")
    public ResponseEntity addVacinationCenter(@RequestBody AddVacinationCenterRequest addVacinationCenterRequest){
            AddVacinationCenterResponse vacinationCenterResponse = vacinationCenterService.addVacinationCenter(addVacinationCenterRequest);
            return new ResponseEntity(vacinationCenterResponse, HttpStatus.CREATED);
    }
}
