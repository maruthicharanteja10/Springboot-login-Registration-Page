package com.springboot.projects.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.projects.dto.LoginEmployee;
import com.springboot.projects.entity.Employee;
import com.springboot.projects.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepo employeeRepo;

	public EmployeeServiceImpl() {

	}

	@Override
	public LoginEmployee loginEmployee(LoginEmployee loginDTO) {
		Employee employee = employeeRepo.findByEmail(loginDTO.getEmail());
		if (employee != null && employee.getPassword().equals(loginDTO.getPassword())) {
			return loginDTO; // Successful login
		}
		return null;

	}

	@Override
	public Employee registerEmployee(Employee employee) {
		return employeeRepo.save(employee);

	}

	@Override
	public boolean existEmailCheck(String email) {
		return employeeRepo.existsByEmail(email);
	}

}
