package com.uyeol.personal.staff.vo;

import lombok.Data;

@Data
public class StaffUpdateVO {
	
	// search field
	private int targetName;
	
	// new variable field
	private String newStaffEmail;
	
	private String newStaffPassword;
	
	private String newStaffName;
	
	private String newStaffTel;
	
	
	// constructor
	public StaffUpdateVO() {
		
	}


	public StaffUpdateVO(int targetName, String newStaffEmail, 
			String newStaffPassword, String newStaffName, String newStaffTel) {
		super();
		this.targetName = targetName;
		this.newStaffEmail = newStaffEmail;
		this.newStaffPassword = newStaffPassword;
		this.newStaffName = newStaffName;
		this.newStaffTel = newStaffTel;
	}
	
}
