package com.uyeol.personal.lecture.mapper;

import java.util.List;

import com.uyeol.personal.lecture.vo.LectureUpdateVO;
import com.uyeol.personal.lecture.vo.LectureVO;

public interface LectureMapper {
	
	List<LectureVO> findAllLectures();
	
	LectureVO findLectureByName(String name);
	
	int createLecture(LectureVO vo);
	
	int updateLectureByName(LectureUpdateVO vo);
	
	int plusNumStudents(String name);
	
	int minusNumStudents(String name);
	
	int deleteLectureByName(String name);
	
}
