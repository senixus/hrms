package com.hrms.hrms.api.controllers;


import com.hrms.hrms.business.abstracts.EducationService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/education")
public class EducationController {

    private EducationService educationService;

    @Autowired
    public EducationController(EducationService educationService){
        this.educationService = educationService;
    }

    @GetMapping("/getall")
    public DataResult<List<Education>> getAll(){
        return this.educationService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Education education){
        return this.educationService.add(education);
    }


}
