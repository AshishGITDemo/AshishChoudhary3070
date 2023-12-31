package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.model.Student;
import com.nt.service.IStudentMgmtService;

@Controller("studController")
public class StudentOperationsController {
	@Autowired
	private IStudentMgmtService studService;
	
	public List<Student> processStudentsData(String city1, String city2, String city3)throws Exception {
		//use service
		List<Student> list = studService.fetchStudentDetailsByAddresses(city1,city2,city3);
		return list;
	}

}
