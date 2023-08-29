package com.uyeol.personal.staff.vo;

import lombok.Data;

@Data
public class StaffLoginVO {

	// field
	private String loginEmail;
	
	private String loginPassword;
	
	
	// constructor
	public StaffLoginVO() {
		
	}
	
	public StaffLoginVO(String loginEmail, String loginPassword) {
		super();
		this.loginEmail = loginEmail;
		this.loginPassword = loginPassword;
	}
	
}
