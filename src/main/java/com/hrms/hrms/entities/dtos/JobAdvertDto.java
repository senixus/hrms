package com.hrms.hrms.entities.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class JobAdvertDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int id;

    private String jobDetails;

    private String jobTitleTitle;

    private LocalDate createdAt;

    private LocalDate lastApplyDate;

    private int numberOfOpenPosition;

    private int minSalary;

    private int maxSalary;

    private boolean isActive;

    private boolean isConfirm;

    private String cityCityName;

    private String employerCompanyName;

    private String employerWebsite;

    private String workTimeDescription;

    private String workPlaceDescription;
}
