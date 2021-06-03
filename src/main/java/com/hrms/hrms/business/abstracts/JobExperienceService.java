package com.hrms.hrms.business.abstracts;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Graduate;
import com.hrms.hrms.entities.concretes.JobExperience;

import java.util.List;

public interface JobExperienceService {

    Result add(JobExperience jobExperience);

    DataResult<List<JobExperience>> getAll();
}
