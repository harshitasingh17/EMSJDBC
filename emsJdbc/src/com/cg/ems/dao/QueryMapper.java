package com.cg.ems.dao;

public interface QueryMapper {
	public static final String SELECTQRY1= "SELECT * FROM emp161727";
	public static final String SELECTQRY2= "SELECT * FROM emp161727 where emp_id=?";
	public static final String INSERTQRY1="INSERT INTO emp161727 VALUES(222,'sunil',34000,SYSDATE)";
	public static final String INSERTQRY2="INSERT INTO emp161727(emp_id,emp_name,emp_sal)"+ "VALUES(444,'Amit',6000)";
	public static final String INSERTQRY3="INSERT INTO emp161727(emp_id,emp_name,emp_sal,emp_dob)"+ "VALUES(?,?,?,?)";
	public static final String DELETEQRY1= "DELETE  emp161727 where emp_id=?";
	public static final String UPDATEQRY1= "UPDATE emp161727 SET emp_name=?,emp_sal=? where emp_id=?";
	public static final String SELECTQRY3= "SELECT * FROM emp161727 where emp_name=?";
}
