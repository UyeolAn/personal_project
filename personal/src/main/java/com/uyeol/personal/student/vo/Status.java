package com.uyeol.personal.student.vo;

import lombok.Getter;

@Getter
public enum Status {
	
	NONE("수강신청 예정"), 
	CANCEL("수강신청 취소"),
	SCHEDULED("수강 예정"), 
	INCLASS("수강중"), 
	FINISH("수료"), 
	FAIL("중도탈락");
	
	final private String name; 
	
	private Status (String name) { 
		this.name = name; 
	}
	
}
