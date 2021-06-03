package com.hrms.hrms.dataAccess.abstracts;

import com.hrms.hrms.entities.concretes.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologyDao extends JpaRepository<Technology,Integer> {
}
