package com.hrms.hrms.entities.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class EducationDto {

   // @JsonIgnore
    private int id;

    private int resumeId;

    @JsonProperty(access = Access.WRITE_ONLY)
    private int graduateId;

    private String graduateDescription;

    private String schoolName;

    private String schoolDepartment;

    private LocalDate startedAt;

    private LocalDate graduateAt;

    private LocalDate createdAt;


}
