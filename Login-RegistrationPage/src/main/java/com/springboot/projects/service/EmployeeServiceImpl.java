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
	public String loginEmployee(LoginEmployee loginemp) {
		Employee employee = employeeRepo.findByEmail(loginemp.getEmail());
		if (employee != null && employee.getPassword().equals(loginemp.getPassword())) {
			return "success";
		} else {
			return "failure";
		}

	}

	@Override
	public Employee registerEmployee(Employee employee) {
		if (employeeRepo.existsByEmail(employee.getEmail())) {
			return null;
		}
		return employeeRepo.save(employee);

	}

	@Override
	public boolean existEmailCheck(String email) {
		return employeeRepo.existsByEmail(email);
	}

}
