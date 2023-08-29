package com.uyeol.personal.teacher.mapper;

import java.util.List;

import com.uyeol.personal.teacher.vo.TeacherUpdateVO;
import com.uyeol.personal.teacher.vo.TeacherVO;

public interface TeacherMapper {
	
	List<TeacherVO> findAllTeachers();
	
	TeacherVO findTeacherByName(String name);
	
	int createTeacher(TeacherVO vo);
	
	int updateTeacherByName(TeacherUpdateVO vo);
	
	int deleteTeacherByName(String name);
	
}
