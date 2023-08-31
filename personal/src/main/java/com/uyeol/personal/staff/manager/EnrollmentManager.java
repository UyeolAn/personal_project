package com.uyeol.personal.staff.manager;

import java.util.List;
import java.util.Scanner;

import com.uyeol.personal.AcademyMenu;
import com.uyeol.personal.common.ManagerFunction;
import com.uyeol.personal.enrollment.service.EnrollmentService;
import com.uyeol.personal.enrollment.service.EnrollmentServiceImpl;
import com.uyeol.personal.enrollment.vo.EnrollmentSearchVO;
import com.uyeol.personal.enrollment.vo.EnrollmentTakeVO;
import com.uyeol.personal.enrollment.vo.EnrollmentVO;
import com.uyeol.personal.lecture.service.LectureService;
import com.uyeol.personal.lecture.service.LectureServiceImpl;
import com.uyeol.personal.student.service.StudentService;
import com.uyeol.personal.student.service.StudentServiceImpl;
import com.uyeol.personal.student.vo.Status;
import com.uyeol.personal.student.vo.StudentUpdateVO;
import com.uyeol.personal.student.vo.StudentVO;

public class EnrollmentManager {

	// field
	private Scanner scn = new Scanner(System.in);
	
	private boolean exit = false;
	
	private EnrollmentService enrollmentService = new EnrollmentServiceImpl();
	
	private StudentService studentService = new StudentServiceImpl();
	
