package com.hrms.hrms.business.abstracts;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Graduate;
import com.hrms.hrms.entities.concretes.Technology;

import java.util.List;

public interface TechnologyService {

    Result add(Technology technology);

    DataResult<List<Technology>> getAll();
}
