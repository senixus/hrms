package com.hrms.hrms.business.concretes;

import com.hrms.hrms.business.abstracts.EducationService;
import com.hrms.hrms.core.utilities.dtoConverter.DtoConverterService;
import com.hrms.hrms.core.utilities.results.*;
import com.hrms.hrms.dataAccess.abstracts.EducationDao;
import com.hrms.hrms.dataAccess.abstracts.GraduateDao;
import com.hrms.hrms.entities.concretes.Education;
import com.hrms.hrms.entities.concretes.Graduate;
import com.hrms.hrms.entities.dtos.EducationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationManager implements EducationService {

    private EducationDao educationDao;
    private DtoConverterService dtoConverterService;
    private GraduateDao graduateDao;


    @Autowired
    public EducationManager(EducationDao educationDao,DtoConverterService dtoConverterService,GraduateDao graduateDao){
        this.educationDao = educationDao;
        this.dtoConverterService = dtoConverterService;
        this.graduateDao = graduateDao;
    }


    @Override
    public Result add(EducationDto educationDto) {
       if (educationDto.getGraduateAt() != null && !educationDto.getStartedAt().isBefore(educationDto.getGraduateAt())) {
            return new ErrorResult("hata");

      }
            this.educationDao.save((Education) this.dtoConverterService.dtoClassConverter(educationDto,Education.class));
            return new SuccessResult("Added");
    }

    @Override
    public DataResult<List<EducationDto>> getAll() {
        return new SuccessDataResult<List<EducationDto>>
                (this.dtoConverterService.dtoConverter(this.educationDao.findAll(),EducationDto.class)
                        ,"Educations have been listed");
    }

    @Override
    public DataResult<List<EducationDto>> getAllByResumeIdOrderByStartedAtDesc(int id) {
        return new SuccessDataResult<List<EducationDto>>
                (this.dtoConverterService.dtoConverter(this.educationDao.getAllByResumeIdOrderByStartedAtDesc(id),
                        EducationDto.class),"Educations have been listed");
    }

    @Override
    public DataResult<Education> findById(int id) {

        return new SuccessDataResult<Education>(this.educationDao.findById(id).orElse(null),"Education has been received");
    }

    @Override
    public Result update(EducationDto educationDto) {

        if (!this.educationDao.existsById(educationDto.getId())){
                return new ErrorResult("Education have not found");
        }
        this.educationDao.save((Education) this.dtoConverterService.dtoClassConverter(educationDto,Education.class));

        return new SuccessResult("Education has been updated");
    }
}
