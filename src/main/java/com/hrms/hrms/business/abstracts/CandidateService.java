package com.hrms.hrms.business.abstracts;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Candidate;

import java.util.List;

public interface CandidateService {

    DataResult<List<Candidate>> getAll();

    Result add(Candidate candidate);

    Result update(Candidate candidate);

}
