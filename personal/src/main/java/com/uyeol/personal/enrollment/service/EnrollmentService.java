package com.uyeol.personal.enrollment.service;

import java.util.List;

import com.uyeol.personal.enrollment.vo.EnrollmentSearchVO;
import com.uyeol.personal.enrollment.vo.EnrollmentTakeVO;
import com.uyeol.personal.enrollment.vo.EnrollmentVO;

public interface EnrollmentService {
	
	List<EnrollmentSearchVO> findEnrollmentSearchVOs();
	
	List<EnrollmentSearchVO> findEnrollmentSearchVOsByStudent(String name);
	
	List<EnrollmentSearchVO> findEnrollmentSearchVOsByLecture(String name);
	
	List<EnrollmentSearchVO> findNotEnrolledEnrollmentSearchVOs();
	
	List<EnrollmentSearchVO> findEnrolledEnrollmentSearchVOs();

	EnrollmentVO findEnrollmentByStudentId(int id);
	
	EnrollmentVO findEnrollmentForTake(EnrollmentTakeVO vo);
	
	int createEnrollment(EnrollmentVO vo);
	
	int updateEnrollmentByStudentId(EnrollmentVO vo);
	
	int deleteEnrollmentByStudentId(int id);
	
}
