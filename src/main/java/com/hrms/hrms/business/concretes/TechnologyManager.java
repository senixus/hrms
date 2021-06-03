package com.hrms.hrms.business.concretes;

import com.hrms.hrms.business.abstracts.TechnologyService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.TechnologyDao;
import com.hrms.hrms.entities.concretes.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyManager implements TechnologyService {

    private TechnologyDao technologyDao;

    @Autowired
    public TechnologyManager(TechnologyDao technologyDao){
        this.technologyDao = technologyDao;
    }

    @Override
    public Result add(Technology technology) {
        this.technologyDao.save(technology);
        return new SuccessResult("Added");
    }

    @Override
    public DataResult<List<Technology>> getAll() {
        return new SuccessDataResult<List<Technology>>(this.technologyDao.findAll(),"Technologies have been listed");
    }
}
