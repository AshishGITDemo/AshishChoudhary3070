package com.nt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nt.beans.Employee;

public class EmployeeDAOImpl implements IEmployeeDAO {
	
	private static final String GET_EMPS_BY_DESGS="SELECT EMPNO,ENAME,JOB,SAL FROM EMPLOYEE WHERE JOB=? ORDER BY SAL";
	
    private Connection makeConnection()throws Exception {
    	Class.forName("oracle.jdbc.driver.OracleDriver");
    	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","tiger");
    	return con;
    }

	@Override
	public List<Employee> searchEmployeesByDesg(String desg) throws Exception {
		List<Employee> list = null;
		//get the connection object
		try(Connection con=makeConnection();
				//create the PreparedStatement object
				PreparedStatement ps=con.prepareStatement(GET_EMPS_BY_DESGS);){
			
			//set the query param values
			ps.setString(1, desg);
			//execute the SQL Query
			try(ResultSet rs=ps.executeQuery()){
				//copy the records of ResultSet obj List<Employee> obj
				list = new ArrayList();
				while(rs.next()) {
					//copy each record of ResultSet into Employee class obj
					Employee emp = new Employee();
					emp.setEmpNo(rs.getInt(1));
					emp.setEmpName(rs.getString(2));
					emp.setDesg(rs.getString(3));
					emp.setSalary(rs.getDouble(4));
					//add the model class obj to List collection
					list.add(emp);
				}//while
			}//try2
		}//try1
		catch(SQLException se){
			throw se;
		}
		catch(Exception e) {
			throw e;
		}
		
		return list;
		
	}//method

}//class

