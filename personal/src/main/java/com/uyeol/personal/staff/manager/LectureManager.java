package com.uyeol.personal.staff.manager;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.uyeol.personal.AcademyMenu;
import com.uyeol.personal.common.ManagerFunction;
import com.uyeol.personal.lecture.service.LectureService;
import com.uyeol.personal.lecture.service.LectureServiceImpl;
import com.uyeol.personal.lecture.vo.LectureUpdateVO;
import com.uyeol.personal.lecture.vo.LectureVO;

public class LectureManager {

	// field
	private Scanner scn = new Scanner(System.in);
	
	private boolean exit = false;
	
	private LectureService lectureService = new LectureServiceImpl();
	
	
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
					addLecture();
					break;
				case 3:
					updateLecture();
					break;
				case 4:
					deleteLecture();
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
		
		LectureVO searchedVO = lectureService.findLectureByName(name);
		if (searchedVO != null) {
			System.out.println("------------------------");
			System.out.printf("ID : %s\n", searchedVO.getLectureId());
			System.out.printf("이름 : %s\n", searchedVO.getLectureName());
			System.out.printf("설명 : %s\n", searchedVO.getLectureDescription());
			System.out.printf("기간 : %s ~ %s\n",
					searchedVO.getLectureStartDate().format(AcademyMenu.formatter),
					searchedVO.getLectureEndDate().format(AcademyMenu.formatter));
			System.out.printf("학생수 : %d/%d\n", 
					searchedVO.getNumStudents(), searchedVO.getMaxNumStudents());
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
			System.out.printf("[%s] %s~%s %d/%d <%s>\n",
					vo.getLectureName(),
					vo.getLectureStartDate().format(AcademyMenu.formatter),
					vo.getLectureEndDate().format(AcademyMenu.formatter),
					vo.getNumStudents(), vo.getMaxNumStudents(),
					vo.isStarted() ? "진행중" : "모집중");
		}
		System.out.println("------------------------");
	}
	
	private void addLecture() {
		System.out.println("------------------------");
		System.out.println("       강의 등록 입니다      ");
		System.out.println("------------------------");
		
		System.out.println("강의 이름을 입력하세요 >>");
		String name = scn.nextLine();
		
		System.out.println("강의 설명을 입력하세요 >>");
		String description = scn.nextLine();
		
		System.out.println("강의 시작일을 입력하세요(yyyy.MM.dd) >>");
		LocalDate startDate = LocalDate.parse(scn.nextLine(), AcademyMenu.formatter);
		
		System.out.println("강의 종료일을 입력하세요(yyyy.MM.dd) >>");
		LocalDate endDate = LocalDate.parse(scn.nextLine(), AcademyMenu.formatter);
		
		System.out.println("최대 인원수를 입력하세요 >>");
		int maxNumStudents = ManagerFunction.inputNumber();
		
		int numIns = lectureService.createLecture(new LectureVO(
				AcademyMenu.id_sequence++, name, description, 
				startDate, endDate, 0, maxNumStudents, false));
		if (numIns != 0) {
			System.out.println("강의 등록이 완료되었습니다.");
		} else {
			System.out.println("강의 등록에 실패하였습니다.");
		}
	}
	
	private void updateLecture() {
		System.out.println("------------------------");
		System.out.println("     강의정보 수정 입니다     ");
		System.out.println("------------------------");
		
		System.out.println("변경대상 강의의 이름을 입력하세요 >>");
		String targetName = scn.nextLine();
		
		if (lectureService.findLectureByName(targetName) != null) {
			runUpdateLectureMenu(targetName);
		} else {
			System.out.println("해당 이름의 강의는 없습니다.");
		}
	}
	
	private void runUpdateLectureMenu(String targetName) {
		printUpdateLectureMenu();
		int updateLectureMenu = ManagerFunction.inputNumber();
		
		switch (updateLectureMenu) {
			case 1:
				changeAll(targetName);
				break;
			case 2:
				changeName(targetName);
				break;
			case 3:
				changeDescription(targetName);
				break;
			case 4:
				changePeriod(targetName);
				break;
			case 5:
				changeMaxNumStudents(targetName);
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
	
	private void printUpdateLectureMenu() {
		System.out.println("=======================");
		System.out.println("    < OO 직업전문학교 >    ");
		System.out.println("       강의정보 수정       ");
		System.out.println("=======================");
		System.out.println("    1. 전체 수정");
		System.out.println("    2. 이름 수정");
		System.out.println("    3. 설명 수정");
		System.out.println("    4. 기간 수정");
		System.out.println("    5. 최대인원수 수정");
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

		System.out.println("새로운 설명을 입력하세요 >>");
		String newDescription = scn.nextLine();
		
		System.out.println("새로운 시작일을 입력하세요(yyyy.MM.dd) >>");
		LocalDate newStartDate = LocalDate.parse(scn.nextLine(), AcademyMenu.formatter);
		
		System.out.println("새로운 종료일을 입력하세요(yyyy.MM.dd) >>");
		LocalDate newEndDate = LocalDate.parse(scn.nextLine(), AcademyMenu.formatter);
		
		System.out.println("새로운 최대 인원수를 입력하세요 >>");
		int newMaxNumStudents = ManagerFunction.inputNumber();
		
		LectureUpdateVO updateVO = new LectureUpdateVO(
				targetName, newName, newDescription, newStartDate, newEndDate, newMaxNumStudents);
		
		int numUpd = lectureService.updateLectureByName(updateVO);
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
		
		LectureUpdateVO updateVO = new LectureUpdateVO(
				targetName, newName, null, null, null, 0);
		
		int numUpd = lectureService.updateLectureByName(updateVO);
		if (numUpd != 0) {
			System.out.println("수정이 완료되었습니다.");
		} else {
			System.out.println("수정에 실패하였습니다.");
		}
	}
	
	private void changeDescription(String targetName) {
		System.out.println("------------------------");
		System.out.println("      설명 변경 입니다       ");
		System.out.println("------------------------");
		
		System.out.println("새로운 설명을 입력하세요 >>");
		String newDescription = scn.nextLine();
		
		LectureUpdateVO updateVO = new LectureUpdateVO(
				targetName, null, newDescription, null, null, 0);
		
		int numUpd = lectureService.updateLectureByName(updateVO);
		if (numUpd != 0) {
			System.out.println("수정이 완료되었습니다.");
		} else {
			System.out.println("수정에 실패하였습니다.");
		}
	}

	private void changePeriod(String targetName) {
		System.out.println("------------------------");
		System.out.println("      기간 변경 입니다       ");
		System.out.println("------------------------");
		
		System.out.println("새로운 시작일을 입력하세요(yyyy.MM.dd) >>");
		LocalDate newStartDate = LocalDate.parse(scn.nextLine(), AcademyMenu.formatter);
		
		System.out.println("새로운 종료일을 입력하세요(yyyy.MM.dd) >>");
		LocalDate newEndDate = LocalDate.parse(scn.nextLine(), AcademyMenu.formatter);
		
		LectureUpdateVO updateVO = new LectureUpdateVO(
				targetName, null, null, newStartDate, newEndDate, 0);
		
		int numUpd = lectureService.updateLectureByName(updateVO);
		if (numUpd != 0) {
			System.out.println("수정이 완료되었습니다.");
		} else {
			System.out.println("수정에 실패하였습니다.");
		}
	}
	
	private void changeMaxNumStudents(String targetName) {
		System.out.println("------------------------");
		System.out.println("    최대인원수 변경 입니다     ");
		System.out.println("------------------------");
		
		System.out.println("새로운 최대 인원수를 입력하세요 >>");
		int newMaxNumStudents = ManagerFunction.inputNumber();
		
		LectureUpdateVO updateVO = new LectureUpdateVO(
				targetName, null, null, null, null, newMaxNumStudents);
		
		int numUpd = lectureService.updateLectureByName(updateVO);
		if (numUpd != 0) {
			System.out.println("수정이 완료되었습니다.");
		} else {
			System.out.println("수정에 실패하였습니다.");
		}
	}
	
	private void deleteLecture() {
		System.out.println("삭제대상 강의의 이름을 입력하세요 >>");
		String targetName = scn.nextLine();
		
		int numDel = lectureService.deleteLectureByName(targetName);
		if (numDel != 0) {
			System.out.println("삭제가 완료되었습니다.");
		} else {
			System.out.println("삭제에 실패하였습니다.");
		}
	}
	
}
