package com.hrms.hrms.business.abstracts;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.entities.concretes.WorkPlace;


import java.util.List;

public interface WorkPlaceService {

    DataResult<List<WorkPlace>> getAll();
}
