package com.hrms.hrms.business.validations;

import com.hrms.hrms.business.abstracts.ValidationService;
import com.hrms.hrms.core.dataAccess.UserDao;
import com.hrms.hrms.core.utilities.results.*;
import com.hrms.hrms.dataAccess.abstracts.EmployerDao;
import com.hrms.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployerValidationManager implements ValidationService<Employer> {

    private EmployerDao employerDao;
    private UserDao userDao;

    @Autowired
    public EmployerValidationManager(EmployerDao employerDao, UserDao userDao){
        this.employerDao = employerDao;
        this.userDao = userDao;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Employers have been listed");
    }

    @Override
    public Result add(Employer employer) {
        String[] email = employer.getEmail().split("@");

        if(!email[1].equals(employer.getWebsite())){
            return new ErrorResult("Website must be equal your email");
        }

        if(this.userDao.existsByEmail(employer.getEmail())){
            return new ErrorResult("Email already exist");
        }
        if(!employer.getPassword().equals(employer.getConfirmPassword())){
            return new ErrorResult("Passwords do not match");
        }

        this.employerDao.save(employer);
        return new SuccessResult("Employer has been added");
    }

    @Override
    public Result update(Employer employer) {

        String[] email = employer.getEmail().split("@");

        if(!email[1].equals(employer.getWebsite())){
            return new ErrorResult("Website must be equal your email");
        }

        if(this.userDao.existsByEmail(employer.getEmail())){
            return new ErrorResult("Email already exist");
        }

        if(!this.userDao.existsById(employer.getId())){
            return  new ErrorResult("User have not found");
        }

        this.employerDao.save(employer);
        return new SuccessResult("Employer has been updated");
    }
}
