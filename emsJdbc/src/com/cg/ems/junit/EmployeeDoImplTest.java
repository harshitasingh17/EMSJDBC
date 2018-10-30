package com.cg.ems.junit;

import java.sql.Date;
import java.time.LocalDate;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.ems.dao.EmployeeDao;
import com.cg.ems.dao.EmpDaoImpl;
import com.cg.ems.dto.Employee;
import com.cg.ems.exception.EmployeeException;


public class EmployeeDoImplTest {
	static EmployeeDao empdao=null;
	@BeforeClass
	public static void setUp()
	{
		empdao = new EmpDaoImpl();
	}
	@Test
	public void addEmpTest() throws EmployeeException{
		//Assert.assertEquals(111, empdao.addEmployee(new Employee (111,"aaa",111.0F,Date.valueOf(null))));
	}
}
