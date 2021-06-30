package com.hrms.hrms.dataAccess.abstracts;

import com.hrms.hrms.entities.concretes.JobAdvert;
import com.hrms.hrms.entities.dtos.JobAdvertFilterDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    @Query("Select j from  com.hrms.hrms.entities.concretes.JobAdvert j where ((:#{#filter.cityId}) IS NULL OR j.city.id IN (:#{#filter.cityId}))"
            +" and ((:#{#filter.jobTitleId}) IS NULL OR j.jobTitle.id IN (:#{#filter.jobTitleId}))"
            +" and ((:#{#filter.workPlaceId}) IS NULL OR j.workPlace.id IN (:#{#filter.workPlaceId}))"
            +" and ((:#{#filter.workTimeId}) IS NULL OR j.workTime.id IN (:#{#filter.workTimeId}))"
            +" and j.isActive=true")
    public Page<JobAdvert> getByFilter(@Param("filter") JobAdvertFilterDto jobAdvertFilterDto, Pageable pageable);


}
