package com.hrms.hrms.business.abstracts;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.JobAdvert;
import com.hrms.hrms.entities.dtos.JobAdvertAddDto;
import com.hrms.hrms.entities.dtos.JobAdvertDto;


import java.util.List;

public interface JobAdvertService {

    DataResult<List<JobAdvertDto>> getByIsActiveTrue();

    Result add(JobAdvertAddDto jobAdvertAddDto);

    DataResult<List<JobAdvertDto>> getByIsActiveTrueAndEmployerId(int employerId);

    DataResult<List<JobAdvertDto>> getAllByCreatedAt();

    Result update(int id,boolean isActive);


}
