package com.hrms.hrms.business.concretes;

import com.hrms.hrms.business.abstracts.LanguageService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.LanguageDao;
import com.hrms.hrms.entities.concretes.Language;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageManager implements LanguageService {

    private LanguageDao languageDao;

    @Autowired
    public LanguageManager(LanguageDao languageDao){
        this.languageDao = languageDao;
    }

    @Override
    public Result add(Language language) {
        this.languageDao.save(language);
        return new SuccessResult("Added");
    }

    @Override
    public DataResult<List<Language>> getAll() {
        return new SuccessDataResult<List<Language>>(this.languageDao.findAll(),"Languages have been listed");
    }
}
