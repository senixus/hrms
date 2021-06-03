package com.hrms.hrms.business.abstracts;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Education;

import java.util.List;

public interface EducationService {

    Result add(Education education);

    DataResult<List<Education>> getAll();

}
