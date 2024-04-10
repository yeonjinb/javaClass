package game;// Enjoy blackjack
// dr.seungchul@gmail.com
// To do list
// 1. make displayStats( ) method
// 2. 'A' should be 1 or 11
// 3. BlackJack = AJ, AK, AQ
// 4. insurance
// 5. split

import java.util.Random;
import java.util.Scanner;

public class BlackJackTest {
	static int stage = 1;
	static int win = 0;
	static int lose = 0;
	static int tie = 0;
	static boolean isExit = false;
	static Random random = new Random();

	
	public static void main(String[] args) {
		int card = 0;
		
		System.out.println("	Welcome to yj's Casino! \n");

		card = hit(card);
		while (!isExit) {			
			card = round(card);
		}

	}
		
	private static int hit(int card) {
		card = getCard(card);
		
		if (card > 21) { 			
			System.out.println("You have "+card+", Over 21! You lose.\n\n");
			stage++;
			lose++;
			System.out.println("----------------------");
			card = 0;
			card = getCard(card);			
		}
		if (card == 21) {
			System.out.println("You have "+card+", BLACKJACK! You win!!\n\n");
			stage++;
			lose++;
			System.out.println("----------------------");
			card = 0;
			card = getCard(card);
		}
		
		return card;					
	}

	private static int getCard(int card) {
		int newCard = random.nextInt(13) + 1;
		Scanner sc = new Scanner(System.in);
		System.out.println("stage " + stage);
		if (newCard == 1) {
			System.out.println("New card is  A");
			System.out.println("Choose 1 or 11");
			int numA = sc.nextInt();
			while (numA != 1 && numA != 11) {
				System.out.println("Invalid one");
				System.out.println("Please choose 1 or 11");
				numA = sc.nextInt();
			}
			card += numA;
		}
		else if ((newCard > 1) && (newCard < 11)) {
			card += newCard;
			System.out.println("New card is " + newCard);
		}
		else if (newCard == 11) {
			card += 10;
			System.out.println("New card is JACK");
		}
		else if (newCard == 12) {
			card += 10;
			System.out.println("New card is QUEEN");
		}
		else {
			card += 10;
			System.out.println("New card is KING");			
		}

		return card;
	}
	

	private static int round(int card) {
		int choice;


		System.out.println("You have "+ card);
		choice = options();
		
		switch (choice) {
			case 1:
				card = hit(card);
				break;
			case 2:				
				card = hold(card);
				break;
			case 3:			
				isExit = true;

				displayStats();
				break;
		}

		return card;
	}

	private static int options() {
		System.out.println("	1. Hit");
		System.out.println("	2. Hold");
		System.out.println("	3. Exit");
		System.out.print("Choose an option: ");

		Scanner input = new Scanner(System.in);		
		int choice = input.nextInt();
		System.out.println();
		
		while ((choice < 1) || (choice > 3)) {
			System.out.println("Invalid input!");
			System.out.println("Please enter an integer value between 1 and 4.");
			System.out.println("	1. Hit");
			System.out.println("	2. Hold");
			System.out.println("	3. Exit");
			System.out.print("Choose an option: ");			
			choice = input.nextInt();
		}
		
		return choice;
	}

	private static int hold(int card) {
		int dealer = random.nextInt(11) + 16;
		System.out.println("Dealer's hand: " + dealer);
		System.out.println("Your hand is: " + card);
		
		if ((card > dealer) || (dealer > 21)) {
			System.out.println("You win!\n\n");
			win++;
			System.out.println("----------------------");
		}
		else if (card < dealer) {
			System.out.println("Dealer win!\n\n");
			lose++;
			System.out.println("----------------------");
		}
		else {
			System.out.println("It's a tie! No one wins!\n\n");
			tie++;
			System.out.println("----------------------");
		}stage++;


		card = 0;
		card = hit(card);
		return card;
	}

	private static void displayStats() {
		// wins, ties, game statistics
		System.out.println("Number of Player wins: " + win);
		System.out.println("Number of Dealer wins: " + lose);
		System.out.println("Number of tie games: " + tie);
		System.out.println("Total # of games played is: " + stage);
		double PoW = (double) win / stage * 100;
		System.out.println("Percentage of Player wins: " + PoW + "%");
		System.out.println();
	}
}
