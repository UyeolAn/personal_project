package com.uyeol.personal.student.vo;

import lombok.Data;

@Data
public class StudentLoginVO {
	
	// field
	private String loginEmail;
	
	private String loginPassword;
	
	
	// constructor
	public StudentLoginVO() {
		
	}

	public StudentLoginVO(String loginEmail, String loginPassword) {
		super();
		this.loginEmail = loginEmail;
		this.loginPassword = loginPassword;
	}
	
}
