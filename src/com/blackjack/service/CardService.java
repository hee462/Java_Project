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
      dCardList = new ArrayList<>();
      uCardList = new ArrayList<>();
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
   
   // 카드 출력
   public void printCard() {
	  score();
	  for(int i = 0; i < 30; i++) {
		  System.out.println();
	  }
      System.out.printf("-------딜러 %d 점-------\n",dSum);
      for(int i = 0; i<dCardList.size(); i++) {
         System.out.print("┌────┐ ");
      }
      System.out.println();
      for(int i = 0; i<dCardList.size(); i++) {
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
      System.out.printf("-------유저 %d 점-------\n",uSum);
      for(int i = 0; i<uCardList.size(); i++) {
         System.out.print("┌────┐ ");
      }
      System.out.println();
      for(int i = 0; i<uCardList.size(); i++) {
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
   
   
   public void printCard2() {
		  score();
		  for(int i = 0; i < 30; i++) {
			  System.out.println();
		  }
	      System.out.printf("-----------딜러 %d 점-----------\n",dSum);
	      for(int i = 0; i<dCardList.size(); i++) {
	         System.out.print("┌─────────────┐ ");
	      }
	      System.out.println();
	      for(int i = 0; i<dCardList.size(); i++) {
	    	  if(dCardList.get(i).getDNum().equals("1")) {
	    		  System.out.printf ("│%2s           │ ","A");
	    	  }else {
		    	  System.out.printf ("│%2s           │ ",dCardList.get(i).getDNum());
	    	  }
	      }
	      System.out.println(); // 1
	      for(int i = 0; i<dCardList.size(); i++) {
	    	  if(dCardList.get(i).getDNum().equals("1")){
	    		  System.out.printf ("│             │ ");
	    	  }else if(dCardList.get(i).getDNum().equals("2")||dCardList.get(i).getDNum().equals("3")){
	    		  System.out.printf ("│     %2s      │ ",dCardList.get(i).getPattern());
	    	  }else {
	    		  System.out.printf ("│ %2s      %2s  │ ",dCardList.get(i).getPattern(),dCardList.get(i).getPattern());
	    	  }
	      }
	      System.out.println(); //2
	      for(int i = 0; i<dCardList.size(); i++) {
	    	  if(dCardList.get(i).getDNum().equals("7") || dCardList.get(i).getDNum().equals("10") ||
	    		 dCardList.get(i).getDNum().equals("J") || dCardList.get(i).getDNum().equals("Q") ||
	    		 dCardList.get(i).getDNum().equals("K")){
	    		  System.out.printf ("│     %2s      │ ",dCardList.get(i).getPattern());
	    	  }else {
	    		  System.out.printf ("│             │ ");
	    	  }
	      }
	      System.out.println(); //3
	      for(int i = 0; i<dCardList.size(); i++) {
	    	  if(dCardList.get(i).getDNum().equals("8")  || dCardList.get(i).getDNum().equals("9") || 
	    		 dCardList.get(i).getDNum().equals("10") || dCardList.get(i).getDNum().equals("J") || 
	    		 dCardList.get(i).getDNum().equals("Q")  || dCardList.get(i).getDNum().equals("K")){
	    		  System.out.printf ("│ %2s      %2s  │ ",dCardList.get(i).getPattern(),dCardList.get(i).getPattern());
	    	  }else {
	    		  System.out.printf ("│             │ ");
	    	  }
	      }
	      System.out.println(); //4
	      for(int i = 0; i<dCardList.size(); i++) {
	    	  if(dCardList.get(i).getDNum().equals("1") || dCardList.get(i).getDNum().equals("3") ||
	    		 dCardList.get(i).getDNum().equals("5") || dCardList.get(i).getDNum().equals("9")){
	    		  System.out.printf ("│     %2s      │ ",dCardList.get(i).getPattern());
	    	  }else if(dCardList.get(i).getDNum().equals("6")||dCardList.get(i).getDNum().equals("7")){
	    		  System.out.printf ("│ %2s      %2s  │ ",dCardList.get(i).getPattern(),dCardList.get(i).getPattern());
	    	  }else {
	    		  System.out.printf ("│             │ ");
	    	  }
	      }
	      System.out.println(); //5 
	      for(int i = 0; i<dCardList.size(); i++) {
	    	  if(dCardList.get(i).getDNum().equals("8")  || dCardList.get(i).getDNum().equals("9") || 
	    	     dCardList.get(i).getDNum().equals("10") || dCardList.get(i).getDNum().equals("J") || 
	    		 dCardList.get(i).getDNum().equals("Q")  || dCardList.get(i).getDNum().equals("K")){
	    		  System.out.printf ("│ %2s      %2s  │ ",dCardList.get(i).getPattern(),dCardList.get(i).getPattern());
	    	  }else {
	    		  System.out.printf ("│             │ ");
	    	  }
	      }
	      System.out.println();//6
	      for(int i = 0; i<dCardList.size(); i++) {
	    	  if(dCardList.get(i).getDNum().equals("10") || dCardList.get(i).getDNum().equals("J") || 
	    		 dCardList.get(i).getDNum().equals("Q")  || dCardList.get(i).getDNum().equals("K")){
	    		  System.out.printf ("│     %2s      │ ",dCardList.get(i).getPattern());
	    	  }else {
	    		  System.out.printf ("│             │ ");
	    	  }
	      }
	      System.out.println();//7
	      for(int i = 0; i<dCardList.size(); i++) {
	    	  if(dCardList.get(i).getDNum().equals("1")) {
 	    		  System.out.printf ("│             │ ");
	    	  }else if(dCardList.get(i).getDNum().equals("2") || dCardList.get(i).getDNum().equals("3")){
	 	    		  System.out.printf ("│     %2s      │ ",dCardList.get(i).getPattern());
	 	      }else{
 	    		  System.out.printf ("│ %2s      %2s  │ ",dCardList.get(i).getPattern(),dCardList.get(i).getPattern());
 	    	  }
	      }
	      System.out.println();
	      for(int i = 0; i<dCardList.size(); i++) {
	    	  if(dCardList.get(i).getDNum().equals("1")) {
	    		  System.out.printf ("│           %-2s│ ","A");
	    	  }else {
		    	  System.out.printf ("│           %-2s│ ",dCardList.get(i).getDNum());
	    	  }
	      }
	      System.out.println();
	      for(int i = 0; i<dCardList.size(); i++) {
	         System.out.print("└─────────────┘ ");
	      }
	      System.out.println();
	      System.out.printf("-----------유저 %d 점-----------\n",uSum);
	      for(int i = 0; i<uCardList.size(); i++) {
	         System.out.print("┌─────────────┐ ");
	      }
	      System.out.println();
	      for(int i = 0; i<uCardList.size(); i++) {
	    	  if(uCardList.get(i).getDNum().equals("1")) {
	    		  System.out.printf ("│%2s           │ ","A");
	    	  }else {
		    	  System.out.printf ("│%2s           │ ",uCardList.get(i).getDNum());
	    	  }
	      }
	      System.out.println(); // 1
	      for(int i = 0; i<uCardList.size(); i++) {
	    	  if(uCardList.get(i).getDNum().equals("1")){
	    		  System.out.printf ("│             │ ");
	    	  }else if(uCardList.get(i).getDNum().equals("2")||uCardList.get(i).getDNum().equals("3")){
	    		  System.out.printf ("│     %2s      │ ",uCardList.get(i).getPattern());
	    	  }else {
	    		  System.out.printf ("│ %2s      %2s  │ ",uCardList.get(i).getPattern(),uCardList.get(i).getPattern());
	    	  }
	      }
	      System.out.println(); //2
	      for(int i = 0; i<uCardList.size(); i++) {
	    	  if(uCardList.get(i).getDNum().equals("7") || uCardList.get(i).getDNum().equals("10") ||
	    		 uCardList.get(i).getDNum().equals("J") || uCardList.get(i).getDNum().equals("Q") ||
	    		 uCardList.get(i).getDNum().equals("K")){
	    		  System.out.printf ("│     %2s      │ ",uCardList.get(i).getPattern());
	    	  }else {
	    		  System.out.printf ("│             │ ");
	    	  }
	      }
	      System.out.println(); //3
	      for(int i = 0; i<uCardList.size(); i++) {
	    	  if(uCardList.get(i).getDNum().equals("8")  || uCardList.get(i).getDNum().equals("9") || 
	    		 uCardList.get(i).getDNum().equals("10") || uCardList.get(i).getDNum().equals("J") || 
	    		 uCardList.get(i).getDNum().equals("Q")  || uCardList.get(i).getDNum().equals("K")){
	    		  System.out.printf ("│ %2s      %2s  │ ",uCardList.get(i).getPattern(),uCardList.get(i).getPattern());
	    	  }else {
	    		  System.out.printf ("│             │ ");
	    	  }
	      }
	      System.out.println(); //4
	      for(int i = 0; i<uCardList.size(); i++) {
	    	  if(uCardList.get(i).getDNum().equals("1") || uCardList.get(i).getDNum().equals("3") ||
	    		 uCardList.get(i).getDNum().equals("5") || uCardList.get(i).getDNum().equals("9")){
	    		  System.out.printf ("│     %2s      │ ",uCardList.get(i).getPattern());
	    	  }else if(uCardList.get(i).getDNum().equals("6")||uCardList.get(i).getDNum().equals("7")){
	    		  System.out.printf ("│ %2s      %2s  │ ",uCardList.get(i).getPattern(),uCardList.get(i).getPattern());
	    	  }else {
	    		  System.out.printf ("│             │ ");
	    	  }
	      }
	      System.out.println(); //5 
	      for(int i = 0; i<uCardList.size(); i++) {
	    	  if(uCardList.get(i).getDNum().equals("8")  || uCardList.get(i).getDNum().equals("9") || 
	    	     uCardList.get(i).getDNum().equals("10") || uCardList.get(i).getDNum().equals("J") || 
	    		 uCardList.get(i).getDNum().equals("Q")  || uCardList.get(i).getDNum().equals("K")){
	    		  System.out.printf ("│ %2s      %2s  │ ",uCardList.get(i).getPattern(),uCardList.get(i).getPattern());
	    	  }else {
	    		  System.out.printf ("│             │ ");
	    	  }
	      }
	      System.out.println();//6
	      for(int i = 0; i<uCardList.size(); i++) {
	    	  if(uCardList.get(i).getDNum().equals("10") || uCardList.get(i).getDNum().equals("J") || 
	    		 uCardList.get(i).getDNum().equals("Q")  || uCardList.get(i).getDNum().equals("K")){
	    		  System.out.printf ("│     %2s      │ ",uCardList.get(i).getPattern());
	    	  }else {
	    		  System.out.printf ("│             │ ");
	    	  }
	      }
	      System.out.println();//7
	      for(int i = 0; i<uCardList.size(); i++) {
	    	  if(uCardList.get(i).getDNum().equals("1")) {
 	    		  System.out.printf ("│             │ ");
	    	  }else if(uCardList.get(i).getDNum().equals("2") || uCardList.get(i).getDNum().equals("3")){
	 	    		  System.out.printf ("│     %2s      │ ",uCardList.get(i).getPattern());
	 	      }else{
 	    		  System.out.printf ("│ %2s      %2s  │ ",uCardList.get(i).getPattern(),uCardList.get(i).getPattern());
 	    	  }
	      }
	      System.out.println();
	      for(int i = 0; i<uCardList.size(); i++) {
	    	  if(uCardList.get(i).getDNum().equals("1")) {
	    		  System.out.printf ("│           %-2s│ ","A");
	    	  }else {
		    	  System.out.printf ("│           %-2s│ ",uCardList.get(i).getDNum());
	    	  }
	      }
	      System.out.println();
	      for(int i = 0; i<uCardList.size(); i++) {
	         System.out.print("└─────────────┘ ");
	      }
	      System.out.println();
	   }

   
	
	

}