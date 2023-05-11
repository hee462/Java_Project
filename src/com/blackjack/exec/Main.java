package com.blackjack.exec;

import java.util.Scanner;

import com.blackjack.service.CardService;
import com.blackjack.service.RuleService;

public class Main {
	public static void main(String[] args) {
		CardService cService = new CardService();
		RuleService rService = new RuleService();
		Scanner scan = new Scanner(System.in);

		rService.stratGame();

//		
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