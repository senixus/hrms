package com.hrms.hrms.business.abstracts;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.dtos.JobAdvertAddDto;
import com.hrms.hrms.entities.dtos.JobAdvertDto;


import java.util.List;

public interface JobAdvertService {

    DataResult<List<JobAdvertDto>> getByIsActiveTrue();

    Result add(JobAdvertAddDto jobAdvertAddDto);

    DataResult<List<JobAdvertDto>>  getByIsConfirmTrueAndWorkTimeIdAndWorkPlaceIdAndCityId(int pageNo, int pageSize,  int workTimeId,int workPlaceId,int cityId);

    DataResult<List<JobAdvertDto>> getByIsActiveTrueAndEmployerId(int employerId,int pageNo,int pageSize);

    DataResult<List<JobAdvertDto>> getByIsActiveTrueOrderByCreatedAtDesc(int pageNo,int pageSize);

    DataResult<List<JobAdvertDto>> getByIsActiveFalseAndEmployerId(int employerId,int pageNo, int pageSize);

    DataResult<List<JobAdvertDto>> getJobAdvertById(int id);

    DataResult<List<JobAdvertDto>> getByIsConfirmTrueAndEmployerId(int employerId);

    DataResult<List<JobAdvertDto>> getByIsConfirmTrueAndIsActiveTrueAndEmployerId(int employerId,int pageNo, int pageSize);

    Result update(int id,boolean isActive);

    Result confirmJobAdvert(int id);

    DataResult<List<JobAdvertDto>> getByIsConfirmFalseAndIsActiveTrue(int pageNo, int pageSize);

    DataResult<List<JobAdvertDto>> getByIsConfirmFalseAndIsActiveTrueAndEmployerId(int employerId,int pageNo, int pageSize);

}
