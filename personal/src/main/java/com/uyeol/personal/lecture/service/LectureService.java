package com.uyeol.personal.lecture.service;

import java.util.List;

import com.uyeol.personal.lecture.vo.LectureVO;

public interface LectureService {
	
	List<LectureVO> findAllLectures();
	
	LectureVO findLectureByName(String name);
	
}
