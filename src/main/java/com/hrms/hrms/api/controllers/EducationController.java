package com.hrms.hrms.api.controllers;

import com.hrms.hrms.business.abstracts.EducationService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Education;
import com.hrms.hrms.entities.dtos.EducationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin

@RestController
@RequestMapping("/api/education")
public class EducationController {

    private EducationService educationService;

    @Autowired
    public EducationController(EducationService educationService){
        this.educationService = educationService;
    }

    @GetMapping("/getall")
    public DataResult<List<EducationDto>> getAll(){
        return this.educationService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody EducationDto educationDto){
        return this.educationService.add(educationDto);
    }

    @GetMapping("/getAllByResumeIdOrderByStartedAtDesc")
    public DataResult<List<EducationDto>> getAllByResumeIdOrderByStartedAtDesc(int id){
        return this.educationService.getAllByResumeIdOrderByStartedAtDesc(id);
    }

}
