package com.hrms.hrms.api.controllers;


import com.hrms.hrms.business.abstracts.GraduateService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Graduate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin

@RestController
@RequestMapping("/api/graduate")
public class GraduateController {

    private GraduateService graduateService;

    @Autowired
    public GraduateController(GraduateService graduateService){
        this.graduateService = graduateService;
    }

    @GetMapping("/getall")
    public DataResult<List<Graduate>> getAll(){
        return this.graduateService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Graduate graduate){
        return this.graduateService.add(graduate);
    }


}
