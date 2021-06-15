package com.hrms.hrms.business.abstracts;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.entities.concretes.WorkTime;

import java.util.List;

public interface WorkTimeService {

    DataResult<List<WorkTime>> getAll();

}
