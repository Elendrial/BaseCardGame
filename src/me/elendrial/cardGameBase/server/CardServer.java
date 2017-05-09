package me.elendrial.cardGameBase.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class CardServer implements Runnable {
	
	private static int port;
	private static boolean running;
	private static CardProtocol protocol;
	
	public static void hostServer(int port, CardProtocol protocol){
		CardServer.port = port;
		CardServer.protocol = protocol;
		(new Thread(new CardServer())).start();
	}
	
	public static void closeServer(){
		protocol.disconnect("Server closed.");
		running = false;
	}
	
	private void hostServer(){
		System.out.println("Opening server on port: " + port);
		
		try (	ServerSocket serverSocket =	new ServerSocket(port);
				Socket clientSocket = serverSocket.accept();     
				
				PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);                   
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			) {
			
			protocol.setupVars(out, in);
			
			System.out.println("Server open and client " + clientSocket.getInetAddress().getHostName() + " has connected successfully");
			
			//protocol.
			
			while(running){
				// TODO: Check that this all works somehow, may need to make the basic hearthstone first, who knows?
				protocol.recieveData();
			}
			
		} catch (IOException e) {
			System.out.println("Exception caught when trying to listen on port "
					+ port + " or listening for a connection");
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void run() {
		running = true;
		hostServer();
	}
	
	public static int getPort(){return port;}
	
}
