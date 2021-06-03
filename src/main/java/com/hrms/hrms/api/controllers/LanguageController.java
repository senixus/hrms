package com.hrms.hrms.api.controllers;


import com.hrms.hrms.business.abstracts.LanguageService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/language")
public class LanguageController {

    private LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService){
        this.languageService = languageService;
    }

    @GetMapping("/getall")
    public DataResult<List<Language>> getAll(){
        return this.languageService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Language language){
        return this.languageService.add(language);
    }

}
