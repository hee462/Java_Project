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
		
		// 게임시작 - 
		// 카드 2장씩 분배
		// 딜러 점수비교 (21 이김)
		// 유저 점수비교
		
		// 딜러 카드분배
		// 카드출력
		// 유저 카드선택
		// 카드출력
		
		String text = "1";
		while(true) {
			if(text.equals("1")) {
				flag = rService.newStratGame();
			}else if(text.equals("3")) {
				flag = rService.stratGame();
			}
//			flag = rService.stratGame();
			// while(true) 계속 반복을 함
			// flag = true 기 떄문에 계속 반복
			while(flag) {
				// 1. 딜러턴 메서드를 실행
				// 딜러턴 메서드를 실행하고 룰 서비스 테스트에 있는 flag값을 가져옴
				// 가져온 값을 메인 메서드 플레그에 담음
				flag = rService.dealTurn(); // true 
				// 2. 유저턴 메서드를 실행
				// 유전턴 메서드를 실행하고 룰 서비스 테스트에 있는 flag값을 가져옴
				// 가져온 값을 메인 메서드 플레그에 담음
				flag = rService.userTurn(); // true
				flag = rService.socreCompare(); // true
				
				// 3. 반복
				// 4. 반복
				// 5. 유저턴에 숫자가 넘어가서 게임이 끝 flag = false가됨
 			}
//			System.out.println("새게임(NEW) / 카드추가(ADD)");
//			System.out.println("다음 게임을 하시겠습니까?");
			System.out.println("┌─────────────────┬─────────────────┐");
			System.out.println("│ 1.새 게임       │ 2.카드추가      │");
			System.out.println("├─────────────────┼─────────────────┤");
			System.out.println("│ 3.다음게임      │ 4.그만하기      │");
			System.out.println("└─────────────────┴─────────────────┘");
			System.out.print(">>>");
			text = scan.nextLine();
			if(text.equals("1") || text.equals("3")) {
				flag = true;
				continue;
			}else if(text.equals("2")) {
				rService.addCardList();
				rService.printScore();
			}else if(text.toUpperCase().equals("4")){
				return;
			}
		}
	}

}