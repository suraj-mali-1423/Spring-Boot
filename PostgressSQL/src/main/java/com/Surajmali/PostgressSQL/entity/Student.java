package com.Surajmali.PostgressSQL.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data   // Generates Getter, Setter, toString, equals, hashCode
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rollNumber;

    @Column(unique = true, length = 50, nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private Long mobilenumbe;

    @Column(unique = false, nullable = false)
    private String gender;

}
