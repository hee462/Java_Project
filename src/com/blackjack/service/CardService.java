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
   // 딜러 카드 합계
   private int dSum = 0;
   // 유저 카드 합계
   private int uSum = 0;
   
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
               cDto.setDNum("J");
            }else if(i+1 == 12){
               cDto.setDNum("Q");
            }else if(i+1 == 13){
               cDto.setDNum("K");
            }else {
               cDto.setDNum((i+1)+"");
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
      
      // player에 따라 player패에 카드 추가
      if(player.equals("deal")) {
         dCardList.add(tempCardList.get(0));
      }else if(player.equals("user")) {
         uCardList.add(tempCardList.get(0));
      }else {
         // 딜러도 유저도 아닌 player가 들어올 경우
         System.err.println("ERROR");
      }

      cList.remove(rNum);
   }
   // 딜러카드 리스트 가져오기
   public List<CardDto> getDealList(){
	   return dCardList;
   }
   // 유저카드 리스트 가져오기   
   public List<CardDto> getUserList(){
	   return uCardList;
   }
   
   //카드 합계 계산
   public void score() {
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
   
   
   
   
   
   
   // test
   public void printCard() {
	  score();
      System.out.printf("-------딜러 %d 점-------\n",dSum);
      for(int i = 0; i<dCardList.size(); i++) {
         System.out.print("┌────┐ ");
      }
      System.out.println();
      for(int i = 0; i<dCardList.size(); i++) {
//    	  if(dCardList.get(i).getPattern().equals("♡") || dCardList.get(i).getPattern().equals("◇")) {
//    		  System.out.print ("│ ");
//    		  System.err.printf("%1s",dCardList.get(i).getPattern());
//    		  System.out.print ("  │ ");
//    	  }else {
//    	      System.out.printf ("│ %1s  │ ",dCardList.get(i).getPattern());
//    	  }
    	  System.out.printf ("│ %1s  │ ",dCardList.get(i).getPattern());
      }
      System.out.println();
      for(int i = 0; i<dCardList.size(); i++) {
         System.out.printf ("│ %2s │ ",dCardList.get(i).getDNum());
      }
      System.out.println();
      for(int i = 0; i<dCardList.size(); i++) {
         System.out.print("└────┘ ");
      }
      System.out.println();
//      System.out.println("-------유저카드-------");
      System.out.printf("-------유저 %d 점-------\n",uSum);
      for(int i = 0; i<uCardList.size(); i++) {
         System.out.print("┌────┐ ");
      }
      System.out.println();
      for(int i = 0; i<uCardList.size(); i++) {
//    	  if(uCardList.get(i).getPattern().equals("♡") || uCardList.get(i).getPattern().equals("◇")) {
//    		  System.out.print ("│ ");
//    		  System.err.printf("%1s",uCardList.get(i).getPattern());
//    		  System.out.print ("  │ ");
//    	  }else {
//    	      System.out.printf ("│ %1s  │ ",uCardList.get(i).getPattern());
//    	  }
         System.out.printf ("│ %1s  │ ",uCardList.get(i).getPattern());
      }
      System.out.println();
      for(int i = 0; i<uCardList.size(); i++) {
         System.out.printf ("│ %2s │ ",uCardList.get(i).getDNum());
      }
      System.out.println();
      for(int i = 0; i<uCardList.size(); i++) {
         System.out.print("└────┘ ");
      }
      System.out.println();
   }

   
	
	

}