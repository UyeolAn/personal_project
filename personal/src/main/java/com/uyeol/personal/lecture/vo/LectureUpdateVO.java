package com.uyeol.personal.lecture.vo;

import java.time.LocalDate;

import lombok.Data;

@Data
public class LectureUpdateVO {
	
	// search field
	private String targetName;
	
	// new value field
	private String newLectureName;
	
	private String newLectureDescription;
	
	private LocalDate newStartDate;
	
	private LocalDate newEndDate;
	
	private int newMaxNumStudents;
	
	
	// constructor
	public LectureUpdateVO() {
		
	}


	public LectureUpdateVO(String targetName, String newLectureName, String newLectureDescription,
			LocalDate newStartDate, LocalDate newEndDate, int newMaxNumStudents) {
		super();
		this.targetName = targetName;
		this.newLectureName = newLectureName;
		this.newLectureDescription = newLectureDescription;
		this.newStartDate = newStartDate;
		this.newEndDate = newEndDate;
		this.newMaxNumStudents = newMaxNumStudents;
	}

}
