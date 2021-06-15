package com.hrms.hrms.api.controllers;


import com.hrms.hrms.business.abstracts.WorkTimeService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.entities.concretes.WorkTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin

@RestController
@RequestMapping("/api/worktime")
public class WorkTimeController {

    private WorkTimeService workTimeService;

    @Autowired
    public WorkTimeController(WorkTimeService workTimeService){
        this.workTimeService = workTimeService;
    }


    @GetMapping("/getall")
    public DataResult<List<WorkTime>> getAll() {
        return this.workTimeService.getAll();
    }


}
