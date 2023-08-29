package com.uyeol.personal.lecture.vo;

import java.time.LocalDate;

import lombok.Data;

@Data
public class LectureVO {

	// field
	private int lectureId;
	
	private String lectureName;
	
	private String lectureDescription;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	private int numStudents;
	
	private int maxNumStudents;
	
	private boolean isStarted;
	
	
	// constructor
	public LectureVO() {
		
	}

	public LectureVO(int lectureId, String lectureName, String lectureDescription, 
			LocalDate startDate, LocalDate endDate, 
			int numStudents, int maxNumStudents, boolean isStarted) {
		super();
		this.lectureId = lectureId;
		this.lectureName = lectureName;
		this.lectureDescription = lectureDescription;
		this.startDate = startDate;
		this.endDate = endDate;
		this.numStudents = numStudents;
		this.maxNumStudents = maxNumStudents;
		this.isStarted = isStarted;
	}

}
