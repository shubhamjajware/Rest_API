package com.api.dao;

import java.util.List;

import com.api.beans.Employee;

public interface EmployeeDao {
	List<Employee> getAllEmployee();
	Employee getEmployee(int id);
	Employee createEmployee(Employee employee);
	Employee updateEmployee(Employee employee);
	boolean deleteEmployee(int id);
}
