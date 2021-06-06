package com.hrms.hrms.entities.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class JobAdvertDto {

    private String jobDetails;

    private String jobTitleTitle;

    private LocalDate createdAt;

    private LocalDate lastApplyDate;

    private int numberOfOpenPosition;

    private String employerCompanyName;
}
