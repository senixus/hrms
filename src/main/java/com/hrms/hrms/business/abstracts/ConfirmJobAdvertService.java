package com.hrms.hrms.business.abstracts;

import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.JobAdvert;

public interface ConfirmJobAdvertService {

    void createConfirmJobAdvert(JobAdvert jobAdvert);

    Result confirmJobAdvert(int jobAdvertId);

}
