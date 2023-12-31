//Student.java(Model class)
package com.nt.model;

import java.io.Serializable;
import lombok.Data;

@Data
public class Student implements Serializable {
	private Integer sno;
	private String sname;
	private String sadd;
	private float avg;
	private String result;
}
