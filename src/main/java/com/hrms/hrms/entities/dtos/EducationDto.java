package com.hrms.hrms.entities.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class EducationDto {

    @JsonIgnore
    private int id;

    private int resumeId;

    private String schoolName;

    private int graduateId;

    private String schoolDepartment;

    private LocalDate startedAt;

    private LocalDate graduateAt;



}
