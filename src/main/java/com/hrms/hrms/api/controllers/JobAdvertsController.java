package com.hrms.hrms.api.controllers;

import com.hrms.hrms.business.abstracts.JobAdvertService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.JobAdvert;
import com.hrms.hrms.entities.dtos.JobAdvertAddDto;
import com.hrms.hrms.entities.dtos.JobAdvertDto;
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
    public DataResult<List<JobAdvertDto>> getByIsActiveTrue(){
        return  this.jobAdvertService.getByIsActiveTrue();
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobAdvertAddDto jobAdvertAddDto){

        return this.jobAdvertService.add(jobAdvertAddDto);
    }

    @PostMapping("/getByIsActiveTrueAndEmployerId")
    public DataResult<List<JobAdvertDto>> getByIsActiveTrueAndEmployerId(@RequestParam int employerId){
        return  this.jobAdvertService.getByIsActiveTrueAndEmployerId(employerId);
    }

    @GetMapping("/getAllByCreatedAt")
    public DataResult<List<JobAdvertDto>> getAllByCreatedAt() {
        return  this.jobAdvertService.getAllByCreatedAt();
    }

    @PostMapping("/update")
    public Result update(@RequestParam int id,@RequestParam boolean isActive) {
        return  this.jobAdvertService.update(id,isActive);
    }

}
