package com.uyeol.personal.staff.manager;

import java.util.Scanner;

import com.uyeol.personal.common.ManagerFunction;

public class EnrollmentManager {

	// field
	private Scanner scn = new Scanner(System.in);
	
	private boolean exit = false;
	
	
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
//					takeEnrollment();
					break;
				case 3:
//					updateEnrollment();
					break;
				case 4:
//					cancelEnrollment();
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
		System.out.println("    3. 수강정보 수정");
		System.out.println("    4. 수강신청 취소");
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
				showEnrollment();
				break;
			case 2:
//				runShowEnrollmentsMenu();
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
		System.out.println("    1. 수강신청 단건 조회");
		System.out.println("    2. 수강신청 여러건 조회");
		System.out.println("    9. 이전으로");
		System.out.println("    0. 프로그램 종료");
		System.out.println("=======================");
		System.out.println("매뉴를 선택하세요 >>");
	}
	
	private void showEnrollment() {
		// TODO : 학생 이름으로 검색해서 단건 조회
	}
	
}
