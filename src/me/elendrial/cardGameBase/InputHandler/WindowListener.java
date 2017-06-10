package me.elendrial.cardGameBase.InputHandler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import me.elendrial.cardGameBase.Controller;

public class WindowListener implements KeyListener, MouseListener, MouseMotionListener{

	// I don't know how this sort of thing should be implemented, but this works, so why not do it like this?
	
	public static WindowListener wListener = new WindowListener();
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		Controller.mainContainer.mouseDragged(arg0);
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		Controller.mainContainer.mouseMoved(arg0);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		Controller.mainContainer.mouseClicked(arg0);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		Controller.mainContainer.mouseEntered(arg0);
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		Controller.mainContainer.mouseExited(arg0);
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		Controller.mainContainer.mousePressed(arg0);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		Controller.mainContainer.mouseReleased(arg0);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		Controller.mainContainer.keyPressed(arg0);
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		Controller.mainContainer.keyReleased(arg0);
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		Controller.mainContainer.keyTyped(arg0);
	}

}
