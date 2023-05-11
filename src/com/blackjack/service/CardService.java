package com.blackjack.service;

import java.util.ArrayList;
import java.util.List;

import com.blackjack.models.CardDto;

public class CardService {
	// 카드 뭉치
	private List<CardDto> cList;
	// 딜러 카드
	private List<CardDto> dCardList;
	// 사용자 카드
	private List<CardDto> uCardList;
	// 임시 카드 저장소
	private List<CardDto> tempCardList;
	
	private int rNum = 0;
	
	public CardService(){
		cList = new ArrayList<>();
		dCardList = new ArrayList<>();
		uCardList = new ArrayList<>();
	}
	
	public void CreateCard() {
		String pattern = "♠";
		// 카드뭉치 생성
		for(int pNum = 0; pNum< 4; pNum++) {
			// 카드문양 생성
			if(pNum == 0) {
				pattern = "♠";
			}else if(pNum == 1){
				pattern = "♣";
			}else if(pNum == 2){
				pattern = "♡";
			}else if(pNum == 3){
				pattern = "◇";
			}
			// 카드번호 생성
			for(int i = 0; i< 13; i++){
				CardDto cDto = new CardDto();
				cDto.setPattern(pattern);
				if(i+1 == 11) {
					cDto.setDenomination("J");
				}else if(i+1 == 12){
					cDto.setDenomination("Q");
				}else if(i+1 == 13){
					cDto.setDenomination("K");
				}else {
					cDto.setDenomination((i+1)+"");
				}
				cList.add(cDto);
			}
		}
	}
	// player 유저와 딜러 구분하기 위한 변수
	public void addCard(String player) {
		tempCardList = new ArrayList<>();
		// 카드뭉치에서 랜덤하게 한장 뽑기
		rNum = (int)(Math.random()*cList.size());
		// 임시 카드뭉치에 뽑힌 한장을 담기
		tempCardList.add(cList.get(rNum));
		
		if(player.equals("deal")) {
			
		}

		player.equals("user");
		;
		
	}
	
	
	// test
//	public void printCard() {
//		
//		rNum = (int)(Math.random()*cList.size());
//		System.out.println(rNum);
//		dCardList.add(cList.get(rNum));
//		
//		System.out.println(cList.size());
//		for(int i = 0; i<dCardList.size(); i++) {
//			System.out.print("┌────┐ ");
//		}
//		System.out.println();
//		for(int i = 0; i<dCardList.size(); i++) {
//			System.out.printf ("│ %1s  │ ",dCardList.get(i).getPattern());
//		}
//		System.out.println();
//		for(int i = 0; i<dCardList.size(); i++) {
//			System.out.printf ("│ %2s │ ",dCardList.get(i).getDenomination());
//		}
//		System.out.println();
//		for(int i = 0; i<dCardList.size(); i++) {
//			System.out.print("└────┘ ");
//		}
//		cList.remove(rNum);
//	}


}
