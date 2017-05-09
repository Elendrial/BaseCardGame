package me.elendrial.cardGameBase;

import java.awt.Graphics;
import java.util.Random;

import me.elendrial.cardGameBase.containers.BaseContainer;
import me.elendrial.cardGameBase.display.Window;

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
	
	public static void stopGame(){
		isRunning = false;
	}
	
	public static void render(Graphics g){
		mainContainer.render(g);
	}
	
}
