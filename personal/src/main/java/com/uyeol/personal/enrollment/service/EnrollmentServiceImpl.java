package com.uyeol.personal.enrollment.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.uyeol.personal.common.DataSource;
import com.uyeol.personal.enrollment.mapper.EnrollmentMapper;
import com.uyeol.personal.enrollment.vo.EnrollmentSearchVO;
import com.uyeol.personal.enrollment.vo.EnrollmentTakeVO;
import com.uyeol.personal.enrollment.vo.EnrollmentVO;

public class EnrollmentServiceImpl implements EnrollmentService {

	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	
	private EnrollmentMapper map = sqlSession.getMapper(EnrollmentMapper.class);
	
	
	@Override
	public List<EnrollmentSearchVO> findEnrollmentSearchVOs() {
		return map.findEnrollmentSearchVOs();
	}

	@Override
	public List<EnrollmentSearchVO> findEnrollmentSearchVOsByStudent(String name) {
		return map.findEnrollmentSearchVOsByStudent(name);
	}

	@Override
	public List<EnrollmentSearchVO> findEnrollmentSearchVOsByLecture(String name) {
		return map.findEnrollmentSearchVOsByLecture(name);
	}

	@Override
	public List<EnrollmentSearchVO> findNotEnrolledEnrollmentSearchVOs() {
		return map.findNotEnrolledEnrollmentSearchVOs();
	}

	@Override
	public List<EnrollmentSearchVO> findEnrolledEnrollmentSearchVOs() {
		return map.findEnrolledEnrollmentSearchVOs();
	}
	
	@Override
	public EnrollmentVO findEnrollmentByStudentId(int id) {
		return map.findEnrollmentByStudentId(id);
	}
	
	@Override
	public EnrollmentVO findEnrollmentForTake(EnrollmentTakeVO vo) {
		return map.findEnrollmentForTake(vo);
	}
	
	@Override
	public int createEnrollment(EnrollmentVO vo) {
		return map.createEnrollment(vo);
	}
	
	@Override
	public int updateEnrollmentByStudentId(EnrollmentVO vo) {
		return map.updateEnrollmentByStudentId(vo);
	}

	@Override
	public int deleteEnrollmentByStudentId(int id) {
		return map.deleteEnrollmentByStudentId(id);
	}

	
	
}
