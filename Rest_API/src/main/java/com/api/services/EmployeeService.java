package com.api.services;

import com.api.beans.Employee;
import com.api.beans.Response;

public interface EmployeeService {
	Response getAllEmployee();
	Response getEmployee(int id);
	Response createEmployee(Employee employee);
	Response updateEmployee(Employee employee);
	Response deleteEmployee(int id);

}
