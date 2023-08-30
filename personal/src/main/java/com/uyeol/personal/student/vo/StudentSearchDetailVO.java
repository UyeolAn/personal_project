package com.uyeol.personal.student.vo;

import java.time.LocalDate;

import lombok.Data;

@Data
public class StudentSearchDetailVO {
	
	private int studentId;
	
	private String studentName;
	
	private String studentEmail;
	
	private LocalDate studentBirth;
	
	private String studentTel;
	
	private LocalDate enterDate;
	
	private String lectureName;
	
	private Status status;
	
}
