package com.hrms.hrms.business.concretes;

import com.hrms.hrms.business.abstracts.WorkTimeService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.dataAccess.abstracts.WorkTimeDao;
import com.hrms.hrms.entities.concretes.WorkTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkTimeManager implements WorkTimeService {

    private WorkTimeDao workTimeDao;

    @Autowired
    public  WorkTimeManager(WorkTimeDao workTimeDao){
        this.workTimeDao = workTimeDao;
    }


    @Override
    public DataResult<List<WorkTime>> getAll() {
        return new SuccessDataResult<List<WorkTime>>(this.workTimeDao.findAll(),"Work time has been listed");
    }
}
