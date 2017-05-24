package me.elendrial.cardGameBase.display;

import java.awt.Canvas;
import java.awt.Graphics;

import me.elendrial.cardGameBase.Controller;
import me.elendrial.cardGameBase.InputHandler.WindowListener;

@SuppressWarnings("serial")
public class Display extends Canvas{
	
	public int cameraSpeed = 2;
	public int scale = 1;
	
	public Display(Window window) {
		setBounds(0, 0, window.width, window.height);
		this.addKeyListener(WindowListener.wListener);
		this.addMouseListener(WindowListener.wListener);
		this.addMouseMotionListener(WindowListener.wListener);
	}
	
	public void render(Graphics g){
		Controller.render(g);
	}


}
