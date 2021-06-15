package com.hrms.hrms.business.concretes;

import com.hrms.hrms.business.abstracts.ConfirmJobAdvertService;
import com.hrms.hrms.core.utilities.results.ErrorResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.ConfirmJobAdvertDao;
import com.hrms.hrms.dataAccess.abstracts.EmployerDao;
import com.hrms.hrms.dataAccess.abstracts.JobAdvertDao;
import com.hrms.hrms.entities.concretes.ConfirmJobAdvert;
import com.hrms.hrms.entities.concretes.Employee;
import com.hrms.hrms.entities.concretes.JobAdvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class ConfirmJobAdvertManager implements ConfirmJobAdvertService {

    private ConfirmJobAdvertDao confirmJobAdvertDao;
    private JobAdvertDao jobAdvertDao;

    @Autowired
    public ConfirmJobAdvertManager(ConfirmJobAdvertDao confirmJobAdvertDao,JobAdvertDao jobAdvertDao){
        this.confirmJobAdvertDao = confirmJobAdvertDao;
        this.jobAdvertDao = jobAdvertDao;
    }

    @Override
    public void createConfirmJobAdvert(JobAdvert jobAdvert) {
        Employee employee = new Employee();

        ConfirmJobAdvert confirmJobAdvert = new ConfirmJobAdvert();
        confirmJobAdvert.setJobAdvert(jobAdvert);
        confirmJobAdvert.setEmployee(employee);
        this.confirmJobAdvertDao.save(confirmJobAdvert);
    }

    @Override
    public Result confirmJobAdvert(int jobAdvertId) {

        if(!this.jobAdvertDao.existsById(jobAdvertId)){
            return new ErrorResult("Job advert not found");
        }
        if(this.jobAdvertDao.getById(jobAdvertId).isConfirm()){
                return new ErrorResult("Job advert already confirmed");
        }

        if(!this.jobAdvertDao.getById(jobAdvertId).isActive()){
            return new ErrorResult("This job advert did not activate by employer so you cannot confirm it");
        }

        ConfirmJobAdvert confirmJobAdvert = new ConfirmJobAdvert();
        JobAdvert jobAdvert = new JobAdvert();

        jobAdvert = this.jobAdvertDao.getById(jobAdvertId);
        jobAdvert.setConfirm(true);
        this.jobAdvertDao.save(jobAdvert);

        confirmJobAdvert = this.confirmJobAdvertDao.getById(jobAdvert.getId());
        confirmJobAdvert.setConfirmed(true);

        LocalDate date = LocalDate.now();

        confirmJobAdvert.setConfirmedAt(date);
        this.confirmJobAdvertDao.save(confirmJobAdvert);

        return new SuccessResult("Job advert has been confirmed");
    }
}
