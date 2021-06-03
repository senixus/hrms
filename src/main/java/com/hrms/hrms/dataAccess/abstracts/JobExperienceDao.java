package com.hrms.hrms.dataAccess.abstracts;

import com.hrms.hrms.entities.concretes.JobExperience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobExperienceDao extends JpaRepository<JobExperience,Integer> {
}
