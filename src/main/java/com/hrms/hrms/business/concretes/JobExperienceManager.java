package com.hrms.hrms.business.concretes;


import com.hrms.hrms.business.abstracts.JobExperienceService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.JobExperienceDao;
import com.hrms.hrms.entities.concretes.JobExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobExperienceManager implements JobExperienceService {

    private JobExperienceDao jobExperienceDao;

    @Autowired
    public JobExperienceManager(JobExperienceDao jobExperienceDao){
        this.jobExperienceDao = jobExperienceDao;
    }

    @Override
    public Result add(JobExperience jobExperience) {
        this.jobExperienceDao.save(jobExperience);
        return new SuccessResult("Added");
    }

    @Override
    public DataResult<List<JobExperience>> getAll() {
        return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAll(),"JobExperiences have been listed");
    }
}
