package com.hrms.hrms.dataAccess.abstracts;

import com.hrms.hrms.entities.concretes.ConfirmEmployer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfirmEmployerDao extends JpaRepository<ConfirmEmployer,Integer> {
    ConfirmEmployer getByEmployerId(int id);
}
