package com.hrms.hrms.dataAccess.abstracts;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.entities.concretes.JobAdvert;
import com.hrms.hrms.entities.dtos.JobAdvertDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobAdvertDao extends JpaRepository<JobAdvert,Integer> {

    List<JobAdvert> getByIsActiveTrue();

    List<JobAdvert> getByIsActiveTrueOrderByCreatedAtDesc();

    List<JobAdvert> getByIsActiveTrueAndEmployerId(int employerId);

    List<JobAdvert> getByIsActiveFalseAndEmployerId(int employerId);

    List<JobAdvert> getByIsConfirmTrueAndEmployerId(int employerId);

    List<JobAdvert> getByIsConfirmTrueAndIsActiveTrueAndEmployerId(int employerId);

    List<JobAdvert> getJobAdvertById(int id);

    boolean existsById(int id);

    List<JobAdvert> getByIsConfirmFalseAndIsActiveTrue();

    List<JobAdvert> getByIsConfirmTrueAndIsActiveTrueOrderByCreatedAtDesc(Pageable pageable);

    List<JobAdvert> getByIsConfirmFalseAndIsActiveTrueAndEmployerId(int employerId);

}
