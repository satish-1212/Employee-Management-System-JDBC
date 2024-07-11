package com.tap.dao;
import com.tap.models.Employee;
//import java.util.List;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
//import java.sql.Statement;
import java.sql.PreparedStatement;
//import java.util.Scanner;
//import java.sql.ResultSet;
//import java.util.ArrayList;



public class EmployeeBoImp implements EmployeeBO {
	private static  Connection connection =null;
	private static  PreparedStatement prepareStatement  = null;
	//private static Statement statement;
	//private static ResultSet res;
	
	
	private final static  String Insert_Query ="Insert into employees (id,name,email,department,salary) values(?,?,?,?,?)";
	private static final String UPDATE_QUERY = "update employees set name = ?,email =? ,department = ? , salary = ? where id=?";
    private static final	String DELETE_QUERY = "delete from employees where id =?";
	//private static final String GET_ALL_QUERY= "select* from employees ";
	public EmployeeBoImp()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/satish","root","Sasu@1209");
			
			
		}
		catch(ClassNotFoundException | SQLException e1)
		{
			e1.printStackTrace();
		}
	}
		
		
	
	public int save(Employee e)
	{
		
		try {
			//Scanner scan = new Scanner(System.in);
		    
		    prepareStatement  =  connection.prepareStatement(Insert_Query);
		    prepareStatement.setInt(1,e.getId());
		    prepareStatement.setString(2,e.getName());
		    prepareStatement.setString(3,e.getEmail());
		    prepareStatement.setString(4,e.getDepartment());
		    prepareStatement.setInt(5,e.getSalary());
		    
		    
		    return  prepareStatement.executeUpdate();
		    
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
		
		return 0;
	
		
		
		
		
		
	}
	public int update(Employee e)
	{
		
		try
		{
		
		prepareStatement=connection.prepareStatement(UPDATE_QUERY);
		prepareStatement.setString(1, e.getName());
		prepareStatement.setString(2, e.getEmail());
		prepareStatement.setString(3, e.getDepartment());
		prepareStatement.setInt(4, e.getSalary());
		prepareStatement.setInt(5, e.getId());
		return  prepareStatement.executeUpdate();
		
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
			
		}			
		return 0;
	}
	public int delete(int id)
	{
		
		try
		{
		
		prepareStatement=connection.prepareStatement(DELETE_QUERY);
	    prepareStatement.setInt(1,id);
	    
		return  prepareStatement.executeUpdate();
		
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
			
		}			
		return 0;
	}
	
	
	public int delete(Employee e)
	{
	    return delete(e.getId());
	}
	
	public Employee get(int id)
	{
		return null;
	}
			
	
		
	

}

