package com.hrms.hrms.core.utilities.cloudinary;

import com.hrms.hrms.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryService {
    DataResult<?> save(MultipartFile file);
}
