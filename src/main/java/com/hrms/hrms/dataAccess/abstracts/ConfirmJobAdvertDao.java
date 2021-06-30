package com.hrms.hrms.dataAccess.abstracts;

import com.hrms.hrms.entities.concretes.ConfirmJobAdvert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfirmJobAdvertDao extends JpaRepository<ConfirmJobAdvert,Integer> {

      boolean existsById(int id);

}
