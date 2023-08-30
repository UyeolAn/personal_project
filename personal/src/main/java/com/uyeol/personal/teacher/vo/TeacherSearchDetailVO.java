package com.uyeol.personal.teacher.vo;

import java.time.LocalDate;

import lombok.Data;

@Data
public class TeacherSearchDetailVO {
	
	private int teacherId;
	
	private String teacherName;
	
	private String teacherEmail;
	
	private String teacherInfo;
	
	private String lectureName;
	
	private LocalDate teacherHireDate;
	
}
