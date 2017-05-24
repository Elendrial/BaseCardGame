package me.elendrial.cardGameBase;

import java.awt.Graphics;
import java.util.Random;

import me.elendrial.cardGameBase.containers.BaseContainer;
import me.elendrial.cardGameBase.display.Window;
import me.elendrial.cardGameBase.server.GameClient;
import me.elendrial.cardGameBase.server.GameProtocol;
import me.elendrial.cardGameBase.server.GameServer;

public class Controller {
	
	public static boolean isRunning = false;
	
	public static Random rand = new Random();
	public static Window mainWindow;
	public static BaseContainer mainContainer;
	
	private static void startGame(){
		isRunning = true;
		mainWindow.start();
	}
	 
	public static void startGame(Window w){
		mainWindow = w;
		startGame();
	}
	
	public static void startGame(String windowTitle, int windowWidth, int windowHeight){
		startGame(new Window(windowTitle, windowWidth, windowHeight));
	}
	
	public static void startGameAsHost(String windowTitle, int windowWidth, int windowHeight, int port, Class<? extends GameProtocol> protocol){
		startGame(windowTitle, windowWidth, windowHeight);
		GameServer.hostServer(port, protocol);
	}
	
	public static void startGameServerConnect(String computer, int port, GameProtocol protocol){
		GameClient.connectToServer(computer, port, protocol);
		startGame();
	}
	
	public static void stopGame(){
		isRunning = false;
	}
	
	public static void render(Graphics g){
		mainContainer.render(g);
	}
	
}
