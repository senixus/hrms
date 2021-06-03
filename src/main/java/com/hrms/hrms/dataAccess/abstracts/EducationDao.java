package com.hrms.hrms.dataAccess.abstracts;

import com.hrms.hrms.entities.concretes.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationDao extends JpaRepository<Education,Integer> {
}
