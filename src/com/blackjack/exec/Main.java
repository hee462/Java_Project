package com.blackjack.exec;

import java.util.Scanner;

import com.blackjack.service.CardService;

public class Main {
	public static void main(String[] args) {
		CardService cService = new CardService();
		Scanner scan = new Scanner(System.in);
		
		cService.CreateCard();
		String text = "";
		while(true) {
			cService.printCard();
			System.out.println("카드를 뽑으시겠습니까? (뽑는다/안뽑는다)");
			System.out.print(">>>");
			text = scan.nextLine();
			if(text.equals("뽑는다")) {
			}else{
				break;
			}
		}
	}
	
	
}