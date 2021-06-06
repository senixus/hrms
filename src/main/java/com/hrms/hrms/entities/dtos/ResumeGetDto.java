package com.hrms.hrms.entities.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.hrms.hrms.entities.concretes.Education;
import com.hrms.hrms.entities.concretes.JobExperience;
import com.hrms.hrms.entities.concretes.Language;
import com.hrms.hrms.entities.concretes.Technology;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ResumeGetDto {

    @JsonProperty(access =Access.READ_ONLY)
    private int id;

    private int candidateId;

    private String github;

    private String linkedin;

    private String photo;

    private String description;

    private LocalDate createdAt;

    private  LocalDate updatedAt;

    private List<JobExperience> jobExperiences;

    private List<Language> languages;

    private List<Technology> technologies;

    private List<Education> educations;


}
