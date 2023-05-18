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
      flag = rService.stratGame();
      while(flag) {
         flag = rService.dealTurn();
         flag = rService.userTurn();
      }
   }
}