package com.hrms.hrms.api.controllers;

import com.hrms.hrms.business.abstracts.JobExperienceService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.JobExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job-experience")
public class JobExperienceController {

    private JobExperienceService jobExperienceService;

    @Autowired
    public JobExperienceController(JobExperienceService jobExperienceService){
        this.jobExperienceService = jobExperienceService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobExperience>> getAll(){
        return this.jobExperienceService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobExperience jobExperience){
        return this.jobExperienceService.add(jobExperience);
    }

    @GetMapping("/getAllByResumeIdOrderByStartedAtDesc")
    public DataResult<List<JobExperience>> getAllByResumeIdOrderByStartedAtDesc(int id) {
        return this.jobExperienceService.getAllByResumeIdOrderByStartedAtDesc(id);
    }

}
