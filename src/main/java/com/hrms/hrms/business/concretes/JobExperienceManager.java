package com.hrms.hrms.business.concretes;


import com.hrms.hrms.business.abstracts.JobExperienceService;
import com.hrms.hrms.core.utilities.dtoConverter.DtoConverterService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.JobExperienceDao;
import com.hrms.hrms.entities.concretes.JobExperience;
import com.hrms.hrms.entities.dtos.JobExperienceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobExperienceManager implements JobExperienceService {

    private JobExperienceDao jobExperienceDao;
    private DtoConverterService dtoConverterService;


    @Autowired
    public JobExperienceManager(JobExperienceDao jobExperienceDao,DtoConverterService dtoConverterService){
        this.jobExperienceDao = jobExperienceDao;
        this.dtoConverterService = dtoConverterService;
    }

    @Override
    public Result add(JobExperienceDto jobExperienceDto) {
        this.jobExperienceDao.save((JobExperience) this.dtoConverterService.dtoClassConverter(jobExperienceDto,JobExperience.class));
        return new SuccessResult("Added");
    }

    @Override
    public DataResult<List<JobExperienceDto>> getAll() {
        return new SuccessDataResult<List<JobExperienceDto>>
                (this.dtoConverterService.dtoConverter(this.jobExperienceDao.findAll(),JobExperienceDto.class),
                        "JobExperiences have been listed");
    }

    @Override
    public DataResult<List<JobExperienceDto>> getAllByResumeIdOrderByStartedAtDesc(int id) {
        return new SuccessDataResult<List<JobExperienceDto>>
                (this.dtoConverterService.dtoConverter(this.jobExperienceDao.getAllByResumeIdOrderByStartedAtDesc(id)
                        ,JobExperienceDto.class));
    }
}
