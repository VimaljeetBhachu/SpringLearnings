package com.vjsb.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vjsb.project.entity.Employee;
import com.vjsb.project.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	// need to inject the customer dao
	@Autowired
	private EmployeeService employeeService;
		
	@GetMapping("/list")
	public String listEmployee(Model theModel) {
		// get customers from the dao
		List<Employee> theEmployee = employeeService.getEmployee();
						
		// add the customers to the model
		theModel.addAttribute("employee", theEmployee);
				
		return "list-employee";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Employee theEmployee = new Employee();
		
		theModel.addAttribute("employee", theEmployee);
		
		return "employee-form";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		 
		// save the employee using our service
		employeeService.saveEmployee(theEmployee);
		
		return "redirect:/employee/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId,
									Model theModel) {
		
		// get the customer from our service
		Employee theEmployee = employeeService.getEmployee(theId);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("employee", theEmployee);
		
		// send over to our form		
		return "employee-form-edit";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") int theId) {
		
		// delete the customer
		employeeService.deleteEmployee(theId);
		
		return "redirect:/employee/list";
	}
}
