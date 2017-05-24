package me.elendrial.cardGameBase.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GameClient implements Runnable{
	
	private static String computer;
	private static int port;
	private static boolean running = false;
	private static GameProtocol protocol;
	
	public static void connectToServer(String computer, int port, GameProtocol protocol){
		GameClient.computer = computer;
		GameClient.port = port;
		GameClient.protocol = protocol;
		(new Thread(new GameClient())).start();
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
