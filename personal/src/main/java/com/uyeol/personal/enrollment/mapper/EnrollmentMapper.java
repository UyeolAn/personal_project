package com.uyeol.personal.enrollment.mapper;

import java.util.List;

import com.uyeol.personal.enrollment.vo.EnrollmentVO;

public interface EnrollmentMapper {

	List<EnrollmentVO> findAllEnrollments();
	
	List<EnrollmentVO> findEnrolledEnrollments();
	
	List<EnrollmentVO> findNonEnrolledEnrollments();
	
	EnrollmentVO findEnrollmentByStudentId(int id);
	
	EnrollmentVO findEnrollmentByLectureId(int id);
	
	int createEnrollment(EnrollmentVO vo);
	
	int updateEnrollmentByStudentId(EnrollmentVO vo);
	
	int deleteEnrollmentByStudentId(int id);
	
}
