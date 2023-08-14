package com.example.sanjivani.DTO.ResponseDTO;

import com.example.sanjivani.model.Person;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetPersonListAboveAgeResponse {
    List<Person> personList;
}
