package com.blackjack.exec;

import java.util.ArrayList;
import java.util.Scanner;

import com.blackjack.service.CardService;
import com.blackjack.service.RuleService_test;

public class Main_Test {
	public static void main(String[] args) {
		CardService cService = new CardService();
		RuleService_test rService = new RuleService_test();
		Scanner scan 	= new Scanner(System.in);
		boolean flag  	   = true; // 게임 플레그
		
		// - 카드 선택시 카드출력
		
		// 게임시작
		// 카드 2장씩 분배
		
		//반복
		// 딜러 점수비교
		// 유저 점수비교
		// 딜러 카드분배
		// 카드출력
		// 유저 카드선택
		// 카드출력
		
		while(true) {
			flag = rService.stratGame();
			while(flag) {
				flag = rService.dealTurn();
				flag = rService.userTurn();
				flag = rService.socreCompare();
			}
			System.out.println("새 게임을 하시겠습니까? (Y/N)");
			System.out.print(">>>");
			String text = scan.nextLine();
			if(text.equals("Y")) {
				flag = true;
				continue;
			}else {
				return;
			}
		}
	}

}