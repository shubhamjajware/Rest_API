package com.api.helper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import com.api.beans.Employee;

public class EmployeeHelper {
	
	private EmployeeHelper() {}

	public static Employee findEmployee(int id, List<Employee> empList) {
		List<Employee> tempEmpl = empList.stream().filter(emp -> emp.getId()==id).collect(Collectors.toList());
		if(CollectionUtils.isEmpty(tempEmpl))
			return null;
		else
			return tempEmpl.get(0);
	}
	public static Employee updateEmployee(Employee emp, List<Employee> empList) {
		if(deleteEmployee(emp.getId(), empList)) {
			empList.add(emp);
			return emp;
		}else {
			return null;
		}
	}
	
	public static boolean deleteEmployee(int id, List<Employee> empList) {
		List<Employee> tempEmpl = empList.stream().filter(emp -> emp.getId()==id).collect(Collectors.toList());
		if(CollectionUtils.isEmpty(tempEmpl))
			return Boolean.FALSE;
		else {
			Employee emp = tempEmpl.get(0);
			empList.remove(emp);
			return Boolean.TRUE;
		}
	}
	
}
