package com.hrms.hrms.dataAccess.abstracts;

import com.hrms.hrms.entities.concretes.Graduate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GraduateDao extends JpaRepository<Graduate,Integer> {
}
