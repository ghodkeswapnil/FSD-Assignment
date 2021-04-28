package com.app.project;

import java.util.List;

public interface EmployeeDao {
	
	void addEmployee(Employee employee);
	void updateEmployee(Employee employee);
	void deleteEmployee(int id);
	
	Employee getEmployeeById(int empId);
	List<Employee> getEmployees();

}
