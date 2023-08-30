package com.uyeol.personal.student.service;

import java.util.List;

import com.uyeol.personal.student.vo.StudentLoginVO;
import com.uyeol.personal.student.vo.StudentSearchDetailVO;
import com.uyeol.personal.student.vo.StudentStatusUpdateVO;
import com.uyeol.personal.student.vo.StudentUpdateVO;
import com.uyeol.personal.student.vo.StudentVO;

public interface StudentService {
	
	List<StudentSearchDetailVO> findAllStudentWithLecture();
	
	List<StudentStatusUpdateVO> findAllStudentForUpdate();
	
	StudentVO findStudentByName(String name);
	
	StudentSearchDetailVO findStudentDetail(String name);
	
	StudentVO login(StudentLoginVO vo);
	
	int createStudent(StudentVO vo);
	
	int updateStudentByName(StudentUpdateVO vo);
	
	int deleteStudentByName(String name);
	
}
