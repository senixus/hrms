package com.hrms.hrms.dataAccess.abstracts;

import com.hrms.hrms.entities.concretes.Resume;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResumeDao extends JpaRepository<Resume,Integer> {

    List<Resume> getAllResumeByCandidateId(int id);



    boolean existsById(int resumeId);
}
