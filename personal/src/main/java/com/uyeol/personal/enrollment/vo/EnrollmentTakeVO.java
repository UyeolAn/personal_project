package com.uyeol.personal.enrollment.vo;

import lombok.Data;

@Data
public class EnrollmentTakeVO {

	// field
	private String studentName;
	
	private String lectureName;
	
	
	// constructor
	public EnrollmentTakeVO() {
		
	}

	public EnrollmentTakeVO(String studentName, String lectureName) {
		super();
		this.studentName = studentName;
		this.lectureName = lectureName;
	}
	
}
