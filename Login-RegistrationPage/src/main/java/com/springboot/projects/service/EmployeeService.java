package com.springboot.projects.service;

import com.springboot.projects.dto.LoginEmployee;
import com.springboot.projects.entity.Employee;



public interface EmployeeService {

	Employee registerEmployee(Employee employee);

	String loginEmployee(LoginEmployee loginDTO);

	boolean existEmailCheck(String email);
}
