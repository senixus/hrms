package com.hrms.hrms.core.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Email(message = "Email is not valid")
    @NotBlank(message = "Email cannot be empty")
    @Column(name = "email_address")
    private String email;

    @Size(min = 6, message = "Password minimum length must be 6 characters")
    @NotBlank(message = "Password cannot be empty")
    @Column(name = "password")
    private String password;

    @NotBlank(message = "Confirm password cannot be empty")
    @Transient
    private String confirmPassword;

    @JsonIgnore
    @Column(name = "is_confirmed")
    private boolean isConfirmed = false;
}
