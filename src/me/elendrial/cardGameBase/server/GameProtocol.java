package me.elendrial.cardGameBase.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public abstract class GameProtocol extends Thread{
	
//	private ServerSocket serverSocket;
	protected Socket socket;     
	
	protected PrintWriter out;                   
	protected BufferedReader in;
	
	protected int id;
	
	public GameProtocol(){}
	public GameProtocol(Socket socket, int id){
		this.socket = socket;
		this.id = id;
		try {
			setupVars();
			this.socket.setSoTimeout(0);
		} catch (IOException e) {
			System.err.println("Error with connection, closing connection");
			e.printStackTrace();
			try {
				socket.close();
			} catch (IOException e1) {e1.printStackTrace();}
		}
	}
	
	public void setupVars() throws IOException{
		this.out = new PrintWriter(socket.getOutputStream(), true); // Writing to what goes out of socket, not what comes out of socket.
		this.in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Reading what comes in from socket.
	}
	
	public void setupVars(Socket s) throws IOException{
		socket = s;
		this.out = new PrintWriter(socket.getOutputStream(), true); // Writing to what goes out of socket, not what comes out of socket.
		this.in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Reading what comes in from socket.
	}
	
	public abstract void sendData();
	
	public void sendData(String s){
		out.println(s);
	}
	
	public abstract void recieveData();
	
	public abstract void sendSetup();
	
	public abstract void recieveSetup();

	public abstract void disconnect(String message);
	
	public abstract void run();
	
}
