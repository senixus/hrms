package com.hrms.hrms.business.concretes;

import com.hrms.hrms.business.abstracts.EducationService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.EducationDao;
import com.hrms.hrms.entities.concretes.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationManager implements EducationService {

    private EducationDao educationDao;

    @Autowired
    public EducationManager(EducationDao educationDao){
        this.educationDao = educationDao;
    }


    @Override
    public Result add(Education education) {
        this.educationDao.save(education);
        return new SuccessResult("Added");
    }

    @Override
    public DataResult<List<Education>> getAll() {
        return new SuccessDataResult<List<Education>>(this.educationDao.findAll(),"Educations have been listed");
    }
}
