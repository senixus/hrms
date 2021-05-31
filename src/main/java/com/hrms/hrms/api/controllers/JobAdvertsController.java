package com.hrms.hrms.api.controllers;

import com.hrms.hrms.business.abstracts.JobAdvertService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.JobAdvert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job-adverts")
public class JobAdvertsController {

    private JobAdvertService jobAdvertService;


    public JobAdvertsController (JobAdvertService jobAdvertService){
        this.jobAdvertService = jobAdvertService;
    }

    @GetMapping("/getByIsActiveTrue")
    public DataResult<List<JobAdvert>> getByIsActiveTrue(){
        return  this.jobAdvertService.getByIsActiveTrue();
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobAdvert jobAdvert){
        return this.jobAdvertService.add(jobAdvert);
    }

    @PostMapping("/getByIsActiveTrueAndEmployerId")
    public DataResult<List<JobAdvert>> getByIsActiveTrueAndEmployerId(@RequestParam int employerId){
        return  this.jobAdvertService.getByIsActiveTrueAndEmployerId(employerId);
    }

    @GetMapping("/getAllByCreatedAt")
    public DataResult<List<JobAdvert>> getAllByCreatedAt() {
        return  this.jobAdvertService.getAllByCreatedAt();
    }

    @PostMapping("/update")
    public Result update(@RequestParam int id,@RequestParam boolean isActive) {
        return  this.jobAdvertService.update(id,isActive);
    }

}
