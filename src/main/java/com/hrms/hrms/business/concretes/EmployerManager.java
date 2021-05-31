package com.hrms.hrms.business.concretes;

import com.hrms.hrms.business.abstracts.EmployerService;
import com.hrms.hrms.business.abstracts.ValidationService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private ValidationService<Employer> validationService;

    @Autowired
    public EmployerManager(ValidationService<Employer> validationService){
        this.validationService = validationService;
    }


    @Override
    public DataResult<List<Employer>> getAll() {
        return this.validationService.getAll();
    }

    @Override
    public Result add(Employer employer) {
        return this.validationService.add(employer);
    }
}
