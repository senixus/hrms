package com.hrms.hrms.business.validations;

import com.hrms.hrms.business.abstracts.ValidationService;
import com.hrms.hrms.core.utilities.results.*;
import com.hrms.hrms.dataAccess.abstracts.JobTitleDao;
import com.hrms.hrms.entities.concretes.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobTitleValidationManager implements ValidationService<JobTitle> {

    private JobTitleDao jobTitleDao;

    @Autowired
    public JobTitleValidationManager(JobTitleDao jobTitleDao){
        this.jobTitleDao = jobTitleDao;
    }

    public DataResult<List<JobTitle>> getAll(){
        return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll(),"Job title listed");
    }

    public Result add(JobTitle jobTitle){

        if(this.jobTitleDao.existsByTitle(jobTitle.getTitle())){
            return new ErrorResult("Job title already exist");
        }

        this.jobTitleDao.save(jobTitle);
        return new SuccessResult("Job Title added");

    }



}
