package com.hrms.hrms.business.abstracts;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Employee;

import java.util.List;

public interface EmployeeService {

    DataResult<List<Employee>> getAll();

    Result add(Employee employee);

    Result update(Employee employee);

}
