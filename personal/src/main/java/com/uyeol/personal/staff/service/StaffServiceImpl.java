package com.uyeol.personal.staff.service;

import org.apache.ibatis.session.SqlSession;

import com.uyeol.personal.common.DataSource;
import com.uyeol.personal.staff.mapper.StaffMapper;
import com.uyeol.personal.staff.vo.StaffLoginVO;
import com.uyeol.personal.staff.vo.StaffUpdateVO;
import com.uyeol.personal.staff.vo.StaffVO;

public class StaffServiceImpl implements StaffService {

	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	
	private StaffMapper map = sqlSession.getMapper(StaffMapper.class);
	
	
	@Override
	public StaffVO findStaffByName(String name) {
		return map.findStaffByName(name);
	}
	
	@Override
	public StaffVO login(StaffLoginVO vo) {
		return map.findStaffForLogin(vo);
	}

	@Override
	public int updateStaffByName(StaffUpdateVO vo) {
		return map.updateStaffByName(vo);
	}

}
