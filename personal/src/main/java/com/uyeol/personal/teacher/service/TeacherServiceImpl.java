package com.uyeol.personal.teacher.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.uyeol.personal.common.DataSource;
import com.uyeol.personal.teacher.mapper.TeacherMapper;
import com.uyeol.personal.teacher.vo.TeacherSearchVO;
import com.uyeol.personal.teacher.vo.TeacherVO;

public class TeacherServiceImpl implements TeacherService {

	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	
	private TeacherMapper map = sqlSession.getMapper(TeacherMapper.class);
	
	
	@Override
	public List<TeacherVO> findAllTeachers() {
		return map.findAllTeachers();
	}

	@Override
	public List<TeacherSearchVO> findAllTeachersWithLecture() {
		return map.findAllTeachersWithLecture();
	}
	
	@Override
	public TeacherVO findTeacherByName(String name) {
		return map.findTeacherByName(name);
	}

	@Override
	public TeacherSearchVO findTeacherWithLecture(String name) {
		return map.findTeacherWithLecture(name);
	}

	

}
