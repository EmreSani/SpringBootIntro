package com.tpe.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "first name can not be null")
    @Column(nullable = false, length = 25)
    private String name;

    private String lastName;
    private Integer grade;
    private String email;
    private String phoneNumber;
    private LocalDateTime createDate = LocalDateTime.now();






}
