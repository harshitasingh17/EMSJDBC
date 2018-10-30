package com.cg.ems.dto;

import java.sql.Date;
import java.time.LocalDate;

public class Employee implements Comparable<Employee> {
	
	private int empId;
	private String empName;
	private float empSal;
	private Date empDoj;
	
	// constructors
	public Employee(int empId, String empName, float empSal, Date empDoj) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSal = empSal;
		this.empDoj = empDoj;
	}
	
	// toString
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName
				+ ", empSal=" + empSal + ", empDoj="+empDoj +"]";
	}
	
	//setter getter
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public float getEmpSal() {
		return empSal;
	}
	public void setEmpSal(float empSal) {
		this.empSal = empSal;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	
	
	@Override
	public boolean equals(Object obj){
		
// overriding equals method for removing duplicate values		
Employee emp= (Employee) obj;
if(emp.empId==this.empId)
{
return true;	
}
else return false;

}
	
	@Override
	public int hashCode(){
		return empId; // emp_id is used as hash code
	}
	
	
	@Override
	public int compareTo(Employee emp) // employee is not comparable class so implemented comparable method
	{
		if(emp.empId<this.empId){
			
			
			return -1;
			
			}
		
		else if (emp.empId==this.empId){
			return 0;
		}
		else 
			return 1;
	}

	public Date getEmpDoj() {
		return empDoj;
	}

	public void setEmpDoj(Date empDoj) {
		this.empDoj = empDoj;
	}
	
	//adding date
	
	
	
	
	

}
