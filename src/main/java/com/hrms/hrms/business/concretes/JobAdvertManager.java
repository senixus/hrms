package com.hrms.hrms.business.concretes;

import com.hrms.hrms.business.abstracts.JobAdvertService;
import com.hrms.hrms.core.dataAccess.UserDao;
import com.hrms.hrms.core.utilities.dtoConverter.DtoConverterService;
import com.hrms.hrms.core.utilities.results.*;
import com.hrms.hrms.dataAccess.abstracts.ConfirmJobAdvertDao;
import com.hrms.hrms.dataAccess.abstracts.EmployerDao;
import com.hrms.hrms.dataAccess.abstracts.JobAdvertDao;
import com.hrms.hrms.entities.concretes.ConfirmJobAdvert;
import com.hrms.hrms.entities.concretes.JobAdvert;
import com.hrms.hrms.entities.dtos.JobAdvertAddDto;
import com.hrms.hrms.entities.dtos.JobAdvertDto;
import com.hrms.hrms.entities.dtos.JobAdvertFilterDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JobAdvertManager implements JobAdvertService {

    private JobAdvertDao jobAdvertDao;
    private ModelMapper modelMapper;
    private DtoConverterService dtoConverterService;
    private EmployerDao employerDao;
    private ConfirmJobAdvertDao confirmJobAdvertDao;
    private UserDao userDao;


    @Autowired
    public JobAdvertManager(JobAdvertDao jobAdvertDao, ModelMapper modelMapper, DtoConverterService dtoConverterService, UserDao userDao, EmployerDao employerDao, ConfirmJobAdvertDao confirmJobAdvertDao) {
        this.jobAdvertDao = jobAdvertDao;
        this.modelMapper = modelMapper;
        this.dtoConverterService = dtoConverterService;
        this.employerDao = employerDao;
        this.confirmJobAdvertDao = confirmJobAdvertDao;
        this.userDao = userDao;
    }


    @Override
    public DataResult<List<JobAdvertDto>> getByIsActiveTrue() {

        return new SuccessDataResult<List<JobAdvertDto>>
                (this.dtoConverterService.dtoConverter(this.jobAdvertDao.getByIsActiveTrue(), JobAdvertDto.class),
                        "Job adverts have been listed");
    }

    @Override
    public Result add(JobAdvertAddDto jobAdvertAddDto) {

        jobAdvertAddDto.setActive(false);
        jobAdvertAddDto.setConfirm(false);


        JobAdvert jobAdvert = this.jobAdvertDao.saveAndFlush((JobAdvert) this.dtoConverterService.dtoClassConverter(jobAdvertAddDto, JobAdvert.class));

        ConfirmJobAdvert confirmJobAdvert = new ConfirmJobAdvert();
        confirmJobAdvert.setJobAdvertId(jobAdvert.getId());
        confirmJobAdvert.setConfirmed(false);

        this.confirmJobAdvertDao.save(confirmJobAdvert);

        return new SuccessResult("Job advert has been added");
    }

    @Override
    public Result confirmJobAdvert(int jobAdvertId, int employeeId) {
        if (!this.userDao.existsById(employeeId)) {
            return new ErrorResult("Employee has not found");
        }

        if (!this.jobAdvertDao.existsById(jobAdvertId)) {
            return new ErrorResult("Job Advert not found");
        }

        JobAdvert jobAdvert = this.jobAdvertDao.getById(jobAdvertId);

        if (!jobAdvert.isActive()) {
            return new ErrorResult("This job advert did not activate by employer so you cannot confirm it");
        }

        if (jobAdvert.isActive() && jobAdvert.isConfirm()) {
            return new ErrorResult("This job advert has already confirmed");
        }

        jobAdvert.setConfirm(true);
        this.jobAdvertDao.save(jobAdvert);

        ConfirmJobAdvert confirmJobAdvert = this.confirmJobAdvertDao.getById(jobAdvertId);
        confirmJobAdvert.setConfirmedAt(LocalDate.now());
        confirmJobAdvert.setConfirmed(true);
        confirmJobAdvert.setEmployeeId(employeeId);
        this.confirmJobAdvertDao.save(confirmJobAdvert);

        return new SuccessResult("Job advert have been confirmed");
    }



    @Override
    public DataResult<List<JobAdvertDto>> getByIsActiveTrueAndEmployerId(int employerId, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, Sort.by(Sort.Direction.DESC, "createdAt"));
        if (!this.employerDao.existsById(employerId)) {
            return new ErrorDataResult<>("Employer  not found");
        }
        return new SuccessDataResult<List<JobAdvertDto>>
                (this.dtoConverterService.dtoConverter(this.jobAdvertDao.getByIsActiveTrueAndEmployerId(pageable, employerId), JobAdvertDto.class)
                        , "Success");

    }

    @Override
    public DataResult<List<JobAdvertDto>> getByIsActiveTrueOrderByCreatedAtDesc(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, Sort.by(Sort.Direction.DESC, "createdAt"));
        return new SuccessDataResult<List<JobAdvertDto>>
                (this.dtoConverterService.dtoConverter(this.jobAdvertDao.getByIsActiveTrueOrderByCreatedAtDesc(pageable), JobAdvertDto.class),
                        "Job adverts have been listed by created at");
    }

    @Override
    public DataResult<List<JobAdvertDto>> getByIsActiveFalseAndEmployerId(int employerId, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, Sort.by(Sort.Direction.DESC, "createdAt"));
        if (!this.employerDao.existsById(employerId)) {
            return new ErrorDataResult<List<JobAdvertDto>>("Employer not found");
        }

        return new SuccessDataResult<List<JobAdvertDto>>
                (this.dtoConverterService.dtoConverter(this.jobAdvertDao.getByIsActiveFalseAndEmployerId(pageable, employerId), JobAdvertDto.class),
                        "Job adverts have been listed");
    }

    @Override
    public Result update(int id, boolean isActive) {
        if (!this.jobAdvertDao.existsById(id)) {
            return new ErrorResult("Job Advert not found");
        }
        JobAdvert jobAdvert = this.jobAdvertDao.findById(id).orElse(null);

        ConfirmJobAdvert confirmJobAdvert = this.confirmJobAdvertDao.getById(id);

        jobAdvert.setActive(isActive);

        if (jobAdvert.isConfirm()) {
            jobAdvert.setConfirm(false);
        }

        confirmJobAdvert.setConfirmed(false);
        this.confirmJobAdvertDao.save(confirmJobAdvert);


        this.jobAdvertDao.save(jobAdvert);

        return new SuccessResult("Job Advert has been updated");
    }

    @Override
    public DataResult<List<JobAdvertDto>> getJobAdvertById(int id) {

        if (!this.jobAdvertDao.existsById(id)) {
            return new ErrorDataResult<List<JobAdvertDto>>("Job Advert  not found");
        }

        return new SuccessDataResult<List<JobAdvertDto>>
                (this.dtoConverterService.dtoConverter(this.jobAdvertDao.getJobAdvertById(id), JobAdvertDto.class)
                        , "Job advert has been listed");

    }

    @Override
    public DataResult<List<JobAdvertDto>> getByIsConfirmTrueAndEmployerId(int employerId) {
        if (!this.employerDao.existsById(employerId)) {
            return new ErrorDataResult<List<JobAdvertDto>>("Employer not found");
        }


        return new SuccessDataResult<List<JobAdvertDto>>
                (this.dtoConverterService.dtoConverter(this.jobAdvertDao.getByIsConfirmTrueAndEmployerId(employerId), JobAdvertDto.class),
                        "Job adverts have been listed");
    }

    @Override
    public DataResult<List<JobAdvertDto>> getByIsConfirmTrueAndIsActiveTrueAndEmployerId(int employerId, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, Sort.by(Sort.Direction.DESC, "createdAt"));
        if (!this.employerDao.existsById(employerId)) {
            return new SuccessDataResult<List<JobAdvertDto>>("Employer not found");
        }
        return new SuccessDataResult<List<JobAdvertDto>>
                (this.dtoConverterService.dtoConverter(this.jobAdvertDao.getByIsConfirmTrueAndIsActiveTrueAndEmployerId(pageable, employerId), JobAdvertDto.class),
                        "Job adverts have been listed");
    }


    @Override
    public DataResult<List<JobAdvertDto>> getByIsConfirmFalseAndIsActiveTrue(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, Sort.by(Sort.Direction.DESC, "createdAt"));
        return new SuccessDataResult<List<JobAdvertDto>>
                (this.dtoConverterService.dtoConverter(this.jobAdvertDao.getByIsConfirmFalseAndIsActiveTrue(pageable), JobAdvertDto.class),
                        "Job Adverts have been listed");
    }

    @Override
    public DataResult<List<JobAdvertDto>> getByIsConfirmFalseAndIsActiveTrueAndEmployerId(int employerId, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, Sort.by(Sort.Direction.DESC, "createdAt"));
        if (!this.employerDao.existsById(employerId)) {
            return new ErrorDataResult<>("Employer not found");
        }

        return new SuccessDataResult<List<JobAdvertDto>>
                (this.dtoConverterService.dtoConverter(this.jobAdvertDao.getByIsConfirmFalseAndIsActiveTrueAndEmployerId(pageable, employerId), JobAdvertDto.class),
                        "Job Adverts have been listed");
    }

    @Override
    public DataResult<List<JobAdvert>> getByFilter(JobAdvertFilterDto jobAdvertFilterDto, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, Sort.by(Sort.Direction.DESC, "createdAt"));
        return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByFilter(jobAdvertFilterDto, pageable).getContent(), "Listelendi");

    }
}
