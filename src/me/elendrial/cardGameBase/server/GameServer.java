package me.elendrial.cardGameBase.server;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class GameServer implements Runnable {
	
	private static int port;
	public static boolean running;
	private static Class<? extends GameProtocol> protocolType;
	private static ArrayList<GameProtocol> connections = new ArrayList<GameProtocol>();
	
	public static void hostServer(int port, Class<? extends GameProtocol>  protocol){
		GameServer.port = port;
		GameServer.protocolType = protocol;
		(new Thread(new GameServer())).start();
	}
	
	public static void closeServer(){
		for(GameProtocol connection : connections) connection.disconnect("Server Closed.");
		running = false;
	}
	
	private void hostServer(){
		try(ServerSocket serverSocket = new ServerSocket(port)){
			while(running){
				System.out.println("[Server-Master]: Awaiting connection...");
				GameProtocol connection = protocolType.getDeclaredConstructor(Socket.class, int.class).newInstance(serverSocket.accept(), connections.size() != 0 ? connections.get(connections.size()-1).id+1 : 0);
				connection.start();
				System.out.println("[Server-Master]: Connection successful to " + connection.socket.getInetAddress());
				connections.add(connection);
			}
		} catch (IOException e) {
			System.err.println("Could not listen on port " + port);
			System.exit(-1);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		running = true;
		hostServer();
	}
	
	public static int getPort(){
		return port;
	}

	public static Class<? extends GameProtocol> getProtocolType(){
		return protocolType;
	}

	public static ArrayList<GameProtocol> getConnections() {
		return connections;
	}
	
	

	// Kept incase something goes wrong.
	/*
	private void hostServer(){
		System.out.println("[Server]: Opening server on port: " + port);
		
		try (	ServerSocket serverSocket =	new ServerSocket(port);
				Socket clientSocket = serverSocket.accept();     
				
				PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);                   
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			) {
			
			protocol.setupVars(out, in);
			
			System.out.println("[Server]: Server open and client " + clientSocket.getInetAddress().getHostName() + " has connected successfully");
			
			while(running){
				// TODO: Check that this all works somehow, may need to make the basic hearthstone first, who knows?
				protocol.recieveData();
				Thread.sleep(1);
			}
			
		} catch (IOException | InterruptedException e) {
			System.out.println("Exception caught when trying to listen on port "
					+ port + " or listening for a connection");
			System.out.println(e.getMessage());
		}
		
	}
*/
	
}
