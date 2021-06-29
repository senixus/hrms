package com.hrms.hrms.business.abstracts;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;

import java.util.List;

public interface ValidationService<T> {

    DataResult<List<T>> getAll();

    Result add(T data);

    Result update(T data);

}
