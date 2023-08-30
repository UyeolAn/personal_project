package com.uyeol.personal.enrollment.service;

import org.apache.ibatis.session.SqlSession;

import com.uyeol.personal.common.DataSource;
import com.uyeol.personal.enrollment.mapper.EnrollmentMapper;
import com.uyeol.personal.enrollment.vo.EnrollmentVO;

public class EnrollmentServiceImpl implements EnrollmentService {

	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	
	private EnrollmentMapper map = sqlSession.getMapper(EnrollmentMapper.class);
	
	
	@Override
	public EnrollmentVO findEnrollmentByStudentId(int id) {
		return map.findEnrollmentByStudentId(id);
	}
	
	@Override
	public int createEnrollment(EnrollmentVO vo) {
		return map.createEnrollment(vo);
	}

	@Override
	public int deleteEnrollmentByStudentId(int id) {
		return map.deleteEnrollmentByStudentId(id);
	}
	
}
