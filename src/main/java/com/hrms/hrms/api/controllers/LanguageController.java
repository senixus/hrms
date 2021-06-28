package com.hrms.hrms.api.controllers;


import com.hrms.hrms.business.abstracts.LanguageService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;

import com.hrms.hrms.entities.dtos.LanguageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin

@RestController
@RequestMapping("/api/language")
public class LanguageController {

    private LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService){
        this.languageService = languageService;
    }

    @GetMapping("/getall")
    public DataResult<List<LanguageDto>> getAll(){
        return this.languageService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody LanguageDto languageDto){
        return this.languageService.add(languageDto);
    }

    @PostMapping("/update")
    public Result update(@RequestBody LanguageDto languageDto){
        return this.languageService.update(languageDto);
    }

}
