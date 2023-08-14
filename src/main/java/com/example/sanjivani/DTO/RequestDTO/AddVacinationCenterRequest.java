package com.example.sanjivani.DTO.RequestDTO;

import com.example.sanjivani.enums.CenterType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddVacinationCenterRequest {

    String name;

    String address;

    CenterType centerType;
}
