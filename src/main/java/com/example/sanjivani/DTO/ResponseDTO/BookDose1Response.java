package com.example.sanjivani.DTO.ResponseDTO;

import com.example.sanjivani.enums.DoseName;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookDose1Response
{
    String name;

    String emailId;

    DoseName doseName;

}
