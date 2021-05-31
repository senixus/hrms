package com.hrms.hrms.dataAccess.abstracts;

import com.hrms.hrms.entities.concretes.JobAdvert;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobAdvertDao extends JpaRepository<JobAdvert,Integer> {

    List<JobAdvert> getByIsActiveTrue();

    List<JobAdvert> getByIsActiveTrue(Sort sort);

    List<JobAdvert> getByIsActiveTrueAndEmployerId(int employerId);

}
