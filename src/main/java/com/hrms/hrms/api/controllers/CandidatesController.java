package com.hrms.hrms.api.controllers;

import com.hrms.hrms.business.abstracts.CandidateService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin

@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {
    private CandidateService candidateService;

    @Autowired
    public CandidatesController(CandidateService candidateService){
        this.candidateService = candidateService;
    }

    @GetMapping("/getall")
    public DataResult<List<Candidate>> getAll(){
        return this.candidateService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Candidate candidate){
        return this.candidateService.add(candidate);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Candidate candidate){
        return this.candidateService.update(candidate);
    }

}
