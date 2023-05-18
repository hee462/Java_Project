package com.blackjack.exec;

import java.util.Scanner;

import com.blackjac.test.RuleService_test;
import com.blackjack.service.CardService;
import com.blackjack.service.RuleService;

public class Main {
	public static void main(String[] args) {
		RuleService rService = new RuleService();
		Scanner scan 	= new Scanner(System.in);
		boolean flag  	= true; // 게임 플레그
		
		String text = "1";
		while(true) {
//			rService.printSpace();
			if(text.equals("1")) {
				flag = rService.newStratGame();
			}else if(text.equals("3")) {
				flag = rService.stratGame();
			}
			while(flag) {
				flag = rService.dealTurn();
				flag = rService.userTurn(); 
 			}
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
	
	
	
//	public void main(String[] args) {
//		CardService cService = new CardService();
//		RuleService rService = new RuleService();
//		Scanner scan = new Scanner(System.in);
//		boolean flag = true;
//		while(flag) {
//			flag = rService.stratGame();
//			flag = rService.dealTurn();
//			flag = rService.userTurn();
//		}
//	}
}