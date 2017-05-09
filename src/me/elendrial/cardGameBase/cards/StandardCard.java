package me.elendrial.cardGameBase.cards;

public class StandardCard {
	
	public String name;
	public String desc;
	public String code;
	public String textureName;
	public String backTextureName;
	public String[] identifiers;
	
	public StandardCard(){}

	public StandardCard(String name, String desc, String code, String textureName, String backTextureName, String[] identifiers) {
		this.name = name;
		this.desc = desc;
		this.code = code;
		this.textureName = textureName.contains("textures/cards/") ? textureName : "textures/cards/" + textureName;
		this.backTextureName =  backTextureName.contains("textures/cards/") ? backTextureName : "textures/cards/" + backTextureName;
		this.identifiers = identifiers;
	}
	
	
	public StandardCard clone(){
		return new StandardCard(name, desc, code, textureName, backTextureName, identifiers);
	}
	
}
