package com.uyeol.personal.student.mapper;

import java.util.List;

import com.uyeol.personal.student.vo.StudentUpdateVO;
import com.uyeol.personal.student.vo.StudentVO;

public interface StudentMapper {

	List<StudentVO> findAllStudents();
	
	StudentVO findStudentByName(String name);
	
	int createStudent(StudentVO vo);
	
	int updateStudentByName(StudentUpdateVO vo);
	
	int deleteStudentByName(String name);

}
