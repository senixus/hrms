package com.hrms.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor


@Entity
@Table(name="job_adverts")
public class JobAdvert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "Job detail cannot be empty")
    @Column(name="job_details")
    private String jobDetails;

    @Column(name = "min_salary")
    private int minSalary;

    @Column(name="max_salary")
    private int maxSalary;

    @NotBlank(message = "Number of open position cannot be empty")
    @Column(name = "number_of_open_position")
    private int numberOfOpenPosition;

    @Column(name = "last_apply_date")
    private LocalDate lastApplyDate;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "is_active")
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "job_title_id")
    private JobTitle jobTitle;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;


}