	private LectureService lectureService = new LectureServiceImpl();
	
	
	// main method
	public void runMenu() {
		do {
			printMenu();
			int menu = ManagerFunction.inputNumber();
			
			switch (menu) {
				case 1:
					runSearchEnrollmentMenu();
					break;
				case 2:
					takeEnrollment();
					break;
				case 3:
					cancelEnrollment();
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
		System.out.println("     수강신청 관리 메뉴      ");
		System.out.println("=======================");
		System.out.println("    1. 수강신청 조회");
		System.out.println("    2. 수강신청 접수");
		System.out.println("    3. 수강신청 취소");
		System.out.println("    9. 이전으로");
		System.out.println("    0. 프로그램 종료");
		System.out.println("=======================");
		System.out.println("매뉴를 선택하세요 >>");
	}
	
	private void runSearchEnrollmentMenu() {
		printSearchEnrollmentMenu();
		int searchEnrollmentMenu = ManagerFunction.inputNumber();
		
		switch (searchEnrollmentMenu) {
			case 1:
				showAllEnrollments();
				break;
			case 2:
				showEnrollmentsByStudent();
				break;
			case 3:
				showEnrollmentsByLecture();
				break;
			case 4:
				showNotEnrolledEnrollments();
				break;
			case 5:
				showEnrolledEnrollments();
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
	
	private void printSearchEnrollmentMenu() {
		System.out.println("=======================");
		System.out.println("    < OO 직업전문학교 >    ");
		System.out.println("       수강신청 조회       ");
		System.out.println("=======================");
		System.out.println("    1. 전체 조회");
		System.out.println("    2. 학생 이름으로 조회");
		System.out.println("    3. 강의 이름으로 조회");
		System.out.println("    4. 미접수 강의 조회");
		System.out.println("    5. 접수된 강의 조회");
		System.out.println("    9. 이전으로");
		System.out.println("    0. 프로그램 종료");
		System.out.println("=======================");
		System.out.println("매뉴를 선택하세요 >>");
	}
	
	private void showAllEnrollments() {
		System.out.println("------------------------");
		System.out.println("      전체 조회 입니다       ");
		System.out.println("------------------------");
		
		List<EnrollmentSearchVO> enrollmentList = 
				enrollmentService.findEnrollmentSearchVOs();
		
		System.out.println("------------------------");
		for (EnrollmentSearchVO vo : enrollmentList) {
			System.out.printf("[%s - %s] %s (%s)\n",
					vo.getStudentName(), vo.getLectureName(),
					vo.getEnrollmentDate().format(AcademyMenu.formatter),
					vo.isEnrolled() ? "접수됨" : "미접수");
		}
		System.out.println("------------------------");
	}
	
	private void showEnrollmentsByStudent() {
		System.out.println("------------------------");
		System.out.println("   학생 이름으로 조회 입니다   ");
		System.out.println("------------------------");
		
		System.out.println("학생 이름을 입력하세요 >>");
		String name = scn.nextLine();
		
		List<EnrollmentSearchVO> enrollmentList = 
				enrollmentService.findEnrollmentSearchVOsByStudent(name);
		
		System.out.println("------------------------");
		for (EnrollmentSearchVO vo : enrollmentList) {
			System.out.printf("[%s - %s] %s (%s)\n",
					vo.getStudentName(), vo.getLectureName(),
					vo.getEnrollmentDate().format(AcademyMenu.formatter),
					vo.isEnrolled() ? "접수됨" : "미접수");
		}
		System.out.println("------------------------");
	}
	
	private void showEnrollmentsByLecture() {
		System.out.println("------------------------");
		System.out.println("   강의 이름으로 조회 입니다   ");
		System.out.println("------------------------");
		
		System.out.println("강의 이름을 입력하세요 >>");
		String name = scn.nextLine();
		
		List<EnrollmentSearchVO> enrollmentList = 
				enrollmentService.findEnrollmentSearchVOsByLecture(name);
		
		System.out.println("------------------------");
		for (EnrollmentSearchVO vo : enrollmentList) {
			System.out.printf("[%s - %s] %s (%s)\n",
					vo.getStudentName(), vo.getLectureName(),
					vo.getEnrollmentDate().format(AcademyMenu.formatter),
					vo.isEnrolled() ? "접수됨" : "미접수");
		}
		System.out.println("------------------------");
	}
	
	private void showNotEnrolledEnrollments() {
		System.out.println("------------------------");
		System.out.println("    미접수 신청 조회 입니다    ");
		System.out.println("------------------------");
		
		List<EnrollmentSearchVO> enrollmentList = 
				enrollmentService.findNotEnrolledEnrollmentSearchVOs();
		
		System.out.println("------------------------");
		for (EnrollmentSearchVO vo : enrollmentList) {
			System.out.printf("[%s - %s] %s (%s)\n",
					vo.getStudentName(), vo.getLectureName(),
					vo.getEnrollmentDate().format(AcademyMenu.formatter),
					vo.isEnrolled() ? "접수됨" : "미접수");
		}
		System.out.println("------------------------");
	}
	
	private void showEnrolledEnrollments() {
		System.out.println("------------------------");
		System.out.println("    접수된 신청 조회 입니다    ");
		System.out.println("------------------------");
		
		List<EnrollmentSearchVO> enrollmentList = 
				enrollmentService.findEnrolledEnrollmentSearchVOs();
		
		System.out.println("------------------------");
		for (EnrollmentSearchVO vo : enrollmentList) {
			System.out.printf("[%s - %s] %s (%s)\n",
					vo.getStudentName(), vo.getLectureName(),
					vo.getEnrollmentDate().format(AcademyMenu.formatter),
					vo.isEnrolled() ? "접수됨" : "미접수");
		}
		System.out.println("------------------------");
	}
	
	private void takeEnrollment() {
		System.out.println("------------------------");
		System.out.println("     수강신청 접수 입니다     ");
		System.out.println("------------------------");
		
		System.out.println("학생 이름을 입력하세요 >>");
		String studentName = scn.nextLine();
		
		System.out.println("강의 이름을 입력하세요 >>");
		String lectureName = scn.nextLine();
		
		EnrollmentVO enrollmentVO = enrollmentService.findEnrollmentForTake(
				new EnrollmentTakeVO(studentName, lectureName));
		if (enrollmentVO != null) {
			if (!enrollmentVO.isEnrolled()) {
				int numEnUpd = enrollmentService.updateEnrollmentByStudentId(
						new EnrollmentVO(true, enrollmentVO.getStudentId(), 0));
				int numStdUpd = studentService.updateStudentByName(
						new StudentUpdateVO(studentName, 
								Status.SCHEDULED, 
								enrollmentVO.getLectureId()));
				int numLecUpd = lectureService.plusNumStudents(lectureName);
				if (numEnUpd != 0 && numStdUpd != 0 && numLecUpd != 0) {
					System.out.println("수강신청 접수가 완료되었습니다.");
				} else {
					System.out.println("수강신청 접수에 실패하였습니다.");
				}
			} else {
				System.out.println("이미 접수된 수강신청 입니다.");
			}
		} else {
			System.out.println("해당 정보의 수강신청은 없습니다.");
		}
	}
	
	private void cancelEnrollment() {
		System.out.println("------------------------");
		System.out.println("     수강신청 취소 입니다     ");
		System.out.println("------------------------");
		
		System.out.println("학생 이름을 입력하세요 >>");
		String studentName = scn.nextLine();
		
		System.out.println("강의 이름을 입력하세요 >>");
		String lectureName = scn.nextLine();
		
		StudentVO searchedVO = studentService.findStudentByName(studentName);
		if (searchedVO != null) {
			EnrollmentVO searchEnroll = 
					enrollmentService.findEnrollmentByStudentId(searchedVO.getStudentId());
			if (searchEnroll != null) {
				if (searchedVO.getStatus() != Status.NONE &&
					searchedVO.getStatus() != Status.SCHEDULED) {
					System.out.println("해당 학생은 수강신청 취소가 불가능한 상태입니다.");
				} else {
					int numEnDel = enrollmentService.deleteEnrollmentByStudentId(
							searchedVO.getStudentId());
					int numStdUpd = studentService.updateStudentByName(
							new StudentUpdateVO(studentName, Status.CANCEL, 0));
					int numLecUpd = lectureService.minusNumStudents(lectureName);
					if (numEnDel != 0 && numStdUpd != 0 && numLecUpd != 0) {
						System.out.println("수강신청 취소가 완료되었습니다.");
					} else {
						System.out.println("수강신청 취소에 실패하였습니다.");
					}
				}
			} else {
				System.out.println("해당 학생은 수강신청을 하지 않았습니다.");
			}
		} else {
			System.out.println("해당 이름의 학생은 없습니다.");
		}
	}
	
}
