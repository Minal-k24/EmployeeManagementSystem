package com.example.EmployeeManagemantSystem.model;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "Department")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private String name;


}
