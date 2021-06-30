package com.hrms.hrms.business.abstracts;

import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.JobAdvert;

public interface ConfirmJobAdvertService {



    Result confirmJobAdvert(int jobAdvertId,int employeeId);

}
