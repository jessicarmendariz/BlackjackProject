package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	private List<Card> cards;
	
	public Hand() {
		setCards(new ArrayList<>());
	}
	
	public void addCard(Card card) {
		getCards().add(card);
	}
	
	public void clear() {
		cards.clear();
	}
	
	public abstract int getHandValue();
	public String toString() {
		return "Hand [cards=" + getCards() + "]";
	}
	
	public List<Card> getCards() {
		return cards;
	}
	
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

}
