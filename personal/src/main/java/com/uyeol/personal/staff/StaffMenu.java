package com.uyeol.personal.staff;

import java.util.Scanner;

import com.uyeol.personal.AcademyMenu;
import com.uyeol.personal.common.ManagerFunction;
import com.uyeol.personal.staff.manager.EnrollmentManager;
import com.uyeol.personal.staff.manager.LectureManager;
import com.uyeol.personal.staff.manager.StudentManager;
import com.uyeol.personal.staff.manager.TeacherManager;
import com.uyeol.personal.staff.service.StaffService;
import com.uyeol.personal.staff.service.StaffServiceImpl;
import com.uyeol.personal.staff.vo.StaffUpdateVO;

public class StaffMenu {

	// field
	private Scanner scn = new Scanner(System.in);

	private boolean exit = false;
	
	private StaffService staffService = new StaffServiceImpl();

	// main method
	public void runStaffMenu() {
		do {
			printStaffMenu();
			int staffMenu = ManagerFunction.inputNumber();

			switch (staffMenu) {
				case 1:
					StudentManager studentManager = new StudentManager();
					studentManager.runMenu();
					break;
				case 2:
					LectureManager lectureManager = new LectureManager();
					lectureManager.runMenu();
					break;
				case 3:
					TeacherManager teacherManager = new TeacherManager();
					teacherManager.runMenu();
					break;
				case 4:
					EnrollmentManager enrollmentManager = new EnrollmentManager();
					enrollmentManager.runMenu();
					break;
				case 5:
//					if (AcademyMenu.loginStaff.isMaster()) {
//						StaffManager staffManager = new StaffManager();
//						staffManager.runMenu();
//					} else {
//						System.out.println("권한이 없습니다.");
//					}
					break;
				case 6:
					modifyInfo();
					break;
				case 9:
					AcademyMenu.loginStaff = null;
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
	private void printStaffMenu() {
		System.out.println("=======================");
		System.out.println("    < OO 직업전문학교 >    ");
		System.out.println("       관리자 메 뉴        ");
		System.out.println("=======================");
		System.out.println("    1. 학생 관리");
		System.out.println("    2. 강의 관리");
		System.out.println("    3. 강사 관리");
		System.out.println("    4. 수강신청 관리");
		System.out.println("    5. 관리자 관리(미구현)");
		System.out.println("    6. 개인정보 수정");
		System.out.println("    9. 로그 아웃");
		System.out.println("    0. 프로그램 종료");
		System.out.println("=======================");
		System.out.println("매뉴를 선택하세요 >>");
	}

	private void modifyInfo() {
		System.out.println("------------------------");
		System.out.println("     개인정보 수정 입니다     ");
		System.out.println("------------------------");

		System.out.println("비밀번호를 입력하세요 >>");
		String password = scn.nextLine();

		if (password.equals(AcademyMenu.loginStaff.getStaffPassword())) {
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
		
		StaffUpdateVO updateVO = new StaffUpdateVO(
				AcademyMenu.loginStaff.getStaffName(),
				newEmail, null, null, null);
		
		int numUpd = staffService.updateStaffByName(updateVO);
		if (numUpd != 0) {
			AcademyMenu.loginStaff = staffService.findStaffByName(
					AcademyMenu.loginStaff.getStaffName());
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
		
		StaffUpdateVO updateVO = new StaffUpdateVO(
				AcademyMenu.loginStaff.getStaffName(),
				null, newPassword, null, null);
		
		int numUpd = staffService.updateStaffByName(updateVO);
		if (numUpd != 0) {
			AcademyMenu.loginStaff = staffService.findStaffByName(
					AcademyMenu.loginStaff.getStaffName());
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
		
		System.out.println("새로운 연락처을 입력하세요 >>");
		String newTel = scn.nextLine();
		
		StaffUpdateVO updateVO = new StaffUpdateVO(
				AcademyMenu.loginStaff.getStaffName(),
				null, null, newName, newTel);
		
		int numUpd = staffService.updateStaffByName(updateVO);
		if (numUpd != 0) {
			AcademyMenu.loginStaff = staffService.findStaffByName(newName);
			System.out.println("수정이 완료되었습니다.");
		} else {
			System.out.println("수정에 실패하였습니다.");
		}	
	}
}
