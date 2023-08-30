package com.uyeol.personal.staff.service;

import com.uyeol.personal.staff.vo.StaffLoginVO;
import com.uyeol.personal.staff.vo.StaffUpdateVO;
import com.uyeol.personal.staff.vo.StaffVO;

public interface StaffService {
	
	StaffVO findStaffByName(String name);

	StaffVO login(StaffLoginVO vo);
	
	int updateStaffByName(StaffUpdateVO vo);
	
}
