package com.uyeol.personal.staff.manager;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.uyeol.personal.AcademyMenu;
import com.uyeol.personal.common.ManagerFunction;
import com.uyeol.personal.enrollment.service.EnrollmentService;
import com.uyeol.personal.enrollment.service.EnrollmentServiceImpl;
import com.uyeol.personal.enrollment.vo.EnrollmentVO;
import com.uyeol.personal.student.service.StudentService;
import com.uyeol.personal.student.service.StudentServiceImpl;
import com.uyeol.personal.student.vo.Status;
import com.uyeol.personal.student.vo.StudentSearchDetailVO;
import com.uyeol.personal.student.vo.StudentStatusUpdateVO;
import com.uyeol.personal.student.vo.StudentUpdateVO;
import com.uyeol.personal.student.vo.StudentVO;

public class StudentManager {

	// field
	private Scanner scn = new Scanner(System.in);
	
	private boolean exit = false;
	
	private StudentService studentService = new StudentServiceImpl();
	
	private EnrollmentService enrollmentService = new EnrollmentServiceImpl();
	
	
	// main method
	public void runMenu() {
		do {
			printMenu();
			int menu = ManagerFunction.inputNumber();
			
			switch (menu) {
				case 1:
					runSearchStudentMenu();
					break;
				case 2:
					failProcess();
					break;
				case 3:
					cancelEnrollment();
					break;
				case 4:
					updateStatus();
					break;
				case 5:
					deleteStudent();
					break;
				case 9:
					System.out.println("이전메뉴로 돌아갑니다.");
					exit = true;
					break;
				case 0:
					ManagerFunction.exitProgram();
					break;
				default:
					break;
			}
		} while (!exit);
		
		
		
	}
	
	
	// sub method
	private void printMenu() {
		System.out.println("=======================");
		System.out.println("    < OO 직업전문학교 >    ");
		System.out.println("      학생 관리 메뉴       ");
		System.out.println("=======================");
		System.out.println("    1. 학생 조회");
		System.out.println("    2. 중도탈락 처리");
		System.out.println("    3. 수강신청 취소처리");
		System.out.println("    4. 상태 업데이트");
		System.out.println("    5. 학생정보 강제삭제");
		System.out.println("    9. 이전으로");
		System.out.println("    0. 프로그램 종료");
		System.out.println("=======================");
		System.out.println("매뉴를 선택하세요 >>");
	}
	
	private void runSearchStudentMenu() {
		printSearchStudentMenu();
		int searchStudentMenu = ManagerFunction.inputNumber();
		
		switch (searchStudentMenu) {
			case 1:
				showStudentDetail();
				break;
			case 2:
				showAllStudents();
				break;
			case 9:
				System.out.println("메인메뉴로 나갑니다.");
				break;
			case 0:
				ManagerFunction.exitProgram();
				break;
			default:
				break;
		}
	}
	
	private void printSearchStudentMenu() {
		System.out.println("=======================");
		System.out.println("    < OO 직업전문학교 >    ");
		System.out.println("       학 생 조 회        ");
		System.out.println("=======================");
		System.out.println("    1. 학생 단건 상세 조회");
		System.out.println("    2. 학생 전체 조회");
		System.out.println("    9. 이전으로");
		System.out.println("    0. 프로그램 종료");
		System.out.println("=======================");
		System.out.println("매뉴를 선택하세요 >>");
	}
	
	private void showStudentDetail() {
		System.out.println("------------------------");
		System.out.println("   학생 단건 상세 조회 입니다  ");
		System.out.println("------------------------");
		
		System.out.println("학생 이름을 입력하세요 >>");
		String name = scn.nextLine();
		
		StudentSearchDetailVO searchedVO = studentService.findStudentDetail(name);
		if (searchedVO != null) {
			System.out.println("------------------------");
			System.out.printf("ID : %s\n", searchedVO.getStudentId());
			System.out.printf("이름 : %s\n", searchedVO.getStudentName());
			System.out.printf("이메일 : %s\n", searchedVO.getStudentEmail());
			System.out.printf("생년월일 : %s\n", 
					searchedVO.getStudentBirth().format(AcademyMenu.formatter));
			System.out.printf("전화번호 : %s\n", searchedVO.getStudentTel());
			System.out.printf("가입일 : %s\n", 
					searchedVO.getEnterDate().format(AcademyMenu.formatter));
			System.out.printf("수강중인 강의 : %s\n", searchedVO.getLectureName());
			System.out.printf("상태 : %s\n", searchedVO.getStatus().getName());
			System.out.println("------------------------");
		} else {
			System.out.println("해당 이름의 학생은 없습니다.");
		}
	}
	
