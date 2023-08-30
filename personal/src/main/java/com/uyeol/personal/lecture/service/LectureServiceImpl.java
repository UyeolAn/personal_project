package com.uyeol.personal.lecture.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.uyeol.personal.common.DataSource;
import com.uyeol.personal.lecture.mapper.LectureMapper;
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

}
