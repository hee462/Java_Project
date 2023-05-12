package com.blackjack.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.blackjack.models.CardDto;

public class RuleService_test {
	private CardService cService;
    private List<CardDto> dCardList;
    private List<CardDto> uCardList;
    private int dSum = 0;
    private int uSum = 0;
    private boolean flag;
	   

	public RuleService_test() {
		flag = true;
		cService = new CardService();
		dCardList = new ArrayList<>();
		uCardList = new ArrayList<>();
	}

	public boolean stratGame() {
		cService.CreateCard();
		for( int i =0 ; i < 2 ; i++) {
			cService.addCard("deal");
			cService.addCard("user");
		}
		score();
		if(dSum < 17){
			cService.addCard("deal");
		}
		cService.printCard();
		socreCompare();
		return flag;
	}
	
	public boolean hitCard() {
		Scanner scan = new Scanner(System.in);
		if(dCardList.size() == uCardList.size() && dCardList.size() > 2) {
			if(dSum < 17){
				cService.addCard("deal");
			}
			cService.printCard();
			socreCompare();
		}
		
		System.out.println("카드를 뽑으시겠습니까? (Y/N)");
		System.out.print(">>>");
		String str = scan.nextLine();
		if(str.equals("Y")) {
			cService.addCard("user");
		}else if(str.equals("N")){
			flag = false;
			if(dSum > uSum) {
				System.out.println("딜러 승리!");
				return flag;
			}else if(dSum < uSum) {
				System.out.println("유저 승리!");
				return flag;
			}else {
				System.out.println("무승부!");
				return flag;
			}
		}
		cService.printCard();
		socreCompare();
		return flag;
	}
	
	
	//카드 합계 계산
	public void score() {
		dCardList = cService.getDealList();
		uCardList = cService.getUserList();
		dSum = 0;
		for(int i = 0; i< dCardList.size(); i++) {
			String cNum = dCardList.get(i).getDNum();
			if(cNum.equals("K")) {
				dSum += 10;
			}else if(cNum.equals("Q")) {
				dSum += 10;
			}else if(cNum.equals("J")) {
				dSum += 10;
			}else {
				dSum += Integer.valueOf(dCardList.get(i).getDNum());
			}
		}
		uSum = 0;
		for(int i = 0; i< uCardList.size(); i++) {
			String cNum = uCardList.get(i).getDNum();
			if(cNum.equals("K")) {
				uSum += 10;
			}else if(cNum.equals("Q")) {
				uSum += 10;
			}else if(cNum.equals("J")) {
				uSum += 10;
			}else {
				uSum += Integer.valueOf(uCardList.get(i).getDNum());
			}
	   }
   }
	   
	public void socreCompare() {
		score();
		if(dSum == 21) {
			System.out.println("딜러 승리!");
			flag = false;
			return;
		}else if(dSum > 21) {
			System.out.println("유저 승리!");
			flag = false;
			return;
		}
		
		if(uSum == 21) {
			System.out.println("유저 승리!");
			flag = false;
			return;
		}else if(uSum > 21) {
			System.out.println("딜러 승리!");
			flag = false;
			return;
		}
	}
	
//	dealHitCard()
//	public void dealhitCard() {		
//		dCardList = cService.getDealList();
//		int sum = 0;
//		for(int i = 0; i< dCardList.size(); i++) {
//			String cNum = dCardList.get(i).getDNum();
//			if(cNum.equals("K")) {
//				sum += 10;
//			}else if(cNum.equals("Q")) {
//				sum += 10;
//			}else if(cNum.equals("J")) {
//				sum += 10;
//			}else {
//				sum += Integer.valueOf(dCardList.get(i).getDNum());
//			}
//		}
//		
//		if(sum > 21) {
//			System.out.println("유저 승리");
//		}else if(sum < 17){
//			cService.addCard("deal");
//		}
//		
//	}
}
