package com.hrms.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ResumeDto {

    private int id;

    private  int candidateId;

    private String github;

    private String linkedin;

    private String photo;

    private String description;

    private LocalDate updatedAt;
}
