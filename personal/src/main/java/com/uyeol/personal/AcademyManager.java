package com.uyeol.personal;

import java.util.Scanner;

import com.uyeol.personal.staff.vo.StaffVO;
import com.uyeol.personal.student.vo.StudentVO;

public class AcademyManager {
	
	// global variable field
	public static int ID_SEQUENCE = 1;
	
	public static StudentVO loginStudent;
	
	public static StaffVO loginStaff;
	
	// field
	private Scanner scn = new Scanner(System.in);
	
	
	// main method
	public void run() {
		
		boolean exit = false;
		boolean isLogin = false;
		
		do {
			printMainMenu();
			int menu = scn.nextInt();
			scn.nextLine();
			
			switch (menu) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 0:
				break;
			default:
				break;
			}
			
			if (isLogin) {
				//TODO : 로그인 대상 메뉴로 이동
			}
			
		} while (!exit);
	}
	
	private void printMainMenu() {
		System.out.println("=======================");
		System.out.println("    < OO 직업전문학교 >    ");
		System.out.println("       메 인 메 뉴        ");
		System.out.println("=======================");
		System.out.println("    1. 로그인");
		System.out.println("    2. 회원 가입");
		System.out.println("    3. 이메일/PW 찾기");
		System.out.println("    0. 프로그램 종료");
		System.out.println("=======================");
		System.out.println("매뉴를 선택하세요 >>");
	}
	
}
