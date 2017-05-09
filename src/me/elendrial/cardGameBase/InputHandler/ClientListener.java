package me.elendrial.cardGameBase.InputHandler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import me.elendrial.cardGameBase.server.CardProtocol;

public class ClientListener implements Runnable{
	
	private static String computer;
	private static int port;
	private static boolean running = false;
	private static CardProtocol protocol;
	
	public static void connectToServer(String computer, int port, CardProtocol protocol){
		ClientListener.computer = computer;
		ClientListener.port = port;
		ClientListener.protocol = protocol;
		(new Thread(new ClientListener())).start();
	}
	
	public static void disconnectFromServer(String message){
		protocol.disconnect(message);
	}
	
	private void connectToServer(){
		System.out.println("Connecting to server at: " + computer + ":" + port);

		try ( 	Socket echo = new Socket(computer, port);
				PrintWriter out = new PrintWriter(echo.getOutputStream(), true); // Writing to what goes out of socket, not what comes out of socket.
				BufferedReader in = new BufferedReader(new InputStreamReader(echo.getInputStream())); // Reading what comes in from socket.
			) {
			
			protocol.setupVars(out, in);
			
			System.out.println("Successfully connected to server");
			
			out.println("init");
			
			while(running){
				protocol.recieveData();
			}
			
		} catch (Exception e) {e.printStackTrace();}
	}

	@Override
	public void run() {
		running = true;
		connectToServer();
	}
	
}
