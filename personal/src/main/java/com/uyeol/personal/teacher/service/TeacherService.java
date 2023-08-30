package com.uyeol.personal.teacher.service;

import java.util.List;

import com.uyeol.personal.teacher.vo.TeacherSearchVO;
import com.uyeol.personal.teacher.vo.TeacherVO;

public interface TeacherService {

	List<TeacherVO> findAllTeachers();
	
	List<TeacherSearchVO> findAllTeachersWithLecture();
	
	TeacherVO findTeacherByName(String name);
	
	TeacherSearchVO findTeacherWithLecture(String name);
	
}
