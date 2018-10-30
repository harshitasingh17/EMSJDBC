package com.cg.ems.ui;

import java.util.HashSet;
import java.util.TreeSet;

import com.cg.ems.dto.Employee;

public class TestHashSetDemo {

	
	public static void main(String args[]){
		
		HashSet<Employee> emps = new HashSet<Employee>();
		emps.add(new Employee(333,"vaishali",10000.0F,null));
		emps.add(new Employee(111,"dinesh",23000.0F,null));
		emps.add(new Employee(222,"shmita",11000.0F,null));
		emps.add(new Employee(222,"shmita",40000.0F,null));
		
		System.out.println(emps);
		
		
		System.out.println("********************");
		TreeSet<Employee> emps2= new TreeSet<Employee>();
		/*
		cities.add("Pune");
		cities.add("Noida");
		cities.add("Mumbai");
		cities.add("Pune");
		*/
		
		
		emps2.add(new Employee(333,"vaishali",10000.0F, null));
		emps2.add(new Employee(111,"dinesh",23000.0F,null));
		emps2.add(new Employee(222,"shmita",11000.0F,null));
		emps2.add(new Employee(222,"shmita",40000.0F,null));
		
		System.out.println(emps2); // sorted  in alphabetical order
				
		
	}
	
	
	
	
}
