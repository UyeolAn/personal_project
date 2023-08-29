package com.uyeol.personal.student.service;

import org.apache.ibatis.session.SqlSession;

import com.uyeol.personal.common.DataSource;
import com.uyeol.personal.student.mapper.StudentMapper;
import com.uyeol.personal.student.vo.StudentLoginVO;
import com.uyeol.personal.student.vo.StudentVO;

public class StudentServiceImpl implements StudentService {

	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	
	private StudentMapper map = sqlSession.getMapper(StudentMapper.class);
	
	
	@Override
	public StudentVO login(StudentLoginVO vo) {	
		return map.findStudentForLogin(vo);
	}


	@Override
	public int join(StudentVO vo) {
		return map.createStudent(vo);
	}

}
