package com.hrms.hrms.api.controllers;


import com.hrms.hrms.business.abstracts.TechnologyService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technology")
public class TechnologyController {

    private TechnologyService technologyService;

    @Autowired
    public TechnologyController(TechnologyService technologyService){
        this.technologyService = technologyService;
    }

    @GetMapping("/getall")
    public DataResult<List<Technology>> getAll(){
        return this.technologyService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Technology technology){
        return this.technologyService.add(technology);
    }



}
