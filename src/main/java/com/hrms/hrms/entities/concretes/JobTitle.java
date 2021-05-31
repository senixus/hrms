package com.hrms.hrms.entities.concretes;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "job_titles")
@JsonIgnoreProperties({"hibernateLazyInitializer","handle","jobAdverts"})
public class JobTitle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "Job title cannot be empty")
    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "jobTitle")
    private List<JobAdvert> jobAdverts;

}
