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

	private boolean flag;
	private boolean dTurnFlag;
	private boolean uTurnFlag;

//리스트 초기화
	public RuleService() {
		cService = new CardService();
		dCardList = new ArrayList<>();
		uCardList = new ArrayList<>();
	}

// 게임을 위한 카드 2장 나눠주기
	public boolean stratGame() {
		// 반복문 조건  셋팅
		flag = true;
		dTurnFlag = true;
		uTurnFlag = true;
		
		cService.CreateCard();
		for (int i = 0; i < 2; i++) {
			cService.addCard("deal");
			cService.addCard("user");
		}
		// 카드 출력method
		cService.printCard();
		// boolean 값으로 flag리턴 ==>true 
		return flag;

	}

<<<<<<< HEAD
//딜러 턴 카드 값 비교 및 카드 받기
	public boolean dealTurn() {
		// dTurn 인지와 flag 값이 트루 인지 확인
		if (flag && dTurnFlag) {
			// dsum 이 17이하면 카드 추가
			if (dSum < 17) {
				cService.addCard("deal");
				cService.printCard();
				// 딜러 카드 합산 값 비교 후 프린트 값 출력
				 dSocreOver();

			} else {
				dTurnFlag = false;
			}
		}
		return flag;

	}

	public boolean userTurn() {

		if (flag && uTurnFlag) {
			Scanner scan = new Scanner(System.in);
			System.out.println("카드를 뽑으시겠습니까? (Y/N)");
			System.out.print(">>>");
=======
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
>>>>>>> cc8cca8ca8353ecb1484d46db47fdc3b56fc670f
			uStr = scan.nextLine();
			if (uStr.equals("Y")) {
				cService.addCard("user");
				cService.printCard();

			} else {
				
				uTurnFlag = false;
			}
		}
		return flag;
	}
	// 카드 뽑고 합산하여 비교할 method
	public void score() {
		// 카드 리스트  선언
		dCardList = cService.getDealList();
		uCardList = cService.getUserList();
		// for 반복문 초기화 값
		dSum = 0;
		//size  만큼 반복 dsum에 카드값추가
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

	public boolean dSocreOver() {
		//method 불러서 sum 값 비교 후 출
		score();
		if (dSum == 21) {
			System.out.println("딜러 승리!");
			flag = false;
		} else if (dSum > 21) {
			System.out.println("유저 승리!");
			flag = false;
		} else {
			flag = true;
		}
		return flag;
	}

	public boolean uScoreOver() {

		score();
		if (uSum == 21) {
			System.out.println("플레이어  승리");

			flag = false;
		} else if (uSum > 21) {
			System.out.println("딜러  승리");
			flag = false;
		} else {
			flag = true;
		}
		return flag;

	}

	public boolean socreCompare() {
		// 유저 턴과 딜러턴이 아니라면
		if (!uTurnFlag && !dTurnFlag) {
			//sum 값 비교 후 출
			score();
			if (dSum > uSum && dSum < 22) {
				cService.printCard();
				System.out.println("딜러 승리");
				
				flag =false;
			} else if (dSum < uSum && uSum < 22) {
				cService.printCard();
				System.out.println("유저 승리");
				
				flag =false;
			} else {
				cService.printCard();
				System.out.println("무승부");
				
				flag =false;
			}
		}
		return flag;
	}
}

