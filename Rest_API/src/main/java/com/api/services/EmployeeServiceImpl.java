package com.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.api.beans.Employee;
import com.api.beans.Response;
import com.api.dao.EmployeeDao;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;
	
	@Override
	public Response getAllEmployee() {
		Response response = null;
		List<Employee> empList = employeeDao.getAllEmployee();
		if(CollectionUtils.isEmpty(empList))
			response = new Response(200, "There is no employee in List", empList);
		else
			response = new Response(200, "Successfully fetch all employees", empList);
		return response;
	}

	@Override
	public Response getEmployee(int id) {
		Response response = null;
		Employee emp =  employeeDao.getEmployee(id);
		if(emp == null)
			response = new Response(200, "Employee does not exist with id " + id, null);
		else {
			List<Employee> empList = new ArrayList<>();
			empList.add(emp);
			response = new Response(200, "Successfully fetch employee for id " + id, empList);
		}
		return response;
	}

	@Override
	public Response createEmployee(Employee employee) {
		Response response = null;
		Employee emp =  employeeDao.createEmployee(employee);
		if(emp == null)
			response = new Response(500, "Internal Server Error", null);
		else {
			List<Employee> empList = new ArrayList<>();
			empList.add(emp);
			response = new Response(200, "Successfully created employee for id " + employee.getId(), empList);
		}
		return response;
	}

	@Override
	public Response updateEmployee(Employee employee) {
		Response response = null;
		Employee emp =  employeeDao.updateEmployee(employee);
		if(emp == null)
			response = new Response(400, "Employee does not exist with id " + employee.getId(), null);
		else {
			List<Employee> empList = new ArrayList<>();
			empList.add(emp);
			response = new Response(201, "Successfully updated employee for id " + employee.getId(), empList);
		}
		return response;
	}

	@Override
	public Response deleteEmployee(int id) {
		Response response = null;
		Employee emp =  employeeDao.getEmployee(id);
		if(emp == null)
			response = new Response(400, "Employee does not exist with id " + id, null);
		else {
			List<Employee> empList = new ArrayList<>();
			empList.add(emp);
			response = new Response(200, "Successfully deleted employee for id " + id, empList);
		}
		return response;
	}

}
