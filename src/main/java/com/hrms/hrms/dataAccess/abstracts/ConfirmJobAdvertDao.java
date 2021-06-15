package com.hrms.hrms.dataAccess.abstracts;

import com.hrms.hrms.entities.concretes.ConfirmJobAdvert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfirmJobAdvertDao extends JpaRepository<ConfirmJobAdvert,Integer> {

   // ConfirmJobAdvert findByEmployerId(int employerId);

    boolean existsById(int id);
}
