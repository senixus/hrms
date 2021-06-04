package com.hrms.hrms.business.abstracts;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Graduate;
import com.hrms.hrms.entities.concretes.Resume;
import com.hrms.hrms.entities.dtos.ResumeDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ResumeService {

    Result add(Resume resume);

    DataResult<List<ResumeDto>> getAll();

    Result saveImage(MultipartFile file, int resumeId);
}
