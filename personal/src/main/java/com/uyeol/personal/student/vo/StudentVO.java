package com.uyeol.personal.student.vo;

import java.time.LocalDate;

import lombok.Data;

@Data
public class StudentVO {
	
	// field
	private int studentId;
	
	private String studentEmail;
	
	private String studentPassword;
	
	private String studentName;
	
	private LocalDate studentBirth;
	
	private String studentTel;
	
	private LocalDate enterDate;
	
	private Status status;
	
	private int lectureId;
	
	
	// constructor
	public StudentVO() {
		
	}

	public StudentVO(int studentId, String studentEmail, String studentPassword, 
			String studentName, LocalDate studentBirth, String studentTel, 
			LocalDate enterDate, Status status, int lectureId) {
		super();
		this.studentId = studentId;
		this.studentEmail = studentEmail;
		this.studentPassword = studentPassword;
		this.studentName = studentName;
		this.studentBirth = studentBirth;
		this.studentTel = studentTel;
		this.enterDate = enterDate;
		this.status = status;
		this.lectureId = lectureId;
	}

	public StudentVO(int studentId, String studentEmail, String studentPassword, 
			String studentName, LocalDate studentBirth, String studentTel) {
		super();
		this.studentId = studentId;
		this.studentEmail = studentEmail;
		this.studentPassword = studentPassword;
		this.studentName = studentName;
		this.studentBirth = studentBirth;
		this.studentTel = studentTel;
	}

}
