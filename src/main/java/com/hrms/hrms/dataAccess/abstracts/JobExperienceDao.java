package com.hrms.hrms.dataAccess.abstracts;

import com.hrms.hrms.entities.concretes.JobExperience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobExperienceDao extends JpaRepository<JobExperience,Integer> {
    List<JobExperience> getAllByResumeIdOrderByStartedAtDesc(int id);

    boolean existsById(int id);
}
