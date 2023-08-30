package com.uyeol.personal.student.vo;

import java.time.LocalDate;

import lombok.Data;

@Data
public class StudentStatusUpdateVO {
	
	private String studentName;
	
	private LocalDate lectureStartDate;
	
	private LocalDate lectureEndDate;

}
