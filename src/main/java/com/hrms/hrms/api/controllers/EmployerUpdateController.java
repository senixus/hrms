package com.hrms.hrms.api.controllers;

import com.hrms.hrms.business.abstracts.EmployerUpdateService;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.EmployerUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/employerUpdate")
public class EmployerUpdateController {


    private EmployerUpdateService employerUpdateService;

    @Autowired
    public EmployerUpdateController(EmployerUpdateService employerUpdateService){
        this.employerUpdateService = employerUpdateService;
    }

    @PostMapping("/update")
    public Result update(@RequestBody  EmployerUpdate employerUpdate) {
        return this.employerUpdateService.update(employerUpdate);
    }

    @PostMapping("/confirmUpdate")
    public Result confirmUpdate(int employerUpdateId, int employeeId) {
        return this.employerUpdateService.confirmUpdate(employerUpdateId,employeeId);
    }

}
