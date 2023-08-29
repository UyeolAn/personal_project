package com.uyeol.personal.enrollment.vo;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EnrollmentVO {
	
	// field
	private int enrollmentId;
	
	private LocalDate enrollmentDate;
	
	private boolean isEnrolled;
	
	private int studentId;
	
	private int lectureId;

	
	// constructor
	public EnrollmentVO() {
		
	}
	
	public EnrollmentVO(int enrollmentId, LocalDate enrollmentDate, 
			boolean isEnrolled, int studentId, int lectureId) {
		super();
		this.enrollmentId = enrollmentId;
		this.enrollmentDate = enrollmentDate;
		this.isEnrolled = isEnrolled;
		this.studentId = studentId;
		this.lectureId = lectureId;
	}

	public EnrollmentVO(int enrollmentId, int studentId, int lectureId) {
		super();
		this.enrollmentId = enrollmentId;
		this.studentId = studentId;
		this.lectureId = lectureId;
	}
	
	public EnrollmentVO(boolean isEnrolled, int studentId, int lectureId) {
		super();
		this.isEnrolled = isEnrolled;
		this.studentId = studentId;
		this.lectureId = lectureId;
	}
	
}
