package com.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.beans.Employee;
import com.api.beans.Response;
import com.api.services.EmployeeService;

@RestController
@RequestMapping(value = "/company")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@GetMapping(value = "/employees")
	public Response getAllEmployee(){
		return employeeService.getAllEmployee();
	}
	@GetMapping(value = "/employees/{id}")
	public Response getEmployee(@PathVariable("id") int id){
		return employeeService.getEmployee(id);
	}
	@PostMapping(value = "/employees")
	public Response createEmployee(@RequestBody Employee employee){
		return employeeService.createEmployee(employee);
	}
	@PutMapping(value = "/employees")
	public Response updateEmployee(@RequestBody Employee employee){
		return employeeService.updateEmployee(employee);
	}
	@DeleteMapping(value = "/employees/{id}")
	public Response deleteEmployee(@PathVariable("id") int id){
		return employeeService.deleteEmployee(id);
	}
}
