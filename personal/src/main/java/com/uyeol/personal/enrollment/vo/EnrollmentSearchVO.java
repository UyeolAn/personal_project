package com.uyeol.personal.enrollment.vo;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EnrollmentSearchVO {
	
	private String studentName;
	
	private String lectureName;
	
	private LocalDate enrollmentDate;
	
	private boolean isEnrolled;
	
}
