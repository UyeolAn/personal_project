package com.uyeol.personal.student.mapper;

import java.util.List;

import com.uyeol.personal.student.vo.StudentLoginVO;
import com.uyeol.personal.student.vo.StudentSearchDetailVO;
import com.uyeol.personal.student.vo.StudentStatusUpdateVO;
import com.uyeol.personal.student.vo.StudentUpdateVO;
import com.uyeol.personal.student.vo.StudentVO;

public interface StudentMapper {

	List<StudentSearchDetailVO> findAllStudentWithLecture();
	
	List<StudentStatusUpdateVO> findAllStudentForUpdate();
	
	List<StudentVO> findAllStudents();
	
	StudentVO findStudentByName(String name);
	
	StudentSearchDetailVO findStudentDetail(String name);
	
	StudentVO findStudentForLogin(StudentLoginVO vo);
	
	int createStudent(StudentVO vo);
	
	int updateStudentByName(StudentUpdateVO vo);
	
	int deleteStudentByName(String name);

}
