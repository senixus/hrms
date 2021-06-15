package com.hrms.hrms.dataAccess.abstracts;

import com.hrms.hrms.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerDao extends JpaRepository<Employer,Integer> {

    Employer getById(int employerId);

    boolean existsById(int id);
}
