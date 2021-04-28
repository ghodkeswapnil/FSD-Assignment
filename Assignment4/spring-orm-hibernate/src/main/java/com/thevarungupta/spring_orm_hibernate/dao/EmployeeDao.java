package com.thevarungupta.spring_orm_hibernate.dao;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;
import java.util.*;

import com.thevarungupta.spring_orm_hibernate.entities.Employee;

public class EmployeeDao {

	
	private HibernateTemplate hibernateTemplate;
	
	// insert employee
	@Transactional
	public int addEmployee(Employee employee) {
		Integer rows = (Integer)hibernateTemplate.save(employee);
		return rows;
	}

	public Employee getEmployeeId(int EmployeeId) {
		Employee employee = this.hibernateTemplate.get(Employee.class, EmployeeId);
		return employee;
	}
	
	public List<Employee> getAllEmployee(){
		List<Employee> employee = this.hibernateTemplate.loadAll(Employee.class);
		return employee;
	}
	@Transactional
	public void deleteEmployee(int EmployeeId) {
		Employee employee = this.hibernateTemplate.get(Employee.class, EmployeeId);
		this.hibernateTemplate.delete(employee);
		
	}
	@Transactional
	public void updateEmployee(Employee employee) {
	this.hibernateTemplate.update(employee);
	}
	
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	
}
