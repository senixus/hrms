package com.hrms.hrms.business.concretes;

import com.hrms.hrms.business.abstracts.ConfirmJobAdvertService;
import com.hrms.hrms.business.abstracts.JobAdvertService;
import com.hrms.hrms.core.utilities.dtoConverter.DtoConverterManager;
import com.hrms.hrms.core.utilities.dtoConverter.DtoConverterService;
import com.hrms.hrms.core.utilities.results.*;
import com.hrms.hrms.dataAccess.abstracts.EmployerDao;
import com.hrms.hrms.dataAccess.abstracts.JobAdvertDao;
import com.hrms.hrms.entities.concretes.ConfirmJobAdvert;
import com.hrms.hrms.entities.concretes.JobAdvert;
import com.hrms.hrms.entities.dtos.JobAdvertAddDto;
import com.hrms.hrms.entities.dtos.JobAdvertDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertManager implements JobAdvertService {

    private JobAdvertDao jobAdvertDao;
    private ModelMapper modelMapper;
    private DtoConverterService dtoConverterService;
    private EmployerDao employerDao;
    private ConfirmJobAdvertService confirmJobAdvertService;


    @Autowired
    public JobAdvertManager(JobAdvertDao jobAdvertDao, ModelMapper modelMapper, DtoConverterService dtoConverterService,EmployerDao employerDao,ConfirmJobAdvertService confirmJobAdvertService){
        this.jobAdvertDao = jobAdvertDao;
        this.modelMapper = modelMapper;
        this.dtoConverterService = dtoConverterService;
        this.employerDao = employerDao;
        this.confirmJobAdvertService = confirmJobAdvertService;
    }




    @Override
    public DataResult<List<JobAdvertDto>> getByIsActiveTrue() {

        return new SuccessDataResult<List<JobAdvertDto>>
                (this.dtoConverterService.dtoConverter(this.jobAdvertDao.getByIsActiveTrue(),JobAdvertDto.class),
                        "Job adverts have been listed");
    }

    @Override
    public Result add(JobAdvertAddDto jobAdvertAddDto) {

       this.jobAdvertDao.save((JobAdvert) this.dtoConverterService.dtoClassConverter(jobAdvertAddDto,JobAdvert.class));
       this.confirmJobAdvertService.createConfirmJobAdvert((JobAdvert) this.dtoConverterService.dtoClassConverter(jobAdvertAddDto,JobAdvert.class));
        return new SuccessResult("Job advert has been added");
    }

    @Override
    public DataResult<List<JobAdvertDto>> getByIsConfirmTrueAndIsActiveTrueOrderByCreatedAtDesc(int pageNo,int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return new SuccessDataResult<List<JobAdvertDto>>
                (this.dtoConverterService.dtoConverter(this.jobAdvertDao.getByIsConfirmTrueAndIsActiveTrueOrderByCreatedAtDesc(pageable),JobAdvertDto.class),
                        "Job adverts have been listed");
    }

    @Override
    public DataResult<List<JobAdvertDto>> getByIsActiveTrueAndEmployerId(int employerId) {
        if(!this.employerDao.existsById(employerId)){
            return new ErrorDataResult<>("Employer  not found");
        }
     return new SuccessDataResult<List<JobAdvertDto>>
             (this.dtoConverterService.dtoConverter(this.jobAdvertDao.getByIsActiveTrueAndEmployerId(employerId),JobAdvertDto.class)
                     ,"Success");

    }

    @Override
    public DataResult<List<JobAdvertDto>> getByIsActiveTrueOrderByCreatedAtDesc() {
      //  Sort sort = Sort.by(Sort.Direction.DESC,"createdAt");
        return new SuccessDataResult<List<JobAdvertDto>>
                (this.dtoConverterService.dtoConverter(this.jobAdvertDao.getByIsActiveTrueOrderByCreatedAtDesc(),JobAdvertDto.class),
                        "Job adverts have been listed by created at");
    }

    @Override
    public DataResult<List<JobAdvertDto>> getByIsActiveFalseAndEmployerId(int employerId) {
        if(!this.employerDao.existsById(employerId)){
            return new ErrorDataResult<List<JobAdvertDto>>("Employer not found");
        }

        return new SuccessDataResult<List<JobAdvertDto>>
                (this.dtoConverterService.dtoConverter(this.jobAdvertDao.getByIsActiveFalseAndEmployerId(employerId),JobAdvertDto.class),
                        "Job adverts have been listed");
    }

    @Override
    public Result update(int id,boolean isActive) {
        if(!this.jobAdvertDao.existsById(id)){
            return new ErrorResult("Job Advert not found");
        }
        JobAdvert jobAdvert = this.jobAdvertDao.findById(id).orElse(null);
        ConfirmJobAdvert confirmJobAdvert = new ConfirmJobAdvert();

        jobAdvert.setActive(isActive);

        if(jobAdvert.isConfirm()){
            jobAdvert.setConfirm(false);
        }
        // Confirm Dao Oluştur
        this.jobAdvertDao.save(jobAdvert);

        return new SuccessResult("Job Advert has been updated");
    }

    @Override
    public DataResult<List<JobAdvertDto>>  getJobAdvertById(int id) {

        if(!this.jobAdvertDao.existsById(id)){
            return  new ErrorDataResult<List<JobAdvertDto>>("Job Advert  not found");
        }

        return new SuccessDataResult<List<JobAdvertDto>>
                (this.dtoConverterService.dtoConverter(this.jobAdvertDao.getJobAdvertById(id),JobAdvertDto.class)
                        ,"Job advert has been listed");

    }

    @Override
    public DataResult<List<JobAdvertDto>> getByIsConfirmTrueAndEmployerId(int employerId) {
        if(!this.employerDao.existsById(employerId)){
            return new ErrorDataResult<List<JobAdvertDto>>("Employer not found");
        }


        return new SuccessDataResult<List<JobAdvertDto>>
                (this.dtoConverterService.dtoConverter(this.jobAdvertDao.getByIsConfirmTrueAndEmployerId(employerId),JobAdvertDto.class),
                        "Job adverts have been listed");
    }

    @Override
    public DataResult<List<JobAdvertDto>> getByIsConfirmTrueAndIsActiveTrueAndEmployerId(int employerId) {
        if(!this.employerDao.existsById(employerId)){
            return new SuccessDataResult<List<JobAdvertDto>>("Employer not found");
        }
        return new SuccessDataResult<List<JobAdvertDto>>
                (this.dtoConverterService.dtoConverter(this.jobAdvertDao.getByIsConfirmTrueAndIsActiveTrueAndEmployerId(employerId),JobAdvertDto.class),
                        "Job adverts have been listed");
    }

    @Override
    public Result confirmJobAdvert(int id) {

        if(!this.jobAdvertDao.existsById(id)){
            return new ErrorResult("Job Advert not found");
        }
       JobAdvert jobAdvert = this.jobAdvertDao.findById(id).orElse(null);

        if(!jobAdvert.isActive()){
            return new ErrorResult("This job advert did not activate by employer so you cannot confirm it");
        }
        if(jobAdvert.isActive() && jobAdvert.isConfirm()){
            return new ErrorResult("This job advert have already confirmed");
        }
        jobAdvert.setConfirm(true);

        this.jobAdvertDao.save(jobAdvert);
        return new SuccessResult("Job advert have been confirmed");
    }

    @Override
    public DataResult<List<JobAdvertDto>> getByIsConfirmFalseAndIsActiveTrue() {
        return new SuccessDataResult<List<JobAdvertDto>>
                (this.dtoConverterService.dtoConverter(this.jobAdvertDao.getByIsConfirmFalseAndIsActiveTrue(),JobAdvertDto.class),
                        "Job Adverts have been listed");
    }

    @Override
    public DataResult<List<JobAdvertDto>> getByIsConfirmFalseAndIsActiveTrueAndEmployerId(int employerId) {

        if(!this.employerDao.existsById(employerId)){
            return new ErrorDataResult<>("Employer not found");
        }

        return new SuccessDataResult<List<JobAdvertDto>>
                (this.dtoConverterService.dtoConverter(this.jobAdvertDao.getByIsConfirmFalseAndIsActiveTrueAndEmployerId(employerId),JobAdvertDto.class),
                        "Job Adverts have been listed");
    }
}
