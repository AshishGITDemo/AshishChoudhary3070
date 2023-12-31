package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.controller.StudentOperationsController;
import com.nt.model.Student;

@SpringBootApplication
public class BootProj04RealtimeDiMiniProjectApplication {

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx = SpringApplication.run(BootProj04RealtimeDiMiniProjectApplication.class, args);
		//get the controller class obj
		StudentOperationsController controller = ctx.getBean("studController",StudentOperationsController.class);
		//invoke b.methods
		try {
			List<Student> list = controller.processStudentsData("hyd","delhi", "vizag");
			list.forEach(st->{
				System.out.println(st);
			});
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("problem::"+e.getMessage());
		}
		
		//close the IOC container
		((ConfigurableApplicationContext)ctx).close();
	}

}
