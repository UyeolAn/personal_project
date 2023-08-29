package com.uyeol.personal.staff.vo;

import java.time.LocalDate;

import lombok.Data;

@Data
public class StaffVO {

	// field
	private int staffId;
	
	private String staffEmail;
	
	private String staffPassword;
	
	private String staffName;
	
	private String staffTel;
	
	private LocalDate staffHireDate;
	
	private boolean isMaster;
	
	
	// constructor
	public StaffVO() {
		
	}

	public StaffVO(int staffId, String staffEmail, String staffPassword, String staffTel,
			String staffName, LocalDate staffHireDate, boolean isMaster) {
		super();
		this.staffId = staffId;
		this.staffEmail = staffEmail;
		this.staffPassword = staffPassword;
		this.staffName = staffName;
		this.staffTel = staffTel;
		this.staffHireDate = staffHireDate;
		this.isMaster = isMaster;
	}

	public StaffVO(int staffId, String staffEmail, String staffPassword, String staffName, String staffTel) {
		super();
		this.staffId = staffId;
		this.staffEmail = staffEmail;
		this.staffPassword = staffPassword;
		this.staffName = staffName;
		this.staffTel = staffTel;
	}
	
}
