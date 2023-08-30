package com.uyeol.personal.student;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.uyeol.personal.AcademyMenu;
import com.uyeol.personal.common.ManagerFunction;
import com.uyeol.personal.enrollment.service.EnrollmentServiceImpl;
import com.uyeol.personal.enrollment.service.EnrollmentService;
import com.uyeol.personal.enrollment.vo.EnrollmentVO;
import com.uyeol.personal.lecture.service.LectureService;
import com.uyeol.personal.lecture.service.LectureServiceImpl;
import com.uyeol.personal.lecture.vo.LectureVO;
import com.uyeol.personal.student.service.StudentService;
import com.uyeol.personal.student.service.StudentServiceImpl;
import com.uyeol.personal.student.vo.StudentUpdateVO;
import com.uyeol.personal.teacher.service.TeacherService;
import com.uyeol.personal.teacher.service.TeacherServiceImpl;
import com.uyeol.personal.teacher.vo.TeacherSearchVO;

public class StudentMenu {
	
	// field
	private Scanner scn = new Scanner(System.in);
	
	private boolean exit = false;
	
	private StudentService studentService = new StudentServiceImpl();
	
	private LectureService lectureService = new LectureServiceImpl();
	
	private TeacherService teacherService = new TeacherServiceImpl();
	
	private EnrollmentService enrollmentService = new EnrollmentServiceImpl();
	
	
	// main method
	public void runStudentMenu() {
		do {
			printStudentMenu();
			int studentMenu = ManagerFunction.inputNumber();
			
			switch (studentMenu) {
				case 1:
					runSearchLectureMenu();
					break;
				case 2:
					runSearchTeacherMenu();
					break;
				case 3:
					enrollLecture();
					break;
				case 4:
					modifyInfo();
					break;
				case 5:
					dropOut();
					break;
				case 9:
					AcademyMenu.loginStudent = null;
					System.out.println("로그아웃 되었습니다.");
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
	private void printStudentMenu() {
		System.out.println("=======================");
		System.out.println("    < OO 직업전문학교 >    ");
		System.out.println("       학 생 메 뉴        ");
		System.out.println("=======================");
		System.out.println("    1. 강의 조회");
		System.out.println("    2. 강사 조회");
		System.out.println("    3. 수강 신청");
		System.out.println("    4. 개인정보 수정");
		System.out.println("    5. 회원 탈퇴");
		System.out.println("    9. 로그 아웃");
		System.out.println("    0. 프로그램 종료");
		System.out.println("=======================");
		System.out.println("매뉴를 선택하세요 >>");
	}
	
	private void runSearchLectureMenu() {
		printSearchLectureMenu();
		int searchLectureMenu = ManagerFunction.inputNumber();
		
		switch (searchLectureMenu) {
			case 1:
				showLecture();
				break;
			case 2:
				showAllLectures();
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
	
	private void printSearchLectureMenu() {
		System.out.println("=======================");
		System.out.println("    < OO 직업전문학교 >    ");
		System.out.println("       강 의 조 회        ");
		System.out.println("=======================");
		System.out.println("    1. 강의 단건 조회");
		System.out.println("    2. 강의 전체 조회");
		System.out.println("    9. 이전으로");
		System.out.println("    0. 프로그램 종료");
		System.out.println("=======================");
		System.out.println("매뉴를 선택하세요 >>");
	}
	
	private void showLecture() {
		System.out.println("------------------------");
		System.out.println("     강의 단건 조회 입니다    ");
		System.out.println("------------------------");
		
		System.out.println("강의 이름을 입력하세요 >>");
		String name = scn.nextLine();
		
		LectureVO searchedVO = lectureService.findLectureByName(name);
		if (searchedVO != null) {
			System.out.println("------------------------");
			System.out.printf("이름 : %s\n", searchedVO.getLectureName());
			System.out.printf("기간 : %s ~ %s\n",
					searchedVO.getLectureStartDate().format(AcademyMenu.formatter),
					searchedVO.getLectureEndDate().format(AcademyMenu.formatter));
			System.out.printf("모집 인원 : %d명", searchedVO.getMaxNumStudents());
			if (searchedVO.isStarted()) {
				System.out.println("-진행중-");
			} else {
				System.out.println("-모집중-");
			}
			System.out.println("------------------------");
		} else {
			System.out.println("해당 이름의 강의는 없습니다.");
		}
	}
	
	private void showAllLectures() {
		System.out.println("------------------------");
		System.out.println("     강의 전체 조회 입니다    ");
		System.out.println("------------------------");
		
		List<LectureVO> lectureList = lectureService.findAllLectures();
		
		System.out.println("------------------------");
		for (LectureVO vo : lectureList) {
			System.out.printf("[%s] %s~%s <%s>\n",
					vo.getLectureName(),
					vo.getLectureStartDate().format(AcademyMenu.formatter),
					vo.getLectureEndDate().format(AcademyMenu.formatter),
					vo.isStarted() ? "진행중" : "모집중");
		}
		System.out.println("------------------------");
	}
	
	private void runSearchTeacherMenu() {
		printSearchTeacherMenu();
		int searchTeacherMenu = ManagerFunction.inputNumber();
		
		switch (searchTeacherMenu) {
			case 1:
				showTeacher();
				break;
			case 2:
				showAllTeachers();
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
	
	private void printSearchTeacherMenu() {
		System.out.println("=======================");
		System.out.println("    < OO 직업전문학교 >    ");
		System.out.println("       강 사 조 회        ");
		System.out.println("=======================");
		System.out.println("    1. 강사 단건 조회");
		System.out.println("    2. 강사 전체 조회");
		System.out.println("    9. 이전으로");
		System.out.println("    0. 프로그램 종료");
		System.out.println("=======================");
		System.out.println("매뉴를 선택하세요 >>");
	}

	private void showTeacher() {
		System.out.println("------------------------");
		System.out.println("     강사 단건 조회 입니다    ");
		System.out.println("------------------------");
		
		System.out.println("강사 이름을 입력하세요 >>");
		String name = scn.nextLine();
		
		TeacherSearchVO searchedVO = teacherService.findTeacherWithLecture(name);
		if (searchedVO != null) {
			System.out.println("------------------------");
			System.out.printf("이름 : %s\n", searchedVO.getTeacherName());
			System.out.printf("정보 : %s\n", searchedVO.getTeacherInfo());
			System.out.printf("담당강의 : %s\n", searchedVO.getLectureName());
			System.out.println("------------------------");
		} else {
			System.out.println("해당 이름의 강사는 없습니다.");
		}
	}
	
	private void showAllTeachers() {
		System.out.println("------------------------");
		System.out.println("     강사 전체 조회 입니다    ");
		System.out.println("------------------------");
		
		List<TeacherSearchVO> teacherList = teacherService.findAllTeachersWithLecture();
		
		System.out.println("------------------------");
		for (TeacherSearchVO vo : teacherList) {
			System.out.printf("이름 : %s, 담당강의 : %s\n",
					vo.getTeacherName(), vo.getLectureName());
		}
		System.out.println("------------------------");
	}
	
	private void enrollLecture() {
		System.out.println("------------------------");
		System.out.println("      수강 신청 입니다       ");
		System.out.println("------------------------");
		
		System.out.println("신청하실 강의 이름을 입력하세요 >>");
		String name = scn.nextLine();
		
		LectureVO enrollLecture = lectureService.findLectureByName(name);
		EnrollmentVO enrollment = new EnrollmentVO(
				AcademyMenu.id_sequence++, 
				AcademyMenu.loginStudent.getStudentId(),
				enrollLecture.getLectureId());
		
		int numIns = enrollmentService.createEnrollment(enrollment);
		if (numIns != 0) {
			System.out.println("수강신청 접수가 완료되었습니다.");
		} else {
			System.out.println("해당 이름의 강의는 존재하지 않습니다.");
		}
	}
	
	private void modifyInfo() {
		System.out.println("------------------------");
		System.out.println("     개인정보 수정 입니다     ");
		System.out.println("------------------------");
		
		System.out.println("비밀번호를 입력하세요 >>");
		String password = scn.nextLine();
		
		if (password.equals(AcademyMenu.loginStudent.getStudentPassword())) {
			runModifyInfoMenu();
		}
	}
	
	private void runModifyInfoMenu() {
		printModifyInfoMenu();
		int modifyInfoMenu = ManagerFunction.inputNumber();
		
		switch (modifyInfoMenu) {
			case 1:
				changeEmail();
				break;
			case 2:
				changePassword();
				break;
			case 3:
				changeEtcInfo();
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
	
	private void printModifyInfoMenu() {
		System.out.println("=======================");
		System.out.println("    < OO 직업전문학교 >    ");
		System.out.println("       개인정보 수정       ");
		System.out.println("=======================");
		System.out.println("    1. 이메일 변경");
		System.out.println("    2. 비밀번호 변경");
		System.out.println("    3. 기타정보 수정");
		System.out.println("    9. 이전으로");
		System.out.println("    0. 프로그램 종료");
		System.out.println("=======================");
		System.out.println("매뉴를 선택하세요 >>");
	}
	
	private void changeEmail() {
		System.out.println("------------------------");
		System.out.println("     이메일 변경 입니다      ");
		System.out.println("------------------------");
		
		System.out.println("새로운 이메일을 입력하세요 >>");
		String newEmail = scn.nextLine();
		
		StudentUpdateVO updateVO = new StudentUpdateVO(
				AcademyMenu.loginStudent.getStudentName(),
				newEmail, null, null, null, null);
		
		int numUpd = studentService.updateStudentByName(updateVO);
		if (numUpd != 0) {
			AcademyMenu.loginStudent = studentService.findStudentByName(
					AcademyMenu.loginStudent.getStudentName());
			System.out.println("수정이 완료되었습니다.");
		} else {
			System.out.println("수정에 실패하였습니다.");
		}
	}
	
	private void changePassword() {
		System.out.println("------------------------");
		System.out.println("     비밀번호 변경 입니다     ");
		System.out.println("------------------------");
		
		System.out.println("새로운 비밀번호를 입력하세요 >>");
		String newPassword = scn.nextLine();
		
		StudentUpdateVO updateVO = new StudentUpdateVO(
				AcademyMenu.loginStudent.getStudentName(),
				null, newPassword, null, null, null);
		
		int numUpd = studentService.updateStudentByName(updateVO);
		if (numUpd != 0) {
			AcademyMenu.loginStudent = studentService.findStudentByName(
					AcademyMenu.loginStudent.getStudentName());
			System.out.println("수정이 완료되었습니다.");
		} else {
			System.out.println("수정에 실패하였습니다.");
		}
	}
	
	private void changeEtcInfo() {
		System.out.println("------------------------");
		System.out.println("     기타정보 수정 입니다     ");
		System.out.println("------------------------");
		
		System.out.println("새로운 이름을 입력하세요 >>");
		String newName = scn.nextLine();
		
		System.out.println("새로운 생년월일을 입력하세요 >>");
		LocalDate newBirth = LocalDate.parse(scn.nextLine(), AcademyMenu.formatter);
		
		System.out.println("새로운 연락처을 입력하세요 >>");
		String newTel = scn.nextLine();
		
		StudentUpdateVO updateVO = new StudentUpdateVO(
				AcademyMenu.loginStudent.getStudentName(),
				null, null, newName, newBirth, newTel);
		
		int numUpd = studentService.updateStudentByName(updateVO);
		if (numUpd != 0) {
			AcademyMenu.loginStudent = studentService.findStudentByName(newName);
			System.out.println("수정이 완료되었습니다.");
		} else {
			System.out.println("수정에 실패하였습니다.");
		}
	}
	
	private void dropOut() {
		System.out.println("------------------------");
		System.out.println("      회원 탈퇴 입니다       ");
		System.out.println("------------------------");
		
		System.out.println("비밀번호를 입력하세요 >>");
		String password = scn.nextLine();
		
		if (password.equals(AcademyMenu.loginStudent.getStudentPassword())) {
			int numDel = studentService.deleteStudentByName(
					AcademyMenu.loginStudent.getStudentName());
			if (numDel != 0) {
				System.out.println("탈퇴하셨습니다.");
				AcademyMenu.loginStudent = null;
				exit = true;
			} else {
				System.out.println("회원 탈되에 실패하였습니다.");
			}
		}
	}
}
