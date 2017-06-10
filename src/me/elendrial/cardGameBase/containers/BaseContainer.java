package me.elendrial.cardGameBase.containers;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import me.elendrial.cardGameBase.Controller;
import me.elendrial.cardGameBase.decks.StandardDeck;

public class BaseContainer {
	
	public StandardDeck[] decks;
	public ArrayList<BaseCardContainer> shownCards = new ArrayList<BaseCardContainer>();
	public BufferedImage background;
	
	public int players;
	public int turn = 0;
	
	public BaseContainer(){}
	public BaseContainer(StandardDeck[] decks) {
		this();
		this.decks = decks;
	}

	public void render(Graphics g) {
		for(StandardDeck deck : decks) deck.render(g);
		for(BaseCardContainer card : shownCards) card.render(g);
		 g.drawImage(background, 0, 0, Controller.mainWindow.width, Controller.mainWindow.height, null);
	}
	
	
	public void mouseDragged(MouseEvent arg0) {}
	
	public void mouseMoved(MouseEvent arg0) {}
	
	public void mouseClicked(MouseEvent arg0) {}
	
	public void mouseEntered(MouseEvent arg0) {}
	
	public void mouseExited(MouseEvent arg0) {}
	
	public void mousePressed(MouseEvent arg0) {}
	
	public void mouseReleased(MouseEvent arg0) {}
	
	public void keyPressed(KeyEvent arg0) {}
	
	public void keyReleased(KeyEvent arg0) {}
	
	public void keyTyped(KeyEvent arg0) {}
	
}
