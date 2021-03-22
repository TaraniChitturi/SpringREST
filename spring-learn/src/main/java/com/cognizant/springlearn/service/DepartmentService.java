package com.cognizant.springlearn.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Department;
import com.cognizant.springlearn.dao.DepartmentDao;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentDao departmentDao;

	public DepartmentService(DepartmentDao departmentDao) {
		super();
		this.departmentDao = departmentDao;
	}

	public ArrayList<Department> getAllDepartments() {
		return departmentDao.getAllDepartments();
	}
}
