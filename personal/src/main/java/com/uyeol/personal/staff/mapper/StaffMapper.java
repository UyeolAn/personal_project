package com.uyeol.personal.staff.mapper;

import java.util.List;

import com.uyeol.personal.staff.vo.StaffUpdateVO;
import com.uyeol.personal.staff.vo.StaffVO;

public interface StaffMapper {
	
	List<StaffVO> findAllStaffs();
	
	StaffVO findStaffByName(String name);
	
	int createStaff(StaffVO vo);
	
	int updateStaffByName(StaffUpdateVO vo);
	
	int deleteStaffByName(String name);

}
