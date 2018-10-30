package com.cg.ems.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;

import oracle.sql.DATE;

import com.cg.ems.dto.Employee;
import com.cg.ems.exception.EmployeeException;

public interface EmployeeService {

	public int addEmployee(Employee ee) throws EmployeeException;
	public HashSet<Employee> fetchAllEmp();
	public Employee getEmpById(int empId);
	public HashSet<Employee> searchEmpByName(String name);
	public int deleteEmp(int empId);
	public Employee updateEmp(int empId, String newname, float newSal);

	
	// adding validation method
	
	public boolean validateDigit(int num)throws
	EmployeeException;
	public boolean validateName(String name)throws
	EmployeeException;
	public LocalDate convertFromStrToLocalDate(String dtStr);
	
	public Date convertFromLocalDateToSqlDate(LocalDate date);
	
	
	
}
