package com.example.sanjivani.DTO.RequestDTO;

import com.example.sanjivani.enums.DoseName;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookDose1RequestDTO {
    int id;

    DoseName doseName;
}
