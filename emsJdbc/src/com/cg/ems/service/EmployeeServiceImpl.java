package com.cg.ems.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.regex.Pattern;

import oracle.sql.DATE;

import com.cg.ems.dao.EmpDaoImpl;
import com.cg.ems.dao.EmployeeDao;
import com.cg.ems.dto.Employee;
import com.cg.ems.exception.EmployeeException;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDao empDao = null;
	
	public EmployeeServiceImpl(){
		empDao = new EmpDaoImpl();
	}
	
	
	
	
	@Override
	public int addEmployee(Employee ee) throws EmployeeException {
		// TODO Auto-generated method stub
		
		
		return empDao.addEmployee(ee);
	}

	@Override
	public HashSet<Employee> fetchAllEmp() {
		// TODO Auto-generated method stub
		return empDao.fetchAllEmp();
	}

	@Override
	public Employee getEmpById(int empId) {
		// TODO Auto-generated method stub
		return empDao.getEmpById(empId);
	}

	@Override
	public HashSet<Employee> searchEmpByName(String name) {
		// TODO Auto-generated method stub
		return empDao.searchEmpByName(name);
	}

	@Override
	public int deleteEmp(int empId) {
		// TODO Auto-generated method stub
		return empDao.deleteEmp(empId);
	}

	@Override
	public Employee updateEmp(int empId, String newname, float newSal) {
		// TODO Auto-generated method stub
		return empDao.updateEmp(empId, newname, newSal);
	}

	@Override
	public boolean validateDigit(int num) throws EmployeeException {
		// TODO Auto-generated method stub
		// converting number into strings
		Integer input= new Integer (num);
		String inputStr= input.toString();
		String digitPattern="[0-9]+";
				if(Pattern.matches(digitPattern, inputStr))
				{
					return true;
				}
				else
				{
					throw new EmployeeException("invalid input only digits required");
				}
		
		
	}

	@Override
	public boolean validateName(String name) throws EmployeeException {
		// TODO Auto-generated method stub
		String namePattern ="[A-Z][a-z]+";
				if(Pattern.matches(namePattern, name))
				{
					return true;
				}
				else
				{
					throw new EmployeeException("invalid input only characters required, strating letter in caps");
				}
		
		
	}




	@Override
	public LocalDate convertFromStrToLocalDate(String dtStr) {
		// TODO Auto-generated method stub
		DateTimeFormatter myFormat=DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date=LocalDate.parse(dtStr,myFormat);
		
		return date;
	}




	@Override
	public Date convertFromLocalDateToSqlDate(LocalDate date) {
		// TODO Auto-generated method stub
		
		java.sql.Date sqlDob=java.sql.Date.valueOf(date);
		
		return sqlDob;
	}

}
