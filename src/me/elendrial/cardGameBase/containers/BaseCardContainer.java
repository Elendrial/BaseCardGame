package me.elendrial.cardGameBase.containers;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

import me.elendrial.cardGameBase.cards.StandardCard;
import me.elendrial.cardGameBase.helpers.TextureHelper;

public class BaseCardContainer {
	
	public StandardCard card;
	public Point position = new Point(0,0);
	public Point size;
	public BufferedImage cardImage, cardBack;
	public boolean faceUp = true;
	
	
	public BaseCardContainer(){}
	
	public BaseCardContainer(StandardCard card){
		this.card = card;
	}
	
	public BaseCardContainer(StandardCard card, Point position, Point size, boolean faceUp) {
		this.card = card;
		this.position = position;
		this.size = size;
		
		if(card.textureName.contains("textures/cards/"))cardBack = TextureHelper.loadTexture(card.textureName.substring(0, card.textureName.lastIndexOf("/")), card.textureName.substring(card.textureName.lastIndexOf("/"+1)), this);
		else cardImage = TextureHelper.loadTexture("textures/cards/", card.textureName, this);
		
		if(card.backTextureName.contains("textures/cards/"))cardBack = TextureHelper.loadTexture(card.backTextureName.substring(0, card.backTextureName.lastIndexOf("/")), card.backTextureName.substring(card.backTextureName.lastIndexOf("/"+1)), this);
		else cardBack = TextureHelper.loadTexture("textures/cards/", card.backTextureName, this);
		
		this.faceUp = faceUp;
	}
	
	public void render(Graphics g){
		if(faceUp) g.drawImage(cardImage, position.x, position.y, size.x, size.y, null);
		else       g.drawImage(cardBack, position.x, position.y, size.x, size.y, null);
		
	}
	
}
