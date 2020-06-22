package com.api.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.api.beans.Employee;
import com.api.helper.EmployeeHelper;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	private static List<Employee> employeeList = new ArrayList<>();

	@Override
	public List<Employee> getAllEmployee() {
		return employeeList;
	}

	@Override
	public Employee getEmployee(int id) {
		return EmployeeHelper.findEmployee(id, employeeList);
	}

	@Override
	public Employee createEmployee(Employee employee) {
		employee.setId(employeeList.size()+1);
		employeeList.add(employee);
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		if(EmployeeHelper.updateEmployee(employee, employeeList) != null)
			return employee;
		else 
			return null;
	}

	@Override
	public boolean deleteEmployee(int id) {
		return EmployeeHelper.deleteEmployee(id, employeeList);
	}

}
