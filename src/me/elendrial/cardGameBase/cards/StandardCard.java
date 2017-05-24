package me.elendrial.cardGameBase.cards;

import java.util.HashMap;

public class StandardCard /*implements Serializable*/{
	
	
	//private static final long serialVersionUID = 1217722197989343764L;
	public String name;
	public String text;
	public String id;
	public String textureName;
	public String backTextureName;
	public HashMap<String, Object> identifiers = new HashMap<String, Object>();
	
	public StandardCard(){}
	
	public StandardCard(String name, String desc, String code, String textureName, String backTextureName, HashMap<String, Object> identifiers) {
		this.name = name;
		this.text = desc;
		this.id = code;
		this.textureName = textureName.contains("textures/cards/") ? textureName : "textures/cards/" + textureName;
		this.backTextureName =  backTextureName.contains("textures/cards/") ? backTextureName : "textures/cards/" + backTextureName;
		this.identifiers = identifiers;
	}
	
	
	public StandardCard clone(){
		return new StandardCard(name, text, id, textureName, backTextureName, identifiers);
	}
	
}
