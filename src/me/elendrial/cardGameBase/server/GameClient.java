package me.elendrial.cardGameBase.server;

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
		System.out.println("[Client]: Connecting to server at: " + computer + ":" + port);

		try (Socket socket = new Socket(computer, port);) {
			
			protocol.setupVars(socket);
			
			System.out.println("[Client]: Successfully connected to server");
			
			protocol.sendData("init");
			
			while(running){
				protocol.recieveData();
				Thread.sleep(1);
			}
			
		} catch (Exception e) {e.printStackTrace();}
	}

	@Override
	public void run() {
		running = true;
		connectToServer();
	}
	
	public static GameProtocol getProtocol(){
		return protocol;
	}

	public static String getHost() {
		return computer;
	}

	public static int getPort() {
		return port;
	}

	public static boolean isRunning() {
		return running;
	}
	
	
	
}
