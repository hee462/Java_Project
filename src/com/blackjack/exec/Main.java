package com.blackjack.exec;

import java.util.Scanner;

import com.blackjack.service.CardService;
import com.blackjack.service.RuleService;

public class Main {
	public static void main(String[] args) {
		CardService cService = new CardService();
		RuleService rService = new RuleService();
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		while(flag) {
			flag = rService.stratGame();
			flag = rService.dealTurn();
			flag = rService.userTurn();
		}
//		rService.stratGame();
//		rService.dealTurn();
//		rService.userTurn();
//		rService.socreCompare();


}
}