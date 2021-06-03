package com.hrms.hrms.business.abstracts;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Graduate;
import com.hrms.hrms.entities.concretes.Language;

import java.util.List;

public interface LanguageService {

    Result add(Language language);

    DataResult<List<Language>> getAll();
}
