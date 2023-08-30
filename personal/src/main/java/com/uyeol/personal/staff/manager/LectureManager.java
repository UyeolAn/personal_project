package com.uyeol.personal.staff.manager;

import java.util.Scanner;

import com.uyeol.personal.common.ManagerFunction;

public class LectureManager {

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
					runSearchLectureMenu();
					break;
				case 2:
//					addLecture();
					break;
				case 3:
//					runUpdateLectureMenu();
					break;
				case 4:
//					deleteLecture();
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
		System.out.println("      강의 관리 메뉴       ");
		System.out.println("=======================");
		System.out.println("    1. 강의 조회");
		System.out.println("    2. 강의 등록");
		System.out.println("    3. 강의정보 수정");
		System.out.println("    4. 강의 삭제");
		System.out.println("    9. 이전으로");
		System.out.println("    0. 프로그램 종료");
		System.out.println("=======================");
		System.out.println("매뉴를 선택하세요 >>");
	}
	
	private void runSearchLectureMenu() {
		printSearchLectureMenu();
		int searchLectureMenu = ManagerFunction.inputNumber();
		
		switch (searchLectureMenu) {
			case 1:
				showLectureDetail();
				break;
			case 2:
//				showAllLectures();
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
		System.out.println("    1. 강의 단건 상세 조회");
		System.out.println("    2. 강의 전체 조회");
		System.out.println("    9. 이전으로");
		System.out.println("    0. 프로그램 종료");
		System.out.println("=======================");
		System.out.println("매뉴를 선택하세요 >>");
	}
	
	private void showLectureDetail() {
		System.out.println("------------------------");
		System.out.println("   강의 단건 상세 조회 입니다  ");
		System.out.println("------------------------");
		
		System.out.println("강의 이름을 입력하세요 >>");
		String name = scn.nextLine();
		
		// TODO : 강의 상세 조회
	}
	
}
