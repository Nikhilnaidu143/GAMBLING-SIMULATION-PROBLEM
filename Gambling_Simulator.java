package com.gambling.simulator;

public class Gambling_Simulator {
	/** Instance variables **/
	static int Account_balance = 100;   // player start betting daily with a stake of 100.
	
	//constant variable
	static final int BET = 1;  // player bets 1 for every game
	
	
	/** UC-2 :- As a Gambler make 1 bet so either win or loose 1. **/
	public static void playerWinOrLoose() {
		/* Random check for win or loose checking */
		int random_Check = (int)Math.floor(Math.random()*2);
		switch(random_Check) {
			case 1 :
				Account_balance += BET;   // increasing stake/account_balance by 1 if player won the bet.
				System.out.println("Player won the bet.\n");
				System.out.println("Player Account balance :- " + Account_balance);
				break;
			default :
				Account_balance -= BET;   // decreasing stake/account_balance by 1 if player loose the bet.
				System.out.println("Player loose the bet.\n");
				System.out.println("Player Account balance :- " + Account_balance);
		}	
	}
	
	/** UC-3 :- As a Calculative Gambler if won or lost 50% of the stake, would resign for the day. **/
	public static void gambling() {
		int temp_balance = Account_balance;  // temporay variable to hold account balance 100.
		// calculating 50%
		int fifty_percent = (50/100)*temp_balance;
		
		while(Account_balance <= (Account_balance + fifty_percent) ||
			  Account_balance >= (Account_balance - fifty_percent)) {
			
			playerWinOrLoose();  //calling playerWinOrLoose method.
			
			if(Account_balance == 150 || Account_balance == 50) {
				break;
			}
		}
	}
	
	
	/** Main method(Program execution starts from main method.). **/
	public static void main(String[] args) {
		/** Displayed Welcome message **/
		System.out.println("------------WELCOME TO GAMBLING SIMULATOR---------------\n");
		gambling();
	}
}