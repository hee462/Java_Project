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
		
		while(true) {
			flag = rService.stratGame();
			while(flag) {
				rService.dealTurn();
				rService.userTurn();
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
		
//		String text = "";
//		while(true) {
//			cService.printCard();
//			System.out.println("카드를 뽑으시겠습니까? (player/뽑는다)");
//			System.out.print(">>>");
//			text = scan.nextLine();
//			if(text.equals("유저/뽑는다")) {
//				cService.addCard("user");
//			}else if(text.equals("딜러/뽑는다")) {
//				cService.addCard("deal");
//			}else{
//				continue;
//			}
//		}
	}

}