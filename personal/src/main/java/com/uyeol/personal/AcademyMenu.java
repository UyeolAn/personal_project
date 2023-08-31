package com.uyeol.personal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.uyeol.personal.common.ManagerFunction;
import com.uyeol.personal.staff.StaffMenu;
import com.uyeol.personal.staff.service.StaffService;
import com.uyeol.personal.staff.service.StaffServiceImpl;
import com.uyeol.personal.staff.vo.StaffLoginVO;
import com.uyeol.personal.staff.vo.StaffVO;
import com.uyeol.personal.student.StudentMenu;
import com.uyeol.personal.student.service.StudentService;
import com.uyeol.personal.student.service.StudentServiceImpl;
import com.uyeol.personal.student.vo.StudentLoginVO;
import com.uyeol.personal.student.vo.StudentVO;

public class AcademyMenu {
	
	// global field
	public static int id_sequence;
	
	public static StudentVO loginStudent = null;
	
	public static StaffVO loginStaff = null;
	
	public static boolean isLogin = false;
	
	private static String datePattern = "yyyy.MM.dd";
	public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern(datePattern); 
	
	// fields
	private Scanner scn = new Scanner(System.in);
	
	private StudentService studentService = new StudentServiceImpl();
	
	private StaffService staffService = new StaffServiceImpl();
	
	
	// constructor
	public AcademyMenu() {
		init();
	}
	
	private void init() {
		AcademyMenu.id_sequence = ManagerFunction.loadSequence();
	}
	
	
	// main method
	public void runMainMenu() {
		do {
			printMainMenu();
			int mainMenu = ManagerFunction.inputNumber();
			
			switch (mainMenu) {
				case 1:
					runLoginMenu();
					break;
				case 2:
					join();
					break;
				case 0:
					ManagerFunction.exitProgram();
					break;
				default:
					break;
			}
			
			if (isLogin) {
				if (loginStudent != null) {
					StudentMenu manager = new StudentMenu();
					manager.runStudentMenu();
				} else if (loginStaff != null) {
					StaffMenu manager = new StaffMenu();
					manager.runStaffMenu();
				}
			}
		} while (true);
	}
	
	
	// sub method
	private void printMainMenu() {
		System.out.println("=======================");
		System.out.println("    < OO 직업전문학교 >    ");
		System.out.println("       메 인 메 뉴        ");
		System.out.println("=======================");
		System.out.println("    1. 로그인");
		System.out.println("    2. 회원가입");
		System.out.println("    0. 프로그램 종료");
		System.out.println("=======================");
		System.out.println("매뉴를 선택하세요 >>");
	}
	
	private void runLoginMenu() {
		printLoginMenu();
		int loginMenu = ManagerFunction.inputNumber();
		
		switch (loginMenu) {
			case 1:
				loginStudent();
				break;
			case 2:
				loginStaff();
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
	
	private void printLoginMenu() {
		System.out.println("=======================");
		System.out.println("    < OO 직업전문학교 >    ");
		System.out.println("        로그인 메뉴       ");
		System.out.println("=======================");
		System.out.println("    1. 학생 로그인");
		System.out.println("    2. 관리자 로그인");
		System.out.println("    9. 이전으로");
		System.out.println("    0. 프로그램 종료");
		System.out.println("=======================");
		System.out.println("매뉴를 선택하세요 >>");
	}
	
	private void loginStudent() {
		System.out.println("------------------------");
		System.out.println("      학생 로그인 입니다      ");
		System.out.println("------------------------");
		
		System.out.println("이메일을 입력하세요 >>");
		String email = scn.nextLine();
		
		System.out.println("비밀번호를 입력하세요 >>");
		String password = scn.nextLine();
		
		AcademyMenu.loginStudent = studentService.login(new StudentLoginVO(email, password));
		if (AcademyMenu.loginStudent != null) {
			System.out.printf("'%s'님 로그인 하셨습니다.\n", 
					AcademyMenu.loginStudent.getStudentName());
			isLogin = true;
		} else {
			System.out.println("이메일 또는 비밀번호가 일치하지 않습니다.");
		}
	}
	
	private void loginStaff() {
		System.out.println("------------------------");
		System.out.println("     관리자 로그인 입니다     ");
		System.out.println("------------------------");
		
		System.out.println("이메일을 입력하세요 >>");
		String email = scn.nextLine();
		
		System.out.println("비밀번호를 입력하세요 >>");
		String password = scn.nextLine();
		
		loginStaff = staffService.login(new StaffLoginVO(email, password));
		if (loginStaff != null) {
			System.out.printf("'%s'님 로그인 하셨습니다.\n", loginStaff.getStaffName());
			isLogin = true;
		} else {
			System.out.println("이메일 또는 비밀번호가 일치하지 않습니다.");
		}
	}
	
	private void join() {
		System.out.println("------------------------");
		System.out.println("      회원 가입 입니다       ");
		System.out.println("------------------------");
		
		System.out.println("이메일을 입력하세요 >>");
		String email = scn.nextLine();
		
		System.out.println("비밀번호를 입력하세요 >>");
		String password = scn.nextLine();
		
		System.out.println("이름을 입력하세요 >>");
		String name = scn.nextLine();
		
		System.out.println("생년월일을 입력하세요(yyyy.MM.dd) >>");
		LocalDate birth = LocalDate.parse(scn.nextLine(), formatter);
		
		System.out.println("연락처를 입력하세요 >>");
		String tel = scn.nextLine();
		
		
		int numIns = studentService.createStudent(
				new StudentVO(AcademyMenu.id_sequence++, email, password, name, birth, tel));
		if (numIns != 0) {
			System.out.printf("'%s'님, 회원이 되신 것을 환영합니다!\n", name);
		} else {
			System.out.printf("회원가입에 실패하였습니다.");
		}
	}
}
