package com.uyeol.personal.staff.manager;

import java.util.List;
import java.util.Scanner;

import com.uyeol.personal.AcademyMenu;
import com.uyeol.personal.common.ManagerFunction;
import com.uyeol.personal.lecture.service.LectureService;
import com.uyeol.personal.lecture.service.LectureServiceImpl;
import com.uyeol.personal.lecture.vo.LectureVO;
import com.uyeol.personal.teacher.service.TeacherService;
import com.uyeol.personal.teacher.service.TeacherServiceImpl;
import com.uyeol.personal.teacher.vo.TeacherSearchDetailVO;
import com.uyeol.personal.teacher.vo.TeacherSearchVO;
import com.uyeol.personal.teacher.vo.TeacherUpdateVO;
import com.uyeol.personal.teacher.vo.TeacherVO;

public class TeacherManager {

	// field
	private Scanner scn = new Scanner(System.in);
	
	private boolean exit = false;
	
	private TeacherService teacherService = new TeacherServiceImpl();
	
	private LectureService lectureService = new LectureServiceImpl();
	
	
	// main method
	public void runMenu() {
		do {
			printMenu();
			int menu = ManagerFunction.inputNumber();
			
			switch (menu) {
				case 1:
					runSearchTeacherMenu();
					break;
				case 2:
					addTeacher();
					break;
				case 3:
					updateTeacher();
					break;
				case 4:
					deleteTeacher();
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
		System.out.println("      강사 관리 메뉴       ");
		System.out.println("=======================");
		System.out.println("    1. 강사 조회");
		System.out.println("    2. 강사 등록");
		System.out.println("    3. 강사정보 수정");
		System.out.println("    4. 강사 삭제");
		System.out.println("    9. 이전으로");
		System.out.println("    0. 프로그램 종료");
		System.out.println("=======================");
		System.out.println("매뉴를 선택하세요 >>");
	}
	
	private void runSearchTeacherMenu() {
		printSearchTeacherMenu();
		int searchTeacherMenu = ManagerFunction.inputNumber();
		
		switch (searchTeacherMenu) {
			case 1:
				showTeacherDetail();
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
		System.out.println("       강 의 조 회        ");
		System.out.println("=======================");
		System.out.println("    1. 강의 단건 상세 조회");
		System.out.println("    2. 강의 전체 조회");
		System.out.println("    9. 이전으로");
		System.out.println("    0. 프로그램 종료");
		System.out.println("=======================");
		System.out.println("매뉴를 선택하세요 >>");
	}
	
	private void showTeacherDetail() {
		System.out.println("------------------------");
		System.out.println("   강사 단건 상세 조회 입니다  ");
		System.out.println("------------------------");
		
		System.out.println("강사 이름을 입력하세요 >>");
		String name = scn.nextLine();
		
		TeacherSearchDetailVO searchedVO = teacherService.findTeacherDetail(name);
		if (searchedVO != null) {
			System.out.println("------------------------");
			System.out.printf("ID : %s\n", searchedVO.getTeacherId());
			System.out.printf("이름 : %s\n", searchedVO.getTeacherName());
			System.out.printf("이메일 : %s\n", searchedVO.getTeacherEmail());
			System.out.printf("정보 : %s\n", searchedVO.getTeacherInfo());
			System.out.printf("담당강의 : %s\n", searchedVO.getLectureName());
			System.out.printf("고용날짜 : %s\n", 
					searchedVO.getTeacherHireDate().format(AcademyMenu.formatter));
			System.out.println("------------------------");
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
	
	private void addTeacher() {
		System.out.println("------------------------");
		System.out.println("       강사 등록 입니다      ");
		System.out.println("------------------------");
		
		System.out.println("강사 이름을 입력하세요 >>");
		String name = scn.nextLine();
		
		System.out.println("강사 이메일을 입력하세요 >>");
		String email = scn.nextLine();
		
		System.out.println("강사 정보를 입력하세요 >>");
		String info = scn.nextLine();
		
		int numIns = teacherService.createTeacher(
				new TeacherVO(AcademyMenu.id_sequence, name, email, info));
		if (numIns != 0) {
			System.out.println("강사 등록이 완료되었습니다.");
		} else {
			System.out.println("강사 등록에 실패하였습니다.");
		}
	}
	
	private void updateTeacher() {
		System.out.println("------------------------");
		System.out.println("     강사정보 수정 입니다     ");
		System.out.println("------------------------");
		
		System.out.println("변경대상 강사의 이름을 입력하세요 >>");
		String targetName = scn.nextLine();
		
		if (teacherService.findTeacherByName(targetName) != null) {
			runUpdateTeacherMenu(targetName);
		} else {
			System.out.println("해당 이름의 강사는 없습니다.");
		}
	}
	
	private void runUpdateTeacherMenu(String targetName) {
		printUpdateTeacherMenu();
		int updateLectureMenu = ManagerFunction.inputNumber();
		
		switch (updateLectureMenu) {
			case 1:
				changeAll(targetName);
				break;
			case 2:
				changeName(targetName);
				break;
			case 3:
				changeEmail(targetName);
				break;
			case 4:
				changeInfo(targetName);
				break;
			case 5:
				changeLecture(targetName);
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
	
	private void printUpdateTeacherMenu() {
		System.out.println("=======================");
		System.out.println("    < OO 직업전문학교 >    ");
		System.out.println("       강사정보 수정       ");
		System.out.println("=======================");
		System.out.println("    1. 전체 수정");
		System.out.println("    2. 이름 수정");
		System.out.println("    3. 이메일 수정");
		System.out.println("    4. 정보 수정");
		System.out.println("    5. 담당강의 수정(배정)");
		System.out.println("    9. 이전으로");
		System.out.println("    0. 프로그램 종료");
		System.out.println("=======================");
		System.out.println("매뉴를 선택하세요 >>");
	}
	
	private void changeAll(String targetName) {
		System.out.println("------------------------");
		System.out.println("      전체 변경 입니다       ");
		System.out.println("------------------------");
		
		System.out.println("새로운 이름을 입력하세요 >>");
		String newName = scn.nextLine();

		System.out.println("새로운 이메일을 입력하세요 >>");
		String newEmail = scn.nextLine();
		
		System.out.println("새로운 정보을 입력하세요 >>");
		String newInfo = scn.nextLine();
		
		System.out.println("새로운 담당강의 이름을 입력하세요 >>");
		int newLectureId;
		LectureVO newLecture = lectureService.findLectureByName(scn.nextLine());
		if (newLecture != null) {
			newLectureId = newLecture.getLectureId();
		} else {
			System.out.println("해당 이름의 강의는 없습니다.");
			return;
		}
		
		TeacherUpdateVO udpateVO = new TeacherUpdateVO(
				targetName, newName, newEmail, newInfo, newLectureId);
		
		int numUpd = teacherService.updateTeacherByName(udpateVO);
		if (numUpd != 0) {
			System.out.println("수정이 완료되었습니다.");
		} else {
			System.out.println("수정에 실패하였습니다.");
		}
	}
	
	private void changeName(String targetName) {
		System.out.println("------------------------");
		System.out.println("      이름 변경 입니다       ");
		System.out.println("------------------------");
		
		System.out.println("새로운 이름을 입력하세요 >>");
		String newName = scn.nextLine();
		
		TeacherUpdateVO udpateVO = new TeacherUpdateVO(
				targetName, newName, null, null, 0);
		
		int numUpd = teacherService.updateTeacherByName(udpateVO);
		if (numUpd != 0) {
			System.out.println("수정이 완료되었습니다.");
		} else {
			System.out.println("수정에 실패하였습니다.");
		}
	}
	
	private void changeEmail(String targetName) {
		System.out.println("------------------------");
		System.out.println("      이메일 변경 입니다     ");
		System.out.println("------------------------");
		
		System.out.println("새로운 이메일을 입력하세요 >>");
		String newEmail = scn.nextLine();
		
		TeacherUpdateVO udpateVO = new TeacherUpdateVO(
				targetName, null, newEmail, null, 0);
		
		int numUpd = teacherService.updateTeacherByName(udpateVO);
		if (numUpd != 0) {
			System.out.println("수정이 완료되었습니다.");
		} else {
			System.out.println("수정에 실패하였습니다.");
		}
	}
	
	private void changeInfo(String targetName) {
		System.out.println("------------------------");
		System.out.println("      정보 변경 입니다       ");
		System.out.println("------------------------");
		
		System.out.println("새로운 정보을 입력하세요 >>");
		String newInfo = scn.nextLine();
		
		TeacherUpdateVO udpateVO = new TeacherUpdateVO(
				targetName, null, null, newInfo, 0);
		
		int numUpd = teacherService.updateTeacherByName(udpateVO);
		if (numUpd != 0) {
			System.out.println("수정이 완료되었습니다.");
		} else {
			System.out.println("수정에 실패하였습니다.");
		}
	}
	
	private void changeLecture(String targetName) {
		System.out.println("------------------------");
		System.out.println("   담당강의 변경(배정) 입니다   ");
		System.out.println("------------------------");
		
		System.out.println("새로운 담당강의 이름을 입력하세요 >>");
		int newLectureId;
		LectureVO newLecture = lectureService.findLectureByName(scn.nextLine());
		if (newLecture != null) {
			newLectureId = newLecture.getLectureId();
		} else {
			System.out.println("해당 이름의 강의는 없습니다.");
			return;
		}
		
		TeacherUpdateVO udpateVO = new TeacherUpdateVO(
				targetName, null, null, null, newLectureId);
		
		int numUpd = teacherService.updateTeacherByName(udpateVO);
		if (numUpd != 0) {
			System.out.println("수정이 완료되었습니다.");
		} else {
			System.out.println("수정에 실패하였습니다.");
		}
	}
	
	private void deleteTeacher() {
		System.out.println("삭제대상 강사의 이름을 입력하세요 >>");
		String targetName = scn.nextLine();
		
		int numDel = teacherService.deleteTeacherByName(targetName);
		if (numDel != 0) {
			System.out.println("삭제가 완료되었습니다.");
		} else {
			System.out.println("삭제에 실패하였습니다.");
		}
	}
}
