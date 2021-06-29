package com.hrms.hrms.core.dataAccess;

import com.hrms.hrms.core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
    boolean existsByEmail(String email);

    boolean existsById(int id);
}
