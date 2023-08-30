package com.uyeol.personal.student.vo;

import java.time.LocalDate;

import lombok.Data;

@Data
public class StudentUpdateVO {
	
	// search field
	private String targetName;
	
	// new value field
	private String newStudentEmail;
	
	private String newStudentPassword;
	
	private String newStudentName;

	private LocalDate newStudentBirth;
	
	private String newStudentTel;
	
	private Status newStatus;
	
	private int newLectureId;
	
	
	// constructor
	public StudentUpdateVO() {
		
	}

	public StudentUpdateVO(String targetName, String newStudentEmail, String newStudentPassword, 
			String newStudentName, LocalDate newStudentBirth, String newStudentTel) {
		super();
		this.targetName = targetName;
		this.newStudentEmail = newStudentEmail;
		this.newStudentPassword = newStudentPassword;
		this.newStudentName = newStudentName;
		this.newStudentBirth = newStudentBirth;
		this.newStudentTel = newStudentTel;
	}

	public StudentUpdateVO(String targetName, Status newStatus) {
		super();
		this.targetName = targetName;
		this.newStatus = newStatus;
	}

	public StudentUpdateVO(String targetName, int newLectureId) {
		super();
		this.targetName = targetName;
		this.newLectureId = newLectureId;
	}
	
}
