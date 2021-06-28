package com.hrms.hrms.api.controllers;

import com.hrms.hrms.business.abstracts.JobExperienceService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.dtos.JobExperienceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin

@RestController
@RequestMapping("/api/job-experience")
public class JobExperienceController {

    private JobExperienceService jobExperienceService;

    @Autowired
    public JobExperienceController(JobExperienceService jobExperienceService){
        this.jobExperienceService = jobExperienceService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobExperienceDto>> getAll(){
        return this.jobExperienceService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobExperienceDto jobExperiencedto){
        return this.jobExperienceService.add(jobExperiencedto);
    }

    @GetMapping("/getAllByResumeIdOrderByStartedAtDesc")
    public DataResult<List<JobExperienceDto>> getAllByResumeIdOrderByStartedAtDesc(int id) {
        return this.jobExperienceService.getAllByResumeIdOrderByStartedAtDesc(id);
    }

    @PostMapping("/update")
   public  Result update(@RequestBody JobExperienceDto jobExperienceDto){
        return this.jobExperienceService.update(jobExperienceDto);
   }
}
