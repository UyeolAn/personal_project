package com.uyeol.personal.enrollment.mapper;

import java.util.List;

import com.uyeol.personal.enrollment.vo.EnrollmentSearchVO;
import com.uyeol.personal.enrollment.vo.EnrollmentTakeVO;
import com.uyeol.personal.enrollment.vo.EnrollmentVO;

public interface EnrollmentMapper {

	List<EnrollmentSearchVO> findEnrollmentSearchVOs();
	
	List<EnrollmentSearchVO> findEnrollmentSearchVOsByStudent(String name);
	
	List<EnrollmentSearchVO> findEnrollmentSearchVOsByLecture(String name);
	
	List<EnrollmentSearchVO> findNotEnrolledEnrollmentSearchVOs();
	
	List<EnrollmentSearchVO> findEnrolledEnrollmentSearchVOs();
	
	EnrollmentVO findEnrollmentByStudentId(int id);
	
	EnrollmentVO findEnrollmentByLectureId(int id);
	
	EnrollmentVO findEnrollmentForTake(EnrollmentTakeVO vo);
	
	int createEnrollment(EnrollmentVO vo);
	
	int updateEnrollmentByStudentId(EnrollmentVO vo);
	
	int deleteEnrollmentByStudentId(int id);
	
}
