package com.hrms.hrms.business.concretes;

import com.hrms.hrms.business.abstracts.JobAdvertService;
import com.hrms.hrms.core.utilities.dtoConverter.DtoConverterManager;
import com.hrms.hrms.core.utilities.dtoConverter.DtoConverterService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.JobAdvertDao;
import com.hrms.hrms.entities.concretes.JobAdvert;
import com.hrms.hrms.entities.dtos.JobAdvertAddDto;
import com.hrms.hrms.entities.dtos.JobAdvertDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertManager implements JobAdvertService {

    private JobAdvertDao jobAdvertDao;
    private ModelMapper modelMapper;
    private DtoConverterService dtoConverterService;

    @Autowired
    public JobAdvertManager(JobAdvertDao jobAdvertDao, ModelMapper modelMapper, DtoConverterService dtoConverterService){
        this.jobAdvertDao = jobAdvertDao;
        this.modelMapper = modelMapper;
        this.dtoConverterService = dtoConverterService;
    }

    private JobAdvert dtoConverter(JobAdvertAddDto jobAdvertAddDto){
        return this.modelMapper.map(jobAdvertAddDto,JobAdvert.class);
    }


    @Override
    public DataResult<List<JobAdvertDto>> getByIsActiveTrue() {

        return new SuccessDataResult<List<JobAdvertDto>>
                (this.dtoConverterService.dtoConverter(this.jobAdvertDao.getByIsActiveTrue(),JobAdvertDto.class),
                        "Job adverts have been listed");
    }

    @Override
    public Result add(JobAdvertAddDto jobAdvertAddDto) {

       this.jobAdvertDao.save(this.dtoConverter(jobAdvertAddDto));

        return new SuccessResult("Job advert has been added");
    }

    @Override
    public DataResult<List<JobAdvertDto>> getByIsActiveTrueAndEmployerId(int employerId) {

     return new SuccessDataResult<List<JobAdvertDto>>
             (this.dtoConverterService.dtoConverter(this.jobAdvertDao.getByIsActiveTrueAndEmployerId(employerId),JobAdvertDto.class)
                     ,"Success");

    }

    @Override
    public DataResult<List<JobAdvertDto>> getAllByCreatedAt() {
        Sort sort = Sort.by(Sort.Direction.DESC,"createdAt");
        return new SuccessDataResult<List<JobAdvertDto>>
                (this.dtoConverterService.dtoConverter(this.jobAdvertDao.getByIsActiveTrue(sort),JobAdvertDto.class),
                        "Job adverts have been listed by created at");
    }

    @Override
    public Result update(int id,boolean isActive) {
        JobAdvert jobAdvert = this.jobAdvertDao.findById(id).orElse(null);

        jobAdvert.setActive(isActive);

        this.jobAdvertDao.save(jobAdvert);

        return new SuccessResult("Job Advert has been updated");
    }
}
