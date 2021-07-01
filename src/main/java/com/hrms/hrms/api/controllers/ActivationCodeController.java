package com.hrms.hrms.api.controllers;

import com.hrms.hrms.business.abstracts.ActivationCodeService;
import com.hrms.hrms.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/activationCode")
public class ActivationCodeController {

    private ActivationCodeService activationCodeService;


    @Autowired
    public ActivationCodeController(ActivationCodeService activationCodeService){
        this.activationCodeService = activationCodeService;
    }

    @PostMapping("/{activationCode}")
    public Result update(@PathVariable("activationCode") String activationCode){
        return this.activationCodeService.confirmUser(activationCode);
    }


}
