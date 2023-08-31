package com.uyeol.personal.lecture.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.uyeol.personal.common.DataSource;
import com.uyeol.personal.lecture.mapper.LectureMapper;
import com.uyeol.personal.lecture.vo.LectureUpdateVO;
import com.uyeol.personal.lecture.vo.LectureVO;

public class LectureServiceImpl implements LectureService {

	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	
	private LectureMapper map = sqlSession.getMapper(LectureMapper.class);
	
	
	@Override
	public List<LectureVO> findAllLectures() {
		return map.findAllLectures();
	}
	
	@Override
	public LectureVO findLectureByName(String name) {
		return map.findLectureByName(name);
	}

	@Override
	public int createLecture(LectureVO vo) {
		return map.createLecture(vo);
	}

	@Override
	public int updateLectureByName(LectureUpdateVO vo) {
		return map.updateLectureByName(vo);
	}
	
	@Override
	public int plusNumStudents(String name) {
		return map.plusNumStudents(name);
	}
	
	@Override
	public int minusNumStudents(String name) {
		return map.minusNumStudents(name);
	}

	@Override
	public int deleteLectureByName(String name) {
		return map.deleteLectureByName(name);
	}

	

}
