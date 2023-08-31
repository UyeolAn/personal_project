package com.uyeol.personal.lecture.vo;

import java.time.LocalDate;

import lombok.Data;

@Data
public class LectureVO {

	// field
	private int lectureId;
	
	private String lectureName;
	
	private String lectureDescription;
	
	private LocalDate lectureStartDate;
	
	private LocalDate lectureEndDate;
	
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
		this.lectureStartDate = startDate;
		this.lectureEndDate = endDate;
		this.numStudents = numStudents;
		this.maxNumStudents = maxNumStudents;
		this.isStarted = isStarted;
	}

	public LectureVO(String lectureName, int numStudents) {
		super();
		this.lectureName = lectureName;
		this.numStudents = numStudents;
	}

}
