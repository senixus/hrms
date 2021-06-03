package com.hrms.hrms.api.controllers;


import com.hrms.hrms.business.abstracts.ResumeService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/resume")
public class ResumeController {

    private ResumeService resumeService;

    @Autowired
    public ResumeController(ResumeService resumeService){
        this.resumeService = resumeService;
    }

    @GetMapping("/getall")
    public DataResult<List<Resume>> getAll(){
        return  this.resumeService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Resume resume){
        return this.resumeService.add(resume);
    }


    @PutMapping("/uploadImage")
    public Result saveImage(@RequestBody MultipartFile file, @RequestParam int resumeId) {
        return this.resumeService.saveImage(file, resumeId);

    }

}
