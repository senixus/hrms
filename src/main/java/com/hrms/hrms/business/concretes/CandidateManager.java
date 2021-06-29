package com.hrms.hrms.business.concretes;

import com.hrms.hrms.business.abstracts.CandidateService;
import com.hrms.hrms.business.abstracts.ValidationService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CandidateManager implements CandidateService {

    private ValidationService<Candidate> validationService;

    @Autowired
    public CandidateManager(ValidationService<Candidate> validationService){
        this.validationService = validationService;
    }


    @Override
    public DataResult<List<Candidate>> getAll() {
        return this.validationService.getAll();

    }

    @Override
    public Result add(Candidate candidate) {
        return this.validationService.add(candidate);
    }

    @Override
    public Result update(Candidate candidate) {
        return this.validationService.update(candidate);
    }


}
