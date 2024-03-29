package com.nemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nemo.model.Employee;
import com.nemo.model.User;

@CrossOrigin(origins="http://localhost:4200",methods = {RequestMethod.DELETE,RequestMethod.POST,
		RequestMethod.GET,RequestMethod.OPTIONS})

@RestController
public class TestController {
	
	List<Employee> employees = createList();
	
	@GetMapping("/validateLogin")
	public @ResponseBody User validateLogin() {
		return new User("User successfully authenticated");
	}
	
//	@GetMapping(produces = "application/json")
//	@RequestMapping({ "/validateLogin" })
//	public User validateLogin() {
//		return new User("User successfully authenticated");
//	}
	
	@GetMapping("/employees")
	public List<Employee>  firstPage(){
		return employees;
	}
	
	@DeleteMapping("/employees/delete/{id}")
	public Employee delete(@PathVariable String id) {
		Employee deletedEmp=null;
		for(Employee emp : employees) {
			if(emp.getEmpId().equals(id)) {
				deletedEmp = emp;
				employees.remove(emp);
				break;
			}
		}
		
		return deletedEmp;
	}
	
	@PostMapping("/employees/add")
	public Employee add(@RequestBody Employee emp) {
		employees.add(emp);
		return emp;
	}
	
	private static List<Employee> createList() {
		List<Employee> tempEmployees = new ArrayList<>();
		
		Employee emp1 = new Employee();
		emp1.setName("emp1");
		emp1.setDesignation("manager");
		emp1.setEmpId("1");
		emp1.setSalary(3000);

		Employee emp2 = new Employee();
		emp2.setName("emp2");
		emp2.setDesignation("developer");
		emp2.setEmpId("2");
		emp2.setSalary(3000);
		tempEmployees.add(emp1);
		tempEmployees.add(emp2);
		return tempEmployees;
	}

}
