package com.app.project;

import java.sql.SQLException;

import java.util.*;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		//EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
       // Employee employee = new Employee(1, "khatija", "khatija@gmail.com");
//		Scanner scan = new Scanner(System.in);
//		System.out.println("insert your employee record");
//		System.out.println("enter employee id:");
//		int id = scan.nextInt();
//		System.out.println("Enter employee name");
//		String ename = scan.next();
//		System.out.println("Enter employee emailId");
//		String eid= scan.next();
//		
//	Employee employee = new Employee(id,ename,eid);
//		
		EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
		Scanner scan = new Scanner(System.in);
		System.out.println("Select one option...");
		System.out.println("*************************");
		System.out.println("Press 1 for insertion");
		System.out.println("Press 2 for updation");
		System.out.println("Press 3 for Delete");
		System.out.println("Press 4 for getRecord");
		System.out.println("*************************");
		int option = scan.nextInt();
		switch (option) {
		case 1:
			   insertion();
			break;
			
		case 2:
			updation();
			break;
			
		case 3:
			 deletion();
			break;
			
		case 4:
				getRecord();
			break;
		default:
			break;
		}
		
       
	}

	private static void deletion() throws SQLException {
		// TODO Auto-generated method stub
		EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
		Scanner scan = new Scanner(System.in);
		System.out.println("enter id to delete your record");
		int id = scan.nextInt();
		//Employee emp = Employee(id);
		dao.deleteEmployee(id);
		
	}

	private static void updation() throws SQLException {
		// TODO Auto-generated method stub1
		EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
		Scanner scan = new Scanner(System.in);
		System.out.println("Update your records");
		System.out.println("Enter updated employee name");
		String ename = scan.next();
		System.out.println("Enter  updated employee emailId");
		String eid= scan.next();
		System.out.println("Enter the id to update");
		int id = scan.nextInt();
		
		Employee employee = new Employee(id,ename,eid);
		dao.updateEmployee(employee);
		
		
		
		
	}

	private static void insertion() throws SQLException {
		// TODO Auto-generated method stub
		EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
		Scanner scan = new Scanner(System.in);
		System.out.println("insert your employee record");
		System.out.println("enter employee id:");
		int id = scan.nextInt();
		System.out.println("Enter employee name");
		String ename = scan.next();
		System.out.println("Enter employee emailId");
		String eid= scan.next();
		
	Employee employee = new Employee(id,ename,eid);
	dao.addEmployee(employee);
		
	}

	private static void getRecord() throws SQLException {
		// TODO Auto-generated method stub
		
	    	   EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
	    	   List<Employee>empl= dao.getEmployees();
	           for(Employee emp : empl) {
	        	   
	        	   System.out.println(emp.toString());
	           }
	       

	       }
		
	}


