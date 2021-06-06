package com.hrms.hrms.business.abstracts;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.dtos.TechnologyDto;

import java.util.List;

public interface TechnologyService {

    Result add(TechnologyDto technologydto);

    DataResult<List<TechnologyDto>> getAll();
}
