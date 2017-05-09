package me.elendrial.cardGameBase.containers;

import java.awt.Graphics;
import java.util.ArrayList;

import me.elendrial.cardGameBase.decks.StandardDeck;

public class BaseContainer {
	
	public StandardDeck[] decks;
	public ArrayList<BaseCardContainer> shownCards = new ArrayList<BaseCardContainer>();
	
	public static int players;
	
	public BaseContainer(){}
	public BaseContainer(StandardDeck[] decks) {
		this.decks = decks;
	}

	public void render(Graphics g) {
		for(StandardDeck deck : decks) deck.render(g);
		for(BaseCardContainer card : shownCards) card.render(g);
	}
	
}
