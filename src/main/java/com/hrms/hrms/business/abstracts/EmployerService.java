package com.hrms.hrms.business.abstracts;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Employer;

import java.util.List;

public interface EmployerService {

    DataResult<List<Employer>> getAll();

    Result add(Employer employer);

    Result update(Employer employer);

}
