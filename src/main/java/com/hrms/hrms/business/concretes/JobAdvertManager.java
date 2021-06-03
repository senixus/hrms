package com.hrms.hrms.business.concretes;

import com.hrms.hrms.business.abstracts.JobAdvertService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.JobAdvertDao;
import com.hrms.hrms.entities.concretes.JobAdvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertManager implements JobAdvertService {

    private JobAdvertDao jobAdvertDao;

    @Autowired
    public JobAdvertManager(JobAdvertDao jobAdvertDao){
        this.jobAdvertDao = jobAdvertDao;
    }


    @Override
    public DataResult<List<JobAdvert>> getByIsActiveTrue() {
        return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByIsActiveTrue(),"Job adverts have been listed");
    }

    @Override
    public Result add(JobAdvert jobAdvert) {
        this.jobAdvertDao.save(jobAdvert);
        return new SuccessResult("Job advert has been added");
    }

    @Override
    public DataResult<List<JobAdvert>> getByIsActiveTrueAndEmployerId(int employerId) {
        return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByIsActiveTrueAndEmployerId(employerId),"Job adverts have been listed by employer id");
    }

    @Override
    public DataResult<List<JobAdvert>> getAllByCreatedAt() {
        Sort sort = Sort.by(Sort.Direction.DESC,"createdAt");
        return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByIsActiveTrue(sort),"Job adverts have been listed by created at");
    }

    @Override
    public Result update(int id,boolean isActive) {
        JobAdvert jobAdvert = this.jobAdvertDao.findById(id).orElse(null);

        jobAdvert.setActive(isActive);

        this.jobAdvertDao.save(jobAdvert);

        return new SuccessResult("Job Advert has been updated");
    }
}
