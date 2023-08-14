package com.example.sanjivani.model;

import com.example.sanjivani.enums.DoseName;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Dose {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int id;

    String doseId; // Unique doseId

    @Enumerated(value = EnumType.STRING)
    DoseName doseName;

    @CreationTimestamp
    Date vacinationDate;

    @ManyToOne
    @JoinColumn
    Person person;
}
