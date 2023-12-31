package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IStudentDAO;
import com.nt.model.Student;
@Service("studService")
public class StudentMgmtServiceImpl implements IStudentMgmtService {
	@Autowired
	private IStudentDAO studDAO;
	
	@Override
	public List<Student> fetchStudentDetailsByAddresses(String city1, String city2, String city3) throws Exception {
		//use DAO
		List<Student> list = studDAO.getAllStudentsByAddresses(city1, city2, city3);
		//calculate result for each student(b.logic)
		list.forEach(st->{
			String result = null;
			if(st.getAvg()<35)
				result="FAIL";
			else if(st.getAvg()>=35 && st.getAvg()<50)
				result="THIRD CLASS";
			else if(st.getAvg()>=50 && st.getAvg()<60)
				result="SECOND CLASS";
			else if(st.getAvg()>=60 && st.getAvg()<75)
				result="FIRST CLASS";
			else
				result="FIRST CLASS with Distinction";
			st.setResult(result);	
		});
		return list;
	}

}
