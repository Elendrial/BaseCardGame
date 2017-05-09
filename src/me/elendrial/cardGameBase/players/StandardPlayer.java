package me.elendrial.cardGameBase.players;

import java.util.ArrayList;
import java.util.HashMap;

import me.elendrial.cardGameBase.cards.StandardCard;
import me.elendrial.cardGameBase.decks.StandardDeck;

public class StandardPlayer {
	
	public int playerNo;
	public StandardDeck[] decks;
	public ArrayList<StandardCard> hand = new ArrayList<StandardCard>();
	
	public HashMap<String, Object> identifiers = new HashMap<String, Object>();
	
}
