package com.uyeol.personal.common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.uyeol.personal.AcademyMenu;

public class ManagerFunction {
	
	private static Scanner scn = new Scanner(System.in);
	
	public static int loadSequence() {
		try {
			BufferedReader br = new BufferedReader(
			        new FileReader("src/main/resources/sequence.txt"));
			int sequence = Integer.parseInt(br.readLine());
			br.close();
			return sequence;
		} catch (IOException e) {
			System.out.println("시퀀스 값 불러오기에 실패하였습니다.");
			System.out.println("프로그램을 종료합니다.");
			ManagerFunction.saveSequence(AcademyMenu.id_sequence);
			System.exit(1);
		}
		return -1;
	}
	
	public static void saveSequence(int sequence) {
		try {
			BufferedWriter bw = new BufferedWriter(
					new FileWriter("src/main/resources/sequence.txt"));
			bw.write(String.valueOf(sequence));
			bw.close();
		} catch (IOException e) {
			System.out.println("시퀀스 값 저장에 실패하였습니다.");
			System.out.println("프로그램을 종료합니다.");
			System.exit(1);
		}
	}
	
	public static int inputNumber() {
		try {
			int result = scn.nextInt();
			scn.nextLine();
			return result;
		} catch (InputMismatchException e) {
			scn.nextLine();
			return -1;
		}
	}
	
	public static void exitProgram() {
		System.out.println("프로그램을 종료합니다.");
		saveSequence(AcademyMenu.id_sequence);
		System.exit(0);
	}

}
