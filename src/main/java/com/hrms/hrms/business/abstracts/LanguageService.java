package com.hrms.hrms.business.abstracts;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.dtos.LanguageDto;

import java.util.List;

public interface LanguageService {

    Result add(LanguageDto languageDto);

    DataResult<List<LanguageDto>> getAll();
}
