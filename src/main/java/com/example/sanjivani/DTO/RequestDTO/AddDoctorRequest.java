package com.example.sanjivani.DTO.RequestDTO;

import com.example.sanjivani.enums.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddDoctorRequest {
    String name;

    int age;

    String emailId;

    Gender gender;

    int vacinationCenterId;
}
