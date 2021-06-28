package com.hrms.hrms.dataAccess.abstracts;

import com.hrms.hrms.entities.concretes.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageDao extends JpaRepository<Language,Integer> {

    boolean existsById(int id);

}
