package com.cg.ems.ui;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import com.cg.ems.dto.Employee;
import com.cg.ems.exception.EmployeeException;
import com.cg.ems.service.EmployeeService;
import com.cg.ems.service.EmployeeServiceImpl;

public class TestEmployeeClient {

	static Scanner sc=null;
	static EmployeeService empSer=null;

	public static void main(String args[]){

		 sc =new Scanner(System.in);
		empSer = new EmployeeServiceImpl();
		int choice=0;
		while(true){
			System.out.println("What do you want to do?");
			System.out.println("1.AddEmp\t 2. Fetch All Emp");
			System.out.println("3.Delete employee\t 4. SEarchEmp by EmpId");
			System.out.println("5.Search by EmpName\t 6. Update details");
			System.out.println("7.exit");
			System.out.println("Enter your choice");
			choice = sc.nextInt();
			switch(choice){

			case 1: addEmp();
			break;
			case 2: showEmpInfo();
			break;
			case 3: delete();
			break;
			case 4: searchEmpById();
			break;
			case 5: searchEmpByName();
			break;
			case 6: updateDetails();
			break;
			case 7: System.exit(0);
			break;
			default:System.out.println("Invalid input to exit press 7");
			}
		}

	}		



	private static void updateDetails() {
		// TODO Auto-generated method stub
	
	//empSer.updateEmp(empId, newname, newSal);
		System.out.println("Enter empId:");	
		int eid = sc.nextInt();
		try{
			if(empSer.validateDigit(eid));
			{
				System.out.println("enter new empName:");
				String nm=sc.next();
				if(empSer.validateName(nm))
				{
					System.out.println("Enter new salary:");
					float newSal=sc.nextFloat();
					
					Employee ee= empSer.updateEmp(eid, nm, newSal);
					if(ee!= null){
					System.out.println(ee+ "updated Successfully");
	}
				else System.out.println("id not found");
			}
		}}
		
		
		catch(EmployeeException e){
			e.printStackTrace();
		}

	}
	private static void delete() {
		// TODO Auto-generated method stub
		System.out.println("enter id to delete");
		int empId= sc.nextInt();
		int e=empSer.deleteEmp(empId);
		if(e==1){
			System.out.println("record deleted");
		}
		else System.out.println("not found");
	}



	private static void searchEmpByName() {
		// TODO Auto-generated method stub
		
		System.out.println("Enter the name");
		String empName = sc.next();
		HashSet<Employee> e= empSer.searchEmpByName(empName);
		if(e!=null){
			System.out.println(e);
		}
		else System.out.println("name  not found");
		
	}



	private static void searchEmpById() {
		// TODO Auto-generated method stub
		
		System.out.println("Enter empId");
		int empId = sc.nextInt();
		
		Employee e= empSer.getEmpById(empId);
		if(e!=null){
			System.out.println(e);
		}
		else System.out.println("id not found");
		
	}



	private static void addEmp() {
		// TODO Auto-generated method stub
		System.out.println("Enter empId:");	
		int eid = sc.nextInt();
		try{
			if(empSer.validateDigit(eid));
			{
				System.out.println("enter empName:");
				String nm=sc.next();
				if(empSer.validateName(nm))
				{
					System.out.println("Enter salary:");
					float sal=sc.nextFloat();
					System.out.println("Enter DOJ(dd-MM-yyyy");
					String empDOJStr = sc.next();
					LocalDate date= empSer.convertFromStrToLocalDate(empDOJStr);
					Employee ee = new Employee(eid,nm,sal,empSer.convertFromLocalDateToSqlDate(date));
					int empId=empSer.addEmployee(ee);
					System.out.println(empId+ "added Successfully");
				}
			}
		}

		catch(EmployeeException e){
			e.printStackTrace();
		}
	}
	private static void showEmpInfo() {
		// TODO Auto-generated method stub
		HashSet<Employee> empSet =empSer.fetchAllEmp();
		System.out.println("-----------------");
		Iterator<Employee> it = empSet.iterator();
		System.out.println("------------------");
		System.out.println("EmpId\t\t EmpName\t\t EmpSalary\t\tEmpDOJ");

		while(it.hasNext())
		{


			Employee ee = it.next();
			System.out.println(ee.getEmpId()+"\t\t"+ ee.getEmpName()+"\t\t"+ee.getEmpSal()+"\t\t"+ee.getEmpDoj());


		}
		System.out.println("----------------------");
	}



}
