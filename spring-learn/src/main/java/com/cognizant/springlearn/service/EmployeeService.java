package com.cognizant.springlearn.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Employee;
import com.cognizant.springlearn.dao.EmployeeDao;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;

	public EmployeeService(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}

	public ArrayList<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}
	
	public Employee updateEmployee(Employee employee) throws EmployeeNotFoundException {
		return employeeDao.updateEmployee(employee);
	}
	
	public void deleteEmployee(int id) throws EmployeeNotFoundException {
		employeeDao.deleteEmployee(id);
	}
}
