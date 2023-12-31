//IStudentMgmtService.java
package com.nt.service;

import java.util.List;

import com.nt.model.Student;

public interface IStudentMgmtService {
	public List<Student> fetchStudentDetailsByAddresses(String city1,String city2,String city3)throws Exception;

}
