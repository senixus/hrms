package com.hrms.hrms.business.concretes;

import com.hrms.hrms.business.abstracts.TechnologyService;
import com.hrms.hrms.core.utilities.dtoConverter.DtoConverterService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.TechnologyDao;
import com.hrms.hrms.entities.concretes.Technology;
import com.hrms.hrms.entities.dtos.TechnologyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyManager implements TechnologyService {

    private TechnologyDao technologyDao;
    private DtoConverterService dtoConverterService;

    @Autowired
    public TechnologyManager(TechnologyDao technologyDao,DtoConverterService dtoConverterService){
        this.technologyDao = technologyDao;
        this.dtoConverterService = dtoConverterService;
    }

    @Override
    public Result add(TechnologyDto technologyDto) {
        this.technologyDao.save((Technology) this.dtoConverterService.dtoClassConverter(technologyDto,Technology.class));
        return new SuccessResult("Added");
    }

    @Override
    public DataResult<List<TechnologyDto>> getAll() {
        return new SuccessDataResult<List<TechnologyDto>>
                (this.dtoConverterService.dtoConverter(this.technologyDao.findAll(),TechnologyDto.class)
                        ,"Technologies have been listed");
    }
}
