package com.hrms.hrms.entities.concretes;


import com.hrms.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "candidates")
public class Candidate extends User {

    @NotBlank(message = "First name cannot be empty")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Last name cannot be empty")
    @Column(name = "last_name")
    private String lastName;

    @NotBlank(message = "National identity cannot be empty")
    @Column(name = "national_identity")
    private String nationalIdentity;

    @Column(name = "birth_date")
    private LocalDate birthDate;

}
