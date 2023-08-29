package com.uyeol.personal.teacher.vo;

import java.time.LocalDate;

import lombok.Data;

@Data
public class TeacherVO {

	// field
	private int teacherId;
	
	private String teacherName;
	
	private String teacherEmail;
	
	private String teacherInfo;
	
	private LocalDate teacherHireDate;
	
	private int lectureId;
	
	
	// constructor
	public TeacherVO() {
		
	}
	
	public TeacherVO(int teacherId, String teacherName, String teacherEmail, 
			String teacherInfo, LocalDate teacherHireDate, int lectureId) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.teacherEmail = teacherEmail;
		this.teacherInfo = teacherInfo;
		this.teacherHireDate = teacherHireDate;
		this.lectureId = lectureId;
	}

	public TeacherVO(int teacherId, String teacherName, 
			String teacherEmail, String teacherInfo) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.teacherEmail = teacherEmail;
		this.teacherInfo = teacherInfo;
	}
	
}
