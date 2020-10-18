package com.vjsb.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vjsb.project.dao.EmployeeDAO;
import com.vjsb.project.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	// need to inject Customer dao
	@Autowired
	private EmployeeDAO employeeDao;
	
	@Override
	@Transactional
	public List<Employee> getEmployee() {
		return employeeDao.getEmployee();
	}

	@Override
	@Transactional
	public void saveEmployee(Employee theEmployee) {

		employeeDao.saveEmployee(theEmployee);
	}

	@Override
	@Transactional
	public Employee getEmployee(int theId) {
		
		return employeeDao.getEmployee(theId);
	}
	
	@Override
	@Transactional
	public void deleteEmployee(int theId) {
		
		employeeDao.deleteEmployee(theId);
	}
}
