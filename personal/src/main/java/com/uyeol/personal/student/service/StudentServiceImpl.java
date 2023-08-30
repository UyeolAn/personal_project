package com.uyeol.personal.student.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.uyeol.personal.common.DataSource;
import com.uyeol.personal.student.mapper.StudentMapper;
import com.uyeol.personal.student.vo.StudentLoginVO;
import com.uyeol.personal.student.vo.StudentSearchDetailVO;
import com.uyeol.personal.student.vo.StudentStatusUpdateVO;
import com.uyeol.personal.student.vo.StudentUpdateVO;
import com.uyeol.personal.student.vo.StudentVO;

public class StudentServiceImpl implements StudentService {

	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	
	private StudentMapper map = sqlSession.getMapper(StudentMapper.class);
	
	
	@Override
	public List<StudentSearchDetailVO> findAllStudentWithLecture() {
		return map.findAllStudentWithLecture();
	}
	
	@Override
	public List<StudentStatusUpdateVO> findAllStudentForUpdate() {
		return map.findAllStudentForUpdate();
	}
	
	@Override
	public StudentVO findStudentByName(String name) {
		return map.findStudentByName(name);
	}
	
	@Override
	public StudentSearchDetailVO findStudentDetail(String name) {
		return map.findStudentDetail(name);
	}
	
	@Override
	public StudentVO login(StudentLoginVO vo) {	
		return map.findStudentForLogin(vo);
	}


	@Override
	public int createStudent(StudentVO vo) {
		return map.createStudent(vo);
	}


	@Override
	public int updateStudentByName(StudentUpdateVO vo) {
		return map.updateStudentByName(vo);
	}

	@Override
	public int deleteStudentByName(String name) {
		return map.deleteStudentByName(name);
	}
	
}
