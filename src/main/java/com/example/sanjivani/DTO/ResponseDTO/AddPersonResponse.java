package com.example.sanjivani.DTO.ResponseDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddPersonResponse {
    int id;

    String name;

    String emailId;

    String message;
}
