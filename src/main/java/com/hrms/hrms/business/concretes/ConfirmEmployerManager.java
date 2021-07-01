package com.hrms.hrms.business.concretes;

import com.hrms.hrms.business.abstracts.ConfirmEmployerService;
import com.hrms.hrms.core.dataAccess.UserDao;
import com.hrms.hrms.core.utilities.results.ErrorResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.ConfirmEmployerDao;
import com.hrms.hrms.dataAccess.abstracts.EmployerDao;
import com.hrms.hrms.entities.concretes.ConfirmEmployer;
import com.hrms.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ConfirmEmployerManager implements ConfirmEmployerService {

    private EmployerDao employerDao;
    private ConfirmEmployerDao confirmEmployerDao;
    private UserDao userDao;

    @Autowired
    public ConfirmEmployerManager(EmployerDao employerDao,ConfirmEmployerDao confirmEmployerDao,UserDao userDao){
        this.employerDao = employerDao;
        this.confirmEmployerDao = confirmEmployerDao;
        this.userDao = userDao;
    }

    @Override
    public void createConfirmEmployer(Employer employer) {
        ConfirmEmployer confirmEmployer = new ConfirmEmployer();
        confirmEmployer.setEmployerId(employer.getId());
        confirmEmployer.setConfirmed(false);
        confirmEmployer.setEmployeeId(0);
        this.confirmEmployerDao.save(confirmEmployer);

    }

    @Override
    public Result confirmEmployer(int employerId, int employeeId) {

        Employer employer = this.employerDao.getById(employerId);
        ConfirmEmployer confirmEmployer = this.confirmEmployerDao.getByEmployerId(employerId);

        if (!this.userDao.existsById(employerId)){
            return new ErrorResult("Employer has not found");
        }

        if (!this.userDao.existsById(employeeId)){
            return new ErrorResult("Employee has not found");
        }

        employer.setConfirmed(true);
        this.employerDao.save(employer);

        confirmEmployer.setConfirmed(true);
        confirmEmployer.setConfirmedAt(LocalDate.now());
        confirmEmployer.setEmployeeId(employeeId);
        this.confirmEmployerDao.save(confirmEmployer);


        return new SuccessResult("Employer has been confirmed");
    }
}
