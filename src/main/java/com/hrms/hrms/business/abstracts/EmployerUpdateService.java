package com.hrms.hrms.business.abstracts;

import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.EmployerUpdate;

public interface EmployerUpdateService {

    Result update(EmployerUpdate employerUpdate);

    Result confirmUpdate(int employerUpdateId, int employeeId);

}
