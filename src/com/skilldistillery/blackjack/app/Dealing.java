package com.skilldistillery.blackjack.app;

import java.util.List;
import com.skilldistillery.blackjack.entities;

public class Dealing {
	public BlackjackHand dealerHand;

	public Dealer() {
		this.dealerHand = new BlackjackHand();
	}

	public void ShowCardValueRank() {
		System.out.println(dealerHand.getCards().get(1));
	}

	private void printHandandValue(List<Card> ahnd, int value) {
		for (Card card : hand) {
			System.out.println(card);
		}
		System.out.println("Total Value: " + value);
	}

	public void dealerWins() {
		System.out.println("The House Always WINS! Better luck next time!");
		System.out.println(Play Again? Y or N);
	}

	public void showHand() {
		System.out.println("Dealer Hand: " + dealerHand.getCards() + " " + dealerHand.getHandValue());
	}
}
