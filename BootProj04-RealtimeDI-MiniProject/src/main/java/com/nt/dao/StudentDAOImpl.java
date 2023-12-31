//StudentDAOImpl.java
package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.model.Student;

@Repository("studDAO")
public class StudentDAOImpl implements IStudentDAO {
	private static final String GET_ALL_STUDENTS_BY_ADDRESSES="SELECT SNO,SNAME,SADD,AVG FROM STUDENT WHERE SADD IN(?,?,?)ORDER BY SADD";
	
	@Autowired
	private DataSource ds;

	@Override
	public List<Student> getAllStudentsByAddresses(String city1, String city2, String city3) throws Exception {
		List<Student> list = null;
		//write jdbc code to student records based on the given 3 city names
		try(Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(GET_ALL_STUDENTS_BY_ADDRESSES);){
			//set values to Query params
			ps.setString(1, city1);
			ps.setString(2, city2);
			ps.setString(3, city3);
			//execute the SQL Query
			try(ResultSet rs = ps.executeQuery()){ //nested try with resource
				//process the ResultSet object (copy the records of ResultSet objects to List<Student> collection)
				list = new ArrayList<Student>();
				while(rs.next()) {
					//copy each record in Model class object
					Student st = new Student();
					st.setSno(rs.getInt(1));
					st.setSname(rs.getString(2));
					st.setSadd(rs.getString(3));
					st.setAvg(rs.getFloat(4));
					//add model class obj to list collection
					list.add(st);
				}//while		
			}//try2
		}//try1
		catch(SQLException se) {
			se.printStackTrace();
			throw se;  //Exception rethrowing
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;  //Exception rethrowing
		}
		
		return list;
		
	}//method

}//class