	private void showAllStudents() {
		System.out.println("------------------------");
		System.out.println("    학생 전체 조회 입니다     ");
		System.out.println("------------------------");
		
		List<StudentSearchDetailVO> studentList = studentService.findAllStudentWithLecture();
		
		System.out.println("------------------------");
		for (StudentSearchDetailVO vo : studentList) {
			System.out.printf("이름 : %s, 강의 : %s, 상태 : %s\n",
					vo.getStudentName(), vo.getLectureName(), vo.getStatus().getName());
		}
		System.out.println("------------------------");
	}
	
	private void failProcess() {
		System.out.println("------------------------");
		System.out.println("     중도탈락 처리 입니다     ");
		System.out.println("------------------------");
		
		System.out.println("학생 이름을 입력하세요 >>");
		String name = scn.nextLine();
		
		StudentVO searchedVO = studentService.findStudentByName(name);
		if (searchedVO != null) {
			if (searchedVO.getStatus() != Status.FAIL) {
				searchedVO.setStatus(Status.FAIL);
				System.out.println("탈락 처리 되었습니다.");
			} else {
				System.out.println("이미 탈락한 학생입니다.");
			}
		} else {
			System.out.println("해당 이름의 학생은 없습니다.");
		}
	}
	
	private void cancelEnrollment() {
		System.out.println("------------------------");
		System.out.println("     수강신청 취소 입니다     ");
		System.out.println("------------------------");
		
		System.out.println("학생 이름을 입력하세요 >>");
		String name = scn.nextLine();
		
		StudentVO searchedVO = studentService.findStudentByName(name);
		if (searchedVO != null) {
			EnrollmentVO searchEnroll = 
					enrollmentService.findEnrollmentByStudentId(searchedVO.getStudentId());
			if (searchEnroll != null) {
				if (searchedVO.getStatus() != Status.NONE &&
					searchedVO.getStatus() != Status.SCHEDULED) {
					System.out.println("해당 학생은 수강신청 취소가 불가능한 상태입니다.");
				} else {
					enrollmentService.deleteEnrollmentByStudentId(searchedVO.getStudentId());
					searchedVO.setStatus(Status.CANCEL);
					System.out.println("수강신청 취소가 완료되었습니다.");
				}
			} else {
				System.out.println("해당 학생은 수강신청을 하지 않았습니다.");
			}
		} else {
			System.out.println("해당 이름의 학생은 없습니다.");
		}
	}
	
	private void updateStatus() {
		System.out.println("------------------------");
		System.out.println("     상태 업데이트 입니다     ");
		System.out.println("------------------------");
		
		List<StudentStatusUpdateVO> studentList = 
				studentService.findAllStudentForUpdate();
		
		int numUpd = 0;
		for (StudentStatusUpdateVO vo : studentList) {
			if (vo.getLectureEndDate().isBefore(LocalDate.now())) {
				numUpd += studentService.updateStudentByName(
						new StudentUpdateVO(vo.getStudentName(), Status.FINISH));
			} else if (vo.getLectureStartDate().isBefore(LocalDate.now())) {
				numUpd += studentService.updateStudentByName(
						new StudentUpdateVO(vo.getStudentName(), Status.INCLASS));
			}
		}
		if (numUpd != 0) {
			System.out.println(numUpd + "건의 상태정보가 업데이트 되었습니다.");
		}
	}
	
	private void deleteStudent() {
		System.out.println("------------------------");
		System.out.println("    학생정보 강제삭제 입니다   ");
		System.out.println("------------------------");
		
		System.out.println("학생 이름을 입력하세요 >>");
		String name = scn.nextLine();
		
		int numDel = studentService.deleteStudentByName(name);
		if (numDel != 0) {
			System.out.println("삭제가 완료되었습니다.");
		} else {
			System.out.println("해당 이름의 학생은 없습니다.");
		}
	}
	
}
