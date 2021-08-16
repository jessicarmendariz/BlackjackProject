package com.skilldistillery.blackjack.app;

public class Playing {

	public BlackjackHand hand;

	public Player() {
		this.hand = new BlackjackHand();
	}

	public void ShowCardValueRank() {
		System.out.println(hand.getCards().get(0) + " and " + hand.getCards().get(1));
	}

	public void showHand() {
		System.out.println("Your hand: " + hand.getCards() + " " + hand.getHandValue());
	}

	public void playerWins() {
		System.out.println("WINNER WINNER, CHICKEN DINNER!");
		System.out.println("Play Again? Y or N");
	}
}
