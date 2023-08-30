package com.uyeol.personal.enrollment.service;

import com.uyeol.personal.enrollment.vo.EnrollmentVO;

public interface EnrollmentService {

	EnrollmentVO findEnrollmentByStudentId(int id);
	
	int createEnrollment(EnrollmentVO vo);
	
	int deleteEnrollmentByStudentId(int id);
	
}
