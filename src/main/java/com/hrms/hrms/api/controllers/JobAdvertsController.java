package com.hrms.hrms.api.controllers;

import com.hrms.hrms.business.abstracts.JobAdvertService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.JobAdvert;
import com.hrms.hrms.entities.dtos.JobAdvertAddDto;
import com.hrms.hrms.entities.dtos.JobAdvertDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin

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

    @GetMapping("/getByIsActiveTrueOrderByCreatedAtDesc")
    public DataResult<List<JobAdvertDto>> getByIsActiveTrueOrderByCreatedAtDesc() {
        return  this.jobAdvertService.getByIsActiveTrueOrderByCreatedAtDesc();
    }

    @PostMapping("/update")
    public Result update(@RequestParam int id,@RequestParam boolean isActive) {
        return  this.jobAdvertService.update(id,isActive);
    }

    @GetMapping("/getJobAdvertById")
    public DataResult<List<JobAdvertDto>> getJobAdvertById(@RequestParam int id) {
        return this.jobAdvertService.getJobAdvertById(id);
    }

    @GetMapping("/confirmJobAdvert")
    public Result confirmJobAdvert(@RequestParam int id){
        return this.jobAdvertService.confirmJobAdvert(id);
    }


    @GetMapping("/getByIsConfirmTrueAndEmployerId")
    public DataResult<List<JobAdvertDto>> getByIsConfirmTrueAndEmployerId(@RequestParam int employerId) {
        return this.jobAdvertService.getByIsConfirmTrueAndEmployerId(employerId);
    }

    @GetMapping("/getByIsActiveFalseAndEmployerId")
    public DataResult<List<JobAdvertDto>> getByIsActiveFalseAndEmployerId(@RequestParam int employerId) {
        return this.jobAdvertService.getByIsActiveFalseAndEmployerId(employerId);
    }

    @GetMapping("/getByIsConfirmTrueAndIsActiveTrueAndEmployerId")
    public DataResult<List<JobAdvertDto>> getByIsConfirmTrueAndIsActiveTrueAndEmployerId(@RequestParam int employerId) {
        return this.jobAdvertService.getByIsConfirmTrueAndIsActiveTrueAndEmployerId(employerId);
    }

    @GetMapping("/getByIsConfirmFalseAndIsActiveTrueAndEmployerId")
    public DataResult<List<JobAdvertDto>> getByIsConfirmFalseAndIsActiveTrueAndEmployerId(@RequestParam int employerId) {
        return this.jobAdvertService.getByIsConfirmFalseAndIsActiveTrueAndEmployerId(employerId);
    }

    @GetMapping("/getByIsConfirmFalseAndIsActiveTrue")
    public DataResult<List<JobAdvertDto>> getByIsConfirmFalseAndIsActiveTrue() {
        return this.jobAdvertService.getByIsConfirmFalseAndIsActiveTrue();
    }

    @GetMapping("/getByIsConfirmTrueAndIsActiveTrueOrderByCreatedAtDesc")
    public DataResult<List<JobAdvertDto>> getByIsConfirmTrueAndIsActiveTrueOrderByCreatedAtDesc(int pageNo,int pageSize) {
        return this.jobAdvertService.getByIsConfirmTrueAndIsActiveTrueOrderByCreatedAtDesc(pageNo,pageSize);
    }

}
