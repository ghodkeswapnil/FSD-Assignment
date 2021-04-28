package com.app.project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao{
	
	private static Statement statement = null;
    private Connection conn;

    public EmployeeDaoImpl() throws SQLException {
        conn = ConnectionFactory.getConnection();
        statement = conn.createStatement();
    }

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
		String add = "insert into employeedata values ("+employee.getEmpId()+" , '"+employee.getName()+"', '"+employee.getEmail()+"')";
        int count =0;
        try {
			count = statement.executeUpdate(add);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if(count>0)
        	System.out.println("Employee added");
 
        else
        	System.out.println("not done");
        
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		String update = "update employeedata set name='"+employee.getName()+"',email='"+employee.getEmail()+"' where empId="+employee.getEmpId();
    	int count =0;
		try {
			count = statement.executeUpdate(update);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(count>0)
			System.out.println("Reocrd updated succesfully");
		else
			System.out.println("Not updated");
		
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		String dlt = "delete from employeedata  where empId="+id;
    	int count =0;
		try {
			count = statement.executeUpdate(dlt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(count>0)
			System.out.println("Reocrd deleted succesfully");
		else
			System.out.println("Not deleted");
		
	}
		
	

	@Override
	public Employee getEmployeeById(int empId) {
		// TODO Auto-generated method stub
		
		Employee employee= null;
		String sql = "select * from employee where id = "+ empId;
        ResultSet rs;
		try {
			rs = statement.executeQuery(sql);
			if(rs.next()){
	            int empId1 = rs.getInt("id");
	            String name = rs.getString("name");
	            String email = rs.getString("email");
	            employee = new Employee(empId, name, email);
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return employee;
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		List<Employee> list= new ArrayList<>();
		String getEmp = "select * from employeedata";
		try {
			ResultSet rs=statement.executeQuery(getEmp);
			while(rs.next()) {
				int id = rs.getInt("empId");
				String ename = rs.getString("name");
				String eid = rs.getString("email");
                
				Employee employee = new Employee(id,ename,eid);
				list.add(employee);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return list;
	}

}
