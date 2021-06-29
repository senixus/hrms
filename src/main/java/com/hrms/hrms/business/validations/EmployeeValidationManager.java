package com.hrms.hrms.business.validations;

import com.hrms.hrms.business.abstracts.ValidationService;
import com.hrms.hrms.core.dataAccess.UserDao;
import com.hrms.hrms.core.utilities.mernis.UserCheckService;
import com.hrms.hrms.core.utilities.results.*;
import com.hrms.hrms.dataAccess.abstracts.EmployeeDao;
import com.hrms.hrms.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeValidationManager implements ValidationService<Employee> {

    private EmployeeDao employeeDao;
    private UserDao userDao;


    @Autowired
    public EmployeeValidationManager(EmployeeDao employeeDao,UserDao userDao){
            this.employeeDao = employeeDao;
            this.userDao = userDao;

    }


    @Override
    public DataResult<List<Employee>> getAll() {
        return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(),"Employees have been listed");
    }

    @Override
    public Result add(Employee employee) {
        if(this.userDao.existsByEmail(employee.getEmail())){
            return new ErrorResult("Email already exist");
        }
        if(!employee.getPassword().equals(employee.getConfirmPassword())){
            return new ErrorResult("Passwords do not match");
        }

        this.employeeDao.save(employee);
        return new SuccessResult("Employee has been added");
    }

    @Override
    public Result update(Employee employee) {
        if(!this.userDao.existsById(employee.getId())){
            return new ErrorResult("User have not found");
        }

        this.employeeDao.save(employee);
        return new SuccessResult("Updated");
    }
}
