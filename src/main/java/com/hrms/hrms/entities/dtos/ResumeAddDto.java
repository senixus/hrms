package com.hrms.hrms.entities.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ResumeAddDto {

    @JsonProperty(access = Access.READ_ONLY)
    private int id;

    private  int candidateId;

    private String github;

    private String linkedin;

    private String photo;

    private String description;

    private LocalDate updatedAt;

    private LocalDate createdAt;

}
