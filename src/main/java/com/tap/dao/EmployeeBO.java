package com.tap.dao;
import com.tap.models.Employee;
//import java.util.List;
public interface EmployeeBO {
	int save(Employee e);
	int update(Employee e);
	int delete(int id);
	int delete(Employee e);
	Employee get(int id);
	//List<Employee> getAll();
	
	

}
