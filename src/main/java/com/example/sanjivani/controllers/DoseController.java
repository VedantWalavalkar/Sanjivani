package com.example.sanjivani.controllers;

import com.example.sanjivani.DTO.RequestDTO.BookDose1RequestDTO;
import com.example.sanjivani.DTO.ResponseDTO.BookDose1Response;
import com.example.sanjivani.enums.DoseName;
import com.example.sanjivani.model.Dose;
import com.example.sanjivani.services.DoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dose")
public class DoseController {


    @Autowired
    DoseService doseService;

//    @PostMapping("/bookdose1")
//    public ResponseEntity bookDose1(@RequestParam int personId,@RequestParam DoseName doseName){
//        try{
//            Dose dose = doseService.bookDose1(personId, doseName);
//            return new ResponseEntity(dose, HttpStatus.ACCEPTED);
//        }
//        catch (Exception e){
//            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//    }

    @PostMapping("/bookdose1")
    public ResponseEntity bookDose1(@RequestBody BookDose1RequestDTO bookDose1RequestDTO){
        try{
            BookDose1Response bookDose1Response = doseService.bookDose1(bookDose1RequestDTO);
            return new ResponseEntity(bookDose1Response, HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}