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
	
	/** Main method(Program execution starts from main method.). **/
	public static void main(String[] args) {
		/** Displayed Welcome message **/
		System.out.println("------------WELCOME TO GAMBLING SIMULATOR---------------\n");
		playerWinOrLoose();
	}
}
