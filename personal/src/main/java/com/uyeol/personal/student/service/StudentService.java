package com.uyeol.personal.student.service;

import com.uyeol.personal.student.vo.StudentLoginVO;
import com.uyeol.personal.student.vo.StudentVO;

public interface StudentService {
	
	StudentVO login(StudentLoginVO vo);
	
	int join(StudentVO vo);
	
}
