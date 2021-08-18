package com.skilldistillery.blackjack.app;

import java.util.Scanner;
import com.skilldistillery.blackjack.entities.*;

public class BlackjackApp {

	public Playing p1;
	public Dealing d;
	public Deck deck;
	public Scanner kb;

	public static void main(String[] args) {
		BlackjackApp blackJack = new BlackjackApp();
		blackJack.run();
	}

	public void run() {
		kb = new Scanner(System.in);
		this.p1 = new Playing();
		this.d = new Dealing();
		this.deck = new Deck();

		System.out.println("Welcome to Brotherly Love Blackjack");
		System.out.println("Would you like to play Blackjack? Y or N");
		String input = kb.nextLine();
		if (input.equals("N")) {
			System.out.println("Alrighty Then, Goodbye!");
		} else {
			System.out.println("Alrighty Then, Take a Seat!");
			System.out.println("Ready? Y or N");
			input = kb.nextLine();
			if (input.equals("Y")) {
				newGame();
			}
		}
	}

	private void newGame() {
		this.deck.shuffle();
		this.p1.hand.addCard(this.deck.dealCard());
		this.d.dealerHand.addCard(this.deck.dealCard());
		this.p1.hand.addCard(this.deck.dealCard());
		this.d.dealerHand.addCard(this.deck.dealCard());
		System.out.println("Dealer has: ");
		this.d.ShowCardValueRank();
		System.out.println("You have ");
		this.p1.ShowCardValueRank();
		checkHand();
	}

	private void hitOrStay() {
		System.out.println("H to Hit or S to Stay");
		String option = kb.nextLine();
		if (option.equals("H")) {
			this.p1.hand.addCard(this.deck.dealCard());
			this.p1.showHand();
			checkHand();
		} else if (option.equals("S")) {
			System.out.println("You: " + this.p1.hand.getCards() + " " + this.p1.hand.getHandValue());
			dealerTurn();
		}
	}

	private void dealerTurn() {
		while (this.d.dealerHand.getHandValue() < 17) {
			d.dealerHand.addCard(this.deck.dealCard());
		}
		whoWins();
	}

	private void checkHand() {
		if (this.p1.hand.bust()) {
			System.out.println("BUST!");
			whoWins();
		}
		
		if (this.p1.hand.bust() || !this.p1.hand.isBlackJack()) {
			hitOrStay();}
		}

	private void whoWins() {

		if (this.p1.hand.bust() || this.d.dealerHand.isBlackJack()
				|| !this.d.dealerHand.bust() && this.d.dealerHand.getHandValue() > this.p1.hand.getHandValue()) {
			this.d.showHand();
			d.dealerWins();
		}

		if (this.p1.hand.isBlackJack() || this.d.dealerHand.bust()
				|| !this.p1.hand.bust() && this.p1.hand.getHandValue() > this.d.dealerHand.getHandValue()) {
			this.d.showHand();
			p1.playerWins();

		}

		if (this.p1.hand.getHandValue() == this.d.dealerHand.getHandValue()) {
			this.d.showHand();
			System.out.println("Push");
		}

		String playAgain = kb.nextLine();
		if (playAgain.equals("Y")) {
			this.d.dealerHand.clear();
			this.p1.hand.clear();
			Deck deck = new Deck();
			newGame();

		} else if (playAgain.equals("N")) {
			System.out.println("Good Game!");
		}

		kb.close();
	}

}
