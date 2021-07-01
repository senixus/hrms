package com.hrms.hrms.api.controllers;

import com.hrms.hrms.business.abstracts.ConfirmEmployerService;
import com.hrms.hrms.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/confirmEmployer")
public class ConfirmEmployerController {

    private ConfirmEmployerService confirmEmployerService;

    @Autowired
    public ConfirmEmployerController(ConfirmEmployerService confirmEmployerService){
        this.confirmEmployerService = confirmEmployerService;
    }

    @GetMapping("/confirm")
    public Result confirmEmployer(@RequestParam int employerId, @RequestParam int employeeId){
        return this.confirmEmployerService.confirmEmployer(employerId,employeeId);
    }

}
