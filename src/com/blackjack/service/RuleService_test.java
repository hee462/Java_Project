package com.blackjack.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.blackjack.models.CardDto;

public class RuleService_test {
	private CardService cService;
    private List<CardDto> cList;
    private List<CardDto> dCardList;
    private List<CardDto> uCardList;
    private int dSum = 0;
    private int uSum = 0;
    //승패 점수
    private int dWin = 0;
    private int uWin = 0;
    private int draw = 0;
    String uStr = "";
    private boolean flag;
    private boolean dTurnFlag;
    private boolean uTurnFlag;
	   

	public RuleService_test() {
		cService  = new CardService();
		cList     = new ArrayList<>();
		dCardList = new ArrayList<>();
		uCardList = new ArrayList<>();
		flag      = true;
		dTurnFlag = true; // 딜러 턴 플레그
		uTurnFlag = true; // 유저 턴 플레그
	}
	//게임 시작
	public boolean stratGame() {
		flag = true;
		dTurnFlag = true;
		uTurnFlag = true;
//	    dWin = 0;
//	    uWin = 0;
//	    draw = 0;
		cService.playerListReset();
		for( int i =0 ; i < 2 ; i++) {
			cService.addCard("deal");
			cService.addCard("user");
		}
		printScore();
		cService.printCard2();
		score();
		return flag;
	}
	//게임 시작할때 1회 실행
	public boolean newStratGame() {
	    dWin = 0;
	    uWin = 0;
	    draw = 0;
		cService.CreateCard();
		return stratGame();
	}
	
	public void addCardList() {
		cService.addCardList();
	}
	
	public boolean dealTurn() {
		if(flag && dTurnFlag) {
			if(dSum < 17){
				cService.addCard("deal");
				printScore();
				cService.printCard2();
				dSocreOver();
			}else {
				dTurnFlag = false;
			}
		}
		return flag;
	}
	
	public boolean userTurn() {
		if(flag && uTurnFlag) {
			Scanner scan = new Scanner(System.in);
			//유저 차례 진행
			System.out.println("카드를 뽑으시겠습니까? (Y/N)");
			System.out.print(">>>");
			uStr = scan.nextLine();
			if(uStr.toUpperCase().equals("Y")) {
				// 뽑는다 선택시 유저카드 한장 추가
				cService.addCard("user");
				printScore();
				cService.printCard2();
				uSocreOver();
			}else {
				uTurnFlag = false;
			}
		}
		return flag;
	}
	
	//카드 합계 계산
	public void score() {
		dCardList = cService.getDealList();
		uCardList = cService.getUserList();
		cList     = cService.getCardList();
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
	   
	public boolean dSocreOver() {
		score();
		if(dSum == 21) {
			System.out.println("딜러 승리!");
			dWin++;
			flag = false;
		}else if(dSum > 21) {
			System.out.println("유저 승리!");
			uWin++;
			flag = false;
		}else {
			flag = true;
		}
		return flag;
	}
	public boolean uSocreOver() {
		score();
		if(uSum == 21) {
			System.out.println("유저 승리!");
			uWin++;
			flag = false;
		}else if(uSum > 21) {
			System.out.println("딜러 승리!");
			dWin++;
			flag = false;
		}else {
			flag = true;
		}
		
		return flag;
	}
	
	public boolean socreCompare() {	
		if(!uTurnFlag) {
			score();
			if(dSum > uSum && dSum < 22) {
				printScore();
				cService.printCard2();
				System.out.println("딜러 승리!");
				dWin++;
				flag = false;;
			}else if(dSum < uSum && uSum < 22) {
				printScore();
				cService.printCard2();
				System.out.println("유저 승리!");
				uWin++;
				flag = false;;
			}else {
				printScore();
				cService.printCard2();
				System.out.println("무승부!");
				draw++;
				flag = false;;
			}
		}
		return flag;
	}
	
	public void printScore(){
		System.out.println("┌─────────────────┬─────────────────┬─────────────────┬───────────────────┐");
		System.out.printf ("│   딜러 : %2d승   │   유저 : %2d승   │   무승부 : %2d   │  남은카드 : %3d장 │\n",dWin,uWin,draw,cList.size());
		System.out.println("└─────────────────┴─────────────────┴─────────────────┴───────────────────┘");
//		System.out.println("┌─────────────────┬─────────────────┬─────────────────┐");
//		System.out.printf ("│   딜러 : %2d승   │   유저 : %2d승   │   무승부 : %2d   │\n",dWin,uWin,draw);
//		System.out.println("└─────────────────┴─────────────────┴─────────────────┘");
	}
	
	
	

	
//	//게임이 끝날때까지 반복
//	public boolean hitCard() {
//		Scanner scan = new Scanner(System.in);
//		//딜러 점수가 16이하일 경우 한장 추가
//		if(dSum < 17){
//			cService.addCard("deal");
//		}
//		// 점수가 21점이거나 넘어갔는지 체크
//		if(!socreOver()) {
//			// 21점이거나 넘어갔을경우 게임 끝
//			return flag;
//		}
//		cService.printCard2();
//		
//		
//		//유저 차례 진행
//		System.out.println("카드를 뽑으시겠습니까? (Y/N)");
//		System.out.print(">>>");
//		String str = scan.nextLine();
//		if(str.equals("Y")) {
//			// 뽑는다 선택시 유저카드 한장 추가
//			cService.addCard("user");
//		}else if(str.equals("N")){
//			// 안뽑는다 선택시 딜러 점수따라 카드 추가 후 진행
//			while(true){
//				if(dSum < 17){
//					cService.addCard("deal");
//				}else {
//					break;
//				}
//			}
//			if(dSum > 21) {
//				socreOver();
//			}
//			// 딜러와 유저 점수 비교
//			socreCompare();
//			return flag;
//		}
//		// 딜러와 유저 점수 비교
//		socreOver();
//		return flag;
//	}
	
}
