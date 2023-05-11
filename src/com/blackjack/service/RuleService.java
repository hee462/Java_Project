package com.blackjack.service;

public class RuleService {

	CardService cService;

	public RuleService() {
		cService = new CardService();

	}

	public void stratGame() {
		cService.CreateCard();
		
		for( int i =0 ; i < 2 ; i++) {
			cService.addCard("deal");
			cService.addCard("user");
		}
		
		cService.printCard();
	}
	
	
	public void hitCard() {
		
		
		
	}
}
