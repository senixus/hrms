package com.hrms.hrms.business.concretes;

import com.hrms.hrms.business.abstracts.GraduateService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.GraduateDao;
import com.hrms.hrms.entities.concretes.Graduate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GraduateManager implements GraduateService {

    private GraduateDao graduateDao;

    @Autowired
    public GraduateManager(GraduateDao graduateDao){
        this.graduateDao = graduateDao;
    }

    @Override
    public Result add(Graduate graduate) {
        this.graduateDao.save(graduate);
        return new SuccessResult("Added");
    }

    @Override
    public DataResult<List<Graduate>> getAll() {
        return new SuccessDataResult<List<Graduate>>(this.graduateDao.findAll(),"Graduates have been listed");
    }
}
