package com.hrms.hrms.business.concretes;

import com.hrms.hrms.business.abstracts.ResumeService;
import com.hrms.hrms.core.utilities.cloudinary.CloudinaryService;
import com.hrms.hrms.core.utilities.dtoConverter.DtoConverterService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.ResumeDao;
import com.hrms.hrms.entities.concretes.Resume;
import com.hrms.hrms.entities.dtos.ResumeAddDto;
import com.hrms.hrms.entities.dtos.ResumeGetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public class ResumeManager implements ResumeService {

    private ResumeDao resumeDao;
    private CloudinaryService cloudinaryService;
    private DtoConverterService dtoConverterService;

    @Autowired
    public ResumeManager(ResumeDao resumeDao,CloudinaryService cloudinaryService,DtoConverterService dtoConverterService){
        this.resumeDao = resumeDao;
        this.cloudinaryService = cloudinaryService;
        this.dtoConverterService = dtoConverterService;
    }

    @Override
    public Result add(ResumeAddDto resumeAddDto) {
        this.resumeDao.save((Resume) this.dtoConverterService.dtoClassConverter(resumeAddDto,Resume.class));
        return new SuccessResult("Added");
    }

    @Override
    public DataResult<List<ResumeGetDto>> getAll() {
        return new SuccessDataResult<List<ResumeGetDto>>
                (this.dtoConverterService.dtoConverter(this.resumeDao.findAll(),ResumeGetDto.class)
                        ,"Resumes have been listed");
    }

    @Override
    public Result saveImage(MultipartFile file, int resumeId) {
        Map<String,String> uploader =  (Map<String,String>) this.cloudinaryService.save(file).getData();

        String imageUrl = uploader.get("url");

        Resume resume = this.resumeDao.getById(resumeId);
        resume.setPhoto(imageUrl);
        this.resumeDao.save(resume);

        return new SuccessResult("Kayıt başarılı");
    }


}
