package com.hrms.hrms.business.concretes;

import com.hrms.hrms.business.abstracts.EmployerUpdateService;
import com.hrms.hrms.business.abstracts.ValidationService;
import com.hrms.hrms.core.dataAccess.UserDao;
import com.hrms.hrms.core.utilities.results.ErrorResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.EmployerDao;
import com.hrms.hrms.dataAccess.abstracts.EmployerUpdateDao;
import com.hrms.hrms.entities.concretes.Employer;
import com.hrms.hrms.entities.concretes.EmployerUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EmployerUpdateManager implements EmployerUpdateService {

    private EmployerDao employerDao;
    private EmployerUpdateDao employerUpdateDao;
   // private ValidationService<EmployerUpdate> validationService;
    private UserDao userDao;


    @Autowired
    public EmployerUpdateManager(EmployerDao employerDao,EmployerUpdateDao employerUpdateDao,UserDao userDao){
        this.employerDao = employerDao;
        this.employerUpdateDao = employerUpdateDao;
        this.userDao = userDao;
    }


    @Override
    public Result update(EmployerUpdate employerUpdate) {
        String[] email = employerUpdate.getEmail().split("@");

        if(!email[1].equals(employerUpdate.getWebsite())){
            return new ErrorResult("Website must be equal your email");
        }

        if(this.userDao.existsByEmail(employerUpdate.getEmail())){
            return new ErrorResult("Email already exist");
        }

        if(!this.userDao.existsById(employerUpdate.getEmployerId())){
            return  new ErrorResult("User have not found");
        }

        Employer employer = this.employerDao.getById(employerUpdate.getEmployerId());

        //employer.setConfirm(false);
        employerUpdate.setConfirm(false);
        this.employerUpdateDao.save(employerUpdate);
        employer.setUpdateRequest(true);

        this.employerDao.save(employer);
        return  new SuccessResult("Update request have been sent");


    }

    @Override
    public Result confirmUpdate(int employerUpdateId, int employeeId) {
        if(!this.employerUpdateDao.existsById(employerUpdateId)){
            return new ErrorResult("Not found");
        }
        if(!this.userDao.existsById(employeeId)){
            return new ErrorResult("Not found");
        }

        EmployerUpdate employerUpdate = this.employerUpdateDao.getById(employerUpdateId);
        Employer employer = this.employerDao.getById(employerUpdate.getEmployerId());

        employerUpdate.setConfirm(true);
        employerUpdate.setEmployeeId(employeeId);
        employerUpdate.setConfirmedAt(LocalDate.now());

        this.employerUpdateDao.save(employerUpdate);

        employer.setEmail(employerUpdate.getEmail());
        employer.setCompanyName(employerUpdate.getCompanyName());
        employer.setPhoneNumber(employerUpdate.getPhoneNumber());
        employer.setWebsite(employerUpdate.getWebsite());
        employer.setUpdateRequest(false);

        this.employerDao.save(employer);
        return new SuccessResult("Updated");

    }
}
