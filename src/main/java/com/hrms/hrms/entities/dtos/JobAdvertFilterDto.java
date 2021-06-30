package com.hrms.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class JobAdvertFilterDto {
    private int id;
    private List<Integer> jobTitleId;
    private List<Integer> cityId;
    private List<Integer> workPlaceId;
    private List<Integer> workTimeId;
}
