package com.example.sanjivani.DTO.RequestDTO;

import com.example.sanjivani.enums.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddPersonRequest {
    String name;

    int age;

    String emailId;

    Gender gender;
}
