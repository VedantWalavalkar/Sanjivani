package com.example.sanjivani.model;

import com.example.sanjivani.enums.CenterType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VacinationCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    String address;

    @Enumerated(EnumType.STRING)
    CenterType centerType;

    @OneToMany(mappedBy = "vacinationCenter",cascade = CascadeType.ALL)
    List<Doctor> doctorList = new ArrayList<>();
}