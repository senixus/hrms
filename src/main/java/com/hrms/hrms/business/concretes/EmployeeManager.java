package com.hrms.hrms.business.concretes;

import com.hrms.hrms.business.abstracts.EmployeeService;
import com.hrms.hrms.business.abstracts.ValidationService;
import com.hrms.hrms.core.dataAccess.UserDao;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.dataAccess.abstracts.EmployeeDao;
import com.hrms.hrms.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeManager implements EmployeeService {

    private ValidationService<Employee> validationService;
    private EmployeeDao employeeDao;
    private UserDao userDao;

    @Autowired
    public EmployeeManager (ValidationService<Employee> validationService) {
        this.validationService = validationService;
    }



    @Override
    public DataResult<List<Employee>> getAll() {
        return this.validationService.getAll();
    }

    @Override
    public Result add(Employee employee) {
        return this.validationService.add(employee);
    }

    @Override
    public Result update(Employee employee) {
        return this.validationService.update(employee);
    }
}
