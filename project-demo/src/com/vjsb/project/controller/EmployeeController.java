package com.vjsb.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vjsb.project.dao.EmployeeDAO;
import com.vjsb.project.entity.Employee;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	// need to inject the customer dao
	@Autowired
	private EmployeeDAO employeeDAO;
		
	@RequestMapping("/list")
	public String listEmployee(Model theModel) {
		// get customers from the dao
		List<Employee> theEmployee = employeeDAO.getEmployee();
						
		// add the customers to the model
		theModel.addAttribute("employee", theEmployee);
				
		return "list-employee";
	}
}
