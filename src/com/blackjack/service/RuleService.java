package com.blackjack.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.DefaultCaret;

import com.blackjack.models.CardDto;

public class RuleService {

	private CardService cService;
	private List<CardDto> dCardList;
	private List<CardDto> uCardList;
	int dSum = 0;
	int uSum = 0;
	String uStr;

	public RuleService() {
		cService = new CardService();
		dCardList = new ArrayList<>();
		uCardList = new ArrayList<>();
	}

	public void stratGame() {
		cService.CreateCard();

		for (int i = 0; i < 2; i++) {
			cService.addCard("deal");
			cService.addCard("user");
		}

		cService.printCard();

	}

	public void dealTrun() {
		if (dSum < 17) {
			cService.addCard("deal");
			cService.printCard();
		} else {
			System.out.println("카드를 더이상 뽑지 못합니다");
			return;
		}

	}

	public void userTrun() {
		Scanner scan = new Scanner(System.in);
		if (uSum < 21) {
			System.out.println("Game over");
		}
		System.out.println("카드를 출력하시겠습니까? (Y/N)");
		System.out.print(">>>");
		try {
			uStr = scan.nextLine();
			if (uStr.equals("Y")) {
				cService.addCard("user");
				cService.printCard();
			}
		} catch (Exception e) {
			System.out.println("Y 또는 N를 입력해 주세요");
			if (uStr.equals("N")) {
				System.out.println("GAME OVER");
			}
		}
	}

	public void score() {
		dCardList = cService.getDealList();
		uCardList = cService.getUserList();
		for (int i = 0; i < dCardList.size(); i++) {
			String cNum = dCardList.get(i).getDNum();
			if (cNum.equals("K")) {
				dSum += 10;
			} else if (cNum.equals("Q")) {
				dSum += 10;
			} else if (cNum.equals("j")) {
				dSum += 10;
			} else {
				dSum += Integer.valueOf(dCardList.get(i).getDNum());
			}
		}

		for (int i = 0; i < uCardList.size(); i++) {
			String cNum = uCardList.get(i).getDNum();
			if (cNum.equals("K")) {
				uSum += 10;
			} else if (cNum.equals("Q")) {
				uSum += 10;
			} else if (cNum.equals("j")) {
				uSum += 10;
			} else {
				uSum += Integer.valueOf(uCardList.get(i).getDNum());

			}
		}

	}
	
	public void scoreCompare() {
		if(dSum >uSum && dSum <22) {
			cService.printCard();
			System.out.println("딜러 승리");
		}else if( dSum < uSum && uSum <22) {
			cService.printCard();
			System.out.println("유저 승리");
		}else {
			cService.printCard();
			System.out.println("무승부ㅠ");
		}
	}
	
	
	
	
	
	
}
