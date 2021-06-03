package com.hrms.hrms.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.hrms.hrms.core.utilities.cloudinary.CloudinaryManager;
import com.hrms.hrms.core.utilities.cloudinary.CloudinaryService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinaryUser(){
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "humanrms",
                "api_key", "115357398659851",
                "api_secret", "pzK77NN5pZurtYmm01A2n7aen5g"));
    }

    @Bean
    public CloudinaryService cloudinaryService(){
        return new CloudinaryManager(cloudinaryUser());
    }
}
