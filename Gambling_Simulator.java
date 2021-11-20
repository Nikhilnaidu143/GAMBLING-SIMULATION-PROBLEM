package com.gambling.simulator;

public class Gambling_Simulator {
	/** Instance variables **/
	static int Account_balance = 100;   // player start betting daily with a stake of 100.
	static int num_of_wins_in_day = 0;
	static int num_of_losses_in_day = 0;
	
	//constant variable
	static final int BET = 1;  // player bets 1 for every game
	
	
	/** UC-2 :- As a Gambler make 1 bet so either win or loose 1. **/
	public static void playerWinOrLoose() {
		/* Random check for win or loose checking */
		int random_Check = (int)Math.floor(Math.random()*2);
		switch(random_Check) {
			case 1 :
				num_of_wins_in_day++;
				Account_balance += BET;   // increasing stake/account_balance by 1 if player won the bet.
				break;
			default :
				num_of_losses_in_day++;
				Account_balance -= BET;   // decreasing stake/account_balance by 1 if player loose the bet.
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
			
			if(Account_balance == 150 || Account_balance == 50) {  // if these conditions satisfied then loop will break.
				break;
			}
		}
		System.out.println("Gambler Account balance :- " + Account_balance);
		System.out.println("Gambler total number of wins in a day :- " + num_of_wins_in_day);
		System.out.println("Gambler total number of losses in a day :- " + num_of_losses_in_day + "\n");
		
		num_of_wins_in_day = 0;  // making zero bcoz for next day i want to count from fresh to print every day report.
		num_of_losses_in_day = 0; // making zero bcoz for next day i want to count from fresh to print every day report
		Account_balance = 100;  // makind 100 bcoz for next day player again starts from 100 only.
	}
	
	/** UC-4 :- After 20 days of playing every day would like to know the total amount won or lost. **/
	public static void twentyDays() {
		for(int day = 1; day <= 20; day++) {     // gambling for 20 days
			System.out.println("DAY-" + day + " :-");
			gambling();
		}
	}
	
	/** Main method(Program execution starts from main method.). **/
	public static void main(String[] args) {
		/** Displayed Welcome message **/
		System.out.println("------------WELCOME TO GAMBLING SIMULATOR---------------\n");
		twentyDays();
	}
}
