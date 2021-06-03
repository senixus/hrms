package com.hrms.hrms.business.abstracts;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Graduate;


import java.util.List;

public interface GraduateService {

    Result add(Graduate graduate);

    DataResult<List<Graduate>> getAll();

}
