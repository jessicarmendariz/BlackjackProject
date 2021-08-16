package com.skilldistillery.blackjack.entities;

public enum Suit {
	HEARTS("Hearts"), SPADES("Spades"), CLUBS("Clubs"), DIAMONDS("Diamonds");

	private String card;

	Suit(String c) {
		this.card = c;
	}

	public String toString() {
		return card;
	}
}
