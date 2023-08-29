package com.uyeol.personal.teacher.vo;

import lombok.Data;

@Data
public class TeacherUpdateVO {
	
	// search field
	private String targetName;
	
	// new value field
	private String newTeacherName;
	
	private String newTeacherEmail;
	
	private String newTeacherInfo;
	
	private int newLectureId;
	
	
	// constructor
	public TeacherUpdateVO() {
		
	}

	public TeacherUpdateVO(String targetName, String newTeacherName, 
			String newTeacherEmail, String newTeacherInfo, int newLectureId) {
		super();
		this.targetName = targetName;
		this.newTeacherName = newTeacherName;
		this.newTeacherEmail = newTeacherEmail;
		this.newTeacherInfo = newTeacherInfo;
		this.newLectureId = newLectureId;
	}

	
	
}
