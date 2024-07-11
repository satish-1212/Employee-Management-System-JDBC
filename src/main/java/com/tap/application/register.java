package com.tap.application;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tap.models.Employee;
import com.tap.dao.EmployeeBoImp;


@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
		int id = Integer.parseInt(request.getParameter("id"));
		String name  = request.getParameter("name");
		String email = request.getParameter("email");
		String department = request.getParameter("department");
		int salary =Integer.parseInt( request.getParameter("salary"));

		Employee employee  = new Employee(id,name,email,department,salary);
		
		EmployeeBoImp employeeBo  = new EmployeeBoImp();
		employeeBo.save(employee);
		}
		catch(NumberFormatException e)
		{
			e.printStackTrace();
		}
		
		
		
	}

}
