package com.hrms.hrms.business.abstracts;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.entities.concretes.City;


import java.util.List;

public interface CityService {

    DataResult<List<City>> getAll();

}
