package com.hrms.hrms.business.concretes;

import com.hrms.hrms.business.abstracts.LanguageService;
import com.hrms.hrms.core.utilities.dtoConverter.DtoConverterService;
import com.hrms.hrms.core.utilities.results.*;
import com.hrms.hrms.dataAccess.abstracts.LanguageDao;
import com.hrms.hrms.entities.concretes.Language;

import com.hrms.hrms.entities.dtos.LanguageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageManager implements LanguageService {

    private LanguageDao languageDao;
    private DtoConverterService dtoConverterService;

    @Autowired
    public LanguageManager(LanguageDao languageDao,DtoConverterService dtoConverterService){
        this.languageDao = languageDao;
        this.dtoConverterService = dtoConverterService;
    }

    @Override
    public Result add(LanguageDto languageDto) {
        this.languageDao.save((Language) this.dtoConverterService.dtoClassConverter(languageDto, Language.class));
        return new SuccessResult("Added");
    }

    @Override
    public DataResult<List<LanguageDto>> getAll() {
        return new SuccessDataResult<List<LanguageDto>>
                (this.dtoConverterService.dtoConverter(this.languageDao.findAll(),LanguageDto.class)
                        ,"Languages have been listed");
    }

    @Override
    public Result update(LanguageDto languageDto) {
        if(!this.languageDao.existsById(languageDto.getId())){
            return new ErrorResult("Language have not found");
        }

        this.languageDao.save((Language) this.dtoConverterService.dtoClassConverter(languageDto,Language.class));

        return new SuccessResult("Language have been updated");
    }
}
