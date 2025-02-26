package com.springboot.projects.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.projects.entity.Employee;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
    Employee findByEmail(String email);
	public boolean existsByEmail(String email);
}
