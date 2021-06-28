package com.hrms.hrms.api.controllers;


import com.hrms.hrms.business.abstracts.ConfirmJobAdvertService;
import com.hrms.hrms.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/confirmJobAdverts")
public class ConfirmJobAdvertsController {

    private ConfirmJobAdvertService confirmJobAdvertService;

    @Autowired
    public ConfirmJobAdvertsController(ConfirmJobAdvertService confirmJobAdvertService){
        this.confirmJobAdvertService = confirmJobAdvertService;
    }

    @GetMapping("/confirmJobAdvert")
    public Result confirmJobAdvert(@RequestParam int jobAdvertId, @RequestParam int employeeId) {
        return this.confirmJobAdvertService.confirmJobAdvert(jobAdvertId,employeeId);
    }


}
