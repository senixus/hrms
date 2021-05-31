package com.hrms.hrms.business.concretes;

import java.util.List;

import com.hrms.hrms.business.abstracts.JobTitleService;
import com.hrms.hrms.business.abstracts.ValidationService;
import com.hrms.hrms.business.validations.JobTitleValidationManager;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.dataAccess.abstracts.JobTitleDao;
import com.hrms.hrms.entities.concretes.JobTitle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobTitleManager implements JobTitleService {

   private ValidationService<JobTitle> validationService;

    @Autowired
    public JobTitleManager(ValidationService<JobTitle> validationService) {
        this.validationService = validationService;
    }

    @Override
    public DataResult<List<JobTitle>> getAll() {
        return this.validationService.getAll();
    }

    @Override
    public Result add(JobTitle jobTitle) {
        return this.validationService.add(jobTitle);
    }

}
