package me.elendrial.cardGameBase.display;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import me.elendrial.cardGameBase.Controller;

public class Window implements Runnable{
	
	// Actual window
    public JFrame frame;
    public Display display;
    
    public int width, height;
    public String title;

    public boolean isRunning;
    
    public Window(){}
    public Window(String TITLE, int WIDTH, int HEIGHT){
        // Set the variables
        this.title = TITLE;
        this.width = WIDTH;
        this.height = HEIGHT;

        // Setup Window
        this.frame = new JFrame(TITLE);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
        
        createGUI();
        
        this.frame.setResizable(false);
        this.frame.pack();
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
    }

	public void createGUI(){
		this.display = new Display(this);
		this.frame.add(this.display);
	}
    
    public void start(){
        isRunning = true;
        new Thread(this).start();
    }

    public void stop(){
        isRunning = false;
    }

	public void render(){
		// Buffer Strategy
        BufferStrategy bs = this.display.getBufferStrategy();
        if(bs == null){
        	this.display.createBufferStrategy(2);
            this.display.requestFocus();
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        
        // Clear the graphics
        g.clearRect(0, 0, width, height);
        
        // Draw the display
        this.display.render(g);
        
        g.dispose();
        bs.show();
    }

    
    // Tick is deliberately throttled, it should only happen ever 'x' ms
    // fps should happen as fast as it can, since it renders
    public int fps = 0;
    @Override
    public void run() {
        double fpsTimer = System.currentTimeMillis();
    	while(Controller.isRunning && isRunning){
            
            // This is NOT to sleep, but to limit the game loop
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            render();
            fps++;
            
            if(System.currentTimeMillis() - fpsTimer >= 1000){
                fps = 0;
                fpsTimer += 1000;
            }
        }

        // When the gameloop is finished running, close the program
        this.frame.dispatchEvent(new WindowEvent(this.frame, WindowEvent.WINDOW_CLOSING));
	
    }

}
