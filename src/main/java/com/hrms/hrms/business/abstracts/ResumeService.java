package com.hrms.hrms.business.abstracts;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.dtos.ResumeAddDto;
import com.hrms.hrms.entities.dtos.ResumeGetDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ResumeService {

    Result add(ResumeAddDto resumeAddDto);

    DataResult<List<ResumeGetDto>> getAll();

    Result saveImage(MultipartFile file, int resumeId);
}
