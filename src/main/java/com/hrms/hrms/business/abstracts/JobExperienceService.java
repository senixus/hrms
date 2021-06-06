package com.hrms.hrms.business.abstracts;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Graduate;
import com.hrms.hrms.entities.concretes.JobExperience;
import com.hrms.hrms.entities.dtos.JobExperienceDto;

import java.util.List;

public interface JobExperienceService {

    Result add(JobExperienceDto jobExperience);

    DataResult<List<JobExperienceDto>> getAll();

    DataResult<List<JobExperienceDto>> getAllByResumeIdOrderByStartedAtDesc(int id);
}
