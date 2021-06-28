package com.hrms.hrms.business.abstracts;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Education;
import com.hrms.hrms.entities.dtos.EducationDto;

import java.util.List;

public interface EducationService {

    Result add(EducationDto educationDto);

    DataResult<List<EducationDto>> getAll();

    DataResult<List<EducationDto>> getAllByResumeIdOrderByStartedAtDesc(int id);

    DataResult<Education> findById(int id);

    Result update(EducationDto educationDto);

}
