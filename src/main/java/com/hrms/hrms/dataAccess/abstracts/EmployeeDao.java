package com.hrms.hrms.dataAccess.abstracts;

import com.hrms.hrms.entities.concretes.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee,Integer> {

    boolean existsById(int employeeId);
}
