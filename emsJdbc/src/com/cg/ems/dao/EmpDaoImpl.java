package com.cg.ems.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;











import com.cg.ems.dto.Employee;
import com.cg.ems.exception.EmployeeException;
import com.cg.ems.util.DBUtil;


public class EmpDaoImpl implements EmployeeDao {
	Connection con=null;
	Statement st=null;
	PreparedStatement pst=null;
	ResultSet rs=null;

	@Override
	public int addEmployee(Employee ee) throws EmployeeException {
		try {
			con=DBUtil.getCon();
			pst=con.prepareStatement(QueryMapper.INSERTQRY3);
			pst.setInt(1, ee.getEmpId());
			pst.setString(2, ee.getEmpName());
			pst.setFloat(3, ee.getEmpSal());
			pst.setDate(4, ee.getEmpDoj());
			int data=pst.executeUpdate();
			if(data==1){
				return ee.getEmpId();
			}
			else{
				return 0;
			}

		} catch (Exception e) {

			e.printStackTrace();
			throw new EmployeeException(e.getMessage());

		}
		finally{

		}

	}

	@Override
	public HashSet<Employee> fetchAllEmp() {

		HashSet<Employee> empSet = new HashSet<Employee>();
		try
		{
			con=DBUtil.getCon();
			st=con.createStatement();
			rs=st.executeQuery(QueryMapper.SELECTQRY1);
			while(rs.next())
			{
				int eid=rs.getInt("emp_id");
				String enm = rs.getString("emp_name");
				float sal = rs.getFloat("emp_sal");
				empSet.add(new Employee(eid,enm,sal,null));


			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return empSet;

	}

	public Employee getEmpById(int empId){
		Employee ee=null;
		try {
			con=DBUtil.getCon();
			/*pst=con.prepareStatement(QueryMapper.SELECTQRY2);
			pst.setInt(1,empId);*/

			pst=con.prepareStatement(QueryMapper.SELECTQRY2);
			pst.setInt(1,empId);
			rs=pst.executeQuery();
			rs.next();
			if(rs!=null){

				ee= new Employee(rs.getInt("EMP_ID"),rs.getString("EMP_NAME"),rs.getFloat("EMP_SAL"),null);
			} }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return ee;
	}


	@Override
	public HashSet<Employee> searchEmpByName(String name) {
		Employee ee=null;
		HashSet<Employee> additional = new HashSet<Employee>();
		try {

			con=DBUtil.getCon();
			/*pst=con.prepareStatement(QueryMapper.SELECTQRY2);
			pst.setInt(1,empId);*/

			pst=con.prepareStatement(QueryMapper.SELECTQRY3);
			pst.setString(1,name);
			rs=pst.executeQuery();
			while(rs.next()){
				if(rs!=null){

					ee= new Employee(rs.getInt("EMP_ID"),rs.getString("EMP_NAME"),rs.getFloat("EMP_SAL"),null);
					additional.add(ee);
				} }}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return additional;
	}




	@Override
	public int deleteEmp(int empId) {
		int flag=0;

		try {
			con=DBUtil.getCon();
			st=con.createStatement();
			pst=con.prepareStatement(QueryMapper.DELETEQRY1);
			pst.setInt(1,empId);


			int data=pst.executeUpdate();

			if(data!=0){
				System.out.println("Data deleted");
				flag=1;
			}


			//int data=pst.executeUpdate();
			// no. of record updated is stored in data

			st.executeQuery(QueryMapper.SELECTQRY1);
			rs=((java.sql.Statement)st).executeQuery(QueryMapper.SELECTQRY1);
			
			/*System.out.println("EMP_ID\t\tEMP_NAME\t\tEMP_SAL\t\tEMP_DOB");
			while(rs.next()){

				System.out.println(rs.getInt("EMP_ID")+"\t\t"+rs.getString("EMP_NAME")+"\t\t"+rs.getFloat("EMP_SAL")+"\t\t"+rs.getDate("EMP_DOB"));// field name is case Sensitive
			}

			 */

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return flag;
	}

	@Override
	public Employee updateEmp(int empId, String newName, float newSal) {
		Employee ee=null;

		try {
			con=DBUtil.getCon();
			pst=con.prepareStatement(QueryMapper.UPDATEQRY1);
			pst.setInt(3,empId);
			pst.setString(1,newName);
			pst.setFloat(2, newSal);

			int data=pst.executeUpdate();
			System.out.println("Data Updated");// no. of record updated is stored in data
			ee= new Employee(empId,newName,newSal,null);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ee;	
	}
}

