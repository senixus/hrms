package com.hrms.hrms.dataAccess.abstracts;

import com.hrms.hrms.entities.concretes.EmployerUpdate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerUpdateDao extends JpaRepository<EmployerUpdate,Integer> {

    boolean existsById(int id);

}
