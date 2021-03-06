package com.hrms.hrms.api.controllers;


import com.hrms.hrms.business.abstracts.ResumeService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Resume;
import com.hrms.hrms.entities.dtos.ResumeAddDto;
import com.hrms.hrms.entities.dtos.ResumeGetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin

@RestController
@RequestMapping("/api/resume")
public class ResumeController {

    private ResumeService resumeService;

    @Autowired
    public ResumeController(ResumeService resumeService){
        this.resumeService = resumeService;
    }

    @GetMapping("/getall")
    public DataResult<List<ResumeGetDto>> getAll(){
        return  this.resumeService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody ResumeAddDto resumeAddDto){
        return this.resumeService.add(resumeAddDto);
    }


    @PutMapping("/uploadImage")
    public Result saveImage(@RequestBody MultipartFile file, @RequestParam int resumeId) {
        return this.resumeService.saveImage(file, resumeId);

    }

    @GetMapping("/getAllResumeByCandidateId")
    public DataResult<List<ResumeGetDto>> getAllResumeByCandidateId(@RequestParam int id) {
        return this.resumeService.getAllResumeByCandidateId(id);
    }

    @GetMapping("/getByResumeId")
    public DataResult<Resume> getByResumeId(int id) {
        return this.resumeService.getByResumeId(id);

    }

}
