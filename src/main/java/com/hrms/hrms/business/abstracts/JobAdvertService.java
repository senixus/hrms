package com.hrms.hrms.business.abstracts;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.JobAdvert;


import java.util.List;

public interface JobAdvertService {

    DataResult<List<JobAdvert>> getByIsActiveTrue();

    Result add(JobAdvert jobAdvert);

    DataResult<List<JobAdvert>> getByIsActiveTrueAndEmployerId(int employerId);

    DataResult<List<JobAdvert>> getAllByCreatedAt();

    Result update(int id,boolean isActive);


}
