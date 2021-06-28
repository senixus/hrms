package com.hrms.hrms.dataAccess.abstracts;

import com.hrms.hrms.entities.concretes.Education;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationDao extends JpaRepository<Education,Integer> {
    List<Education> getAllByResumeIdOrderByStartedAtDesc(int id);

    boolean existsById(int id);
}
