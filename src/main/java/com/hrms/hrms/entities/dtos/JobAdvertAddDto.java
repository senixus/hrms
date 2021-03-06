package com.hrms.hrms.entities.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertAddDto {

   // @JsonIgnore
    private int id;

    private int employerId;

    private int jobTitleId;

    private int cityId;

    private int workTimeId;

    private int workPlaceId;

    private String jobDetails;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private boolean isConfirm = false;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private boolean isActive = false;

    private int minSalary;

    private  int maxSalary;

    private int numberOfOpenPosition;

    private LocalDate lastApplyDate;


}
