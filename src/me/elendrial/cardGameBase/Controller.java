package me.elendrial.cardGameBase;

import java.awt.Graphics;
import java.util.Random;

import me.elendrial.cardGameBase.containers.BaseContainer;
import me.elendrial.cardGameBase.display.Window;
import me.elendrial.cardGameBase.server.CardProtocol;
import me.elendrial.cardGameBase.server.CardServer;

public class Controller {
	
	public static boolean isRunning = false;
	
	public static Random rand = new Random();
	public static Window mainWindow;
	public static BaseContainer mainContainer;
	
	public static void startGame(Window w){
		mainWindow = w;
		isRunning = true;
		mainWindow.start();
	}
	
	public static void startGame(String windowTitle, int windowWidth, int windowHeight){
		startGame(new Window(windowTitle, windowWidth, windowHeight));
	}
	
	public static void startGameAsHost(String windowTitle, int windowWidth, int windowHeight, int port, CardProtocol protocol){
		startGame(windowTitle, windowWidth, windowHeight);
		CardServer.hostServer(port, protocol);
	}
	
	public static void startGameServerConnect(String windowTitle, int windowWidth, int windowHeight, String computer, int port, CardProtocol protocol){
		
	}
	
	public static void stopGame(){
		isRunning = false;
	}
	
	public static void render(Graphics g){
		mainContainer.render(g);
	}
	
}
