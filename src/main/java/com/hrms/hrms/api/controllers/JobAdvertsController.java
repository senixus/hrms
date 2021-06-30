package com.hrms.hrms.api.controllers;

import com.hrms.hrms.business.abstracts.JobAdvertService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.JobAdvert;
import com.hrms.hrms.entities.dtos.JobAdvertAddDto;
import com.hrms.hrms.entities.dtos.JobAdvertDto;
import com.hrms.hrms.entities.dtos.JobAdvertFilterDto;
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
    public DataResult<List<JobAdvertDto>> getByIsActiveTrueAndEmployerId(@RequestParam int employerId, @RequestParam int pageNo, @RequestParam int pageSize){
        return  this.jobAdvertService.getByIsActiveTrueAndEmployerId(employerId,pageNo,pageSize);
    }

    @GetMapping("/getByIsActiveTrueOrderByCreatedAtDesc")
    public DataResult<List<JobAdvertDto>> getByIsActiveTrueOrderByCreatedAtDesc(int pageNo,int pageSize) {
        return  this.jobAdvertService.getByIsActiveTrueOrderByCreatedAtDesc(pageNo,pageSize);
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
    public Result confirmJobAdvert(@RequestParam int jobAdvertid,@RequestParam int employeeId){
        return this.jobAdvertService.confirmJobAdvert(jobAdvertid,employeeId);
    }


    @GetMapping("/getByIsConfirmTrueAndEmployerId")
    public DataResult<List<JobAdvertDto>> getByIsConfirmTrueAndEmployerId(@RequestParam int employerId) {
        return this.jobAdvertService.getByIsConfirmTrueAndEmployerId(employerId);
    }

    @GetMapping("/getByIsActiveFalseAndEmployerId")
    public DataResult<List<JobAdvertDto>> getByIsActiveFalseAndEmployerId(@RequestParam int employerId,@RequestParam int pageNo,@RequestParam int pageSize) {
        return this.jobAdvertService.getByIsActiveFalseAndEmployerId(employerId,pageNo,pageSize);
    }

    @GetMapping("/getByIsConfirmTrueAndIsActiveTrueAndEmployerId")
    public DataResult<List<JobAdvertDto>> getByIsConfirmTrueAndIsActiveTrueAndEmployerId(@RequestParam int employerId,@RequestParam int pageNo,@RequestParam int pageSize) {
        return this.jobAdvertService.getByIsConfirmTrueAndIsActiveTrueAndEmployerId(employerId,pageNo,pageSize);
    }

    @GetMapping("/getByIsConfirmFalseAndIsActiveTrueAndEmployerId")
    public DataResult<List<JobAdvertDto>> getByIsConfirmFalseAndIsActiveTrueAndEmployerId(@RequestParam int employerId,@RequestParam int pageNo,@RequestParam int pageSize) {
        return this.jobAdvertService.getByIsConfirmFalseAndIsActiveTrueAndEmployerId(employerId,pageNo,pageSize);
    }

    @GetMapping("/getByIsConfirmFalseAndIsActiveTrue")
    public DataResult<List<JobAdvertDto>> getByIsConfirmFalseAndIsActiveTrue(int pageNo, int pageSize) {
        return this.jobAdvertService.getByIsConfirmFalseAndIsActiveTrue(pageNo,pageSize);
    }


    @PostMapping("/getByFilter")
    public DataResult<List<JobAdvert>> getByFilter(JobAdvertFilterDto jobAdvertFilterDto, @RequestParam int pageNo,@RequestParam  int pageSize) {
        return this.jobAdvertService.getByFilter(jobAdvertFilterDto,pageNo,pageSize);
    }

}
