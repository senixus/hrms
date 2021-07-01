package com.hrms.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "employer_updates")
public class EmployerUpdate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "employer_id")
    private int employerId;

    @Column(name = "employee_id")
    private int employeeId;

    @NotBlank(message = "Company name cannot be empty")
    @Column(name = "company_name")
    private String companyName;

    @NotBlank(message = "Web address cannot be empty")
    @Column(name = "web_address")
    private String website;

    @NotBlank(message = "Phone number cannot be empty")
    @Column(name = "phone_number")
    private String phoneNumber;

    @Email(message = "Provide a valid email")
    @NotBlank(message = "Email cannot be empty")
    @Column(name = "email")
    private String email;

    @Column(name = "is_confirm")
    private boolean isConfirm;

    @Column(name = "created_at")
    private LocalDate createdAt = LocalDate.now();

    @Column(name = "confirmed_at")
    private LocalDate confirmedAt;


}
