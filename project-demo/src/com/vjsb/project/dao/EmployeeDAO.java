package com.vjsb.project.dao;

import java.util.List;

import com.vjsb.project.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> getEmployee();
	
	public void saveEmployee(Employee theEmployee);

	public Employee getEmployee(int theId);

	void deleteEmployee(int theId);
	
}
