package com.hrms.hrms.entities.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class JobExperienceDto {

    @JsonIgnore
    private int id;

    private int resumeId;

    private String companyName;

    private int jobTitleId;

    //@Past
    private LocalDate startedAt;

    private LocalDate endedAt;

}
