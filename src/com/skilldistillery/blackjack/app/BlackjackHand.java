package com.skilldistillery.blackjack.app;

import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.Hand;

public class BlackjackHand extends Hand {

	public int getHandValue() {
		int sum = 0;
		for (Card card : this.getCards()) {
			sum += card.getValue();
		}
		return sum;
	}

	public boolean isBlackJack() {
		int sum = getHandValue();
		if (sum == 21) {
			return true;
		} else {
			return false;
		}
	}

	public boolean bust() {
		int sum = getHandValue();
		if (sum > 21) {
			return true;
		} else {
			return false;
		}
	}
}
