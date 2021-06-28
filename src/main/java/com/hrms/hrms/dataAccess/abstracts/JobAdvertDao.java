package com.hrms.hrms.dataAccess.abstracts;

import com.hrms.hrms.entities.concretes.JobAdvert;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobAdvertDao extends JpaRepository<JobAdvert,Integer> {

    List<JobAdvert> getByIsActiveTrue();

    List<JobAdvert> getByIsActiveTrueOrderByCreatedAtDesc(Pageable pageable);

    List<JobAdvert> getByIsActiveTrueAndEmployerId(Pageable pageable,int employerId);

    List<JobAdvert> getByIsActiveFalseAndEmployerId(Pageable pageable,int employerId);

    List<JobAdvert> getByIsConfirmTrueAndEmployerId(int employerId);

    List<JobAdvert> getByIsConfirmTrueAndIsActiveTrueAndEmployerId(Pageable pageable,int employerId);

    List<JobAdvert> getJobAdvertById(int id);

    boolean existsById(int id);

    List<JobAdvert> getByIsConfirmFalseAndIsActiveTrue(Pageable pageable);

    List<JobAdvert> getByIsConfirmTrueAndWorkTimeIdAndWorkPlaceIdAndCityId(Pageable pageable,int workTimeId,int workPlaceId,int cityId);

    List<JobAdvert> getByIsConfirmFalseAndIsActiveTrueAndEmployerId(Pageable pageable,int employerId);


}
