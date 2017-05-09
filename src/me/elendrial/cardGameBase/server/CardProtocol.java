package me.elendrial.cardGameBase.server;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

@SuppressWarnings("unused")
public abstract class CardProtocol {
	
//	private ServerSocket serverSocket;
//	private Socket clientSocket;     
	
	private PrintWriter out;                   
	private BufferedReader in;
	
	public void setupVars(/*ServerSocket sSock, Socket cSock, */PrintWriter out, BufferedReader in){
//		serverSocket = sSock;
//		clientSocket = cSock;
		this.out = out;
		this.in = in;
	}
	
	public abstract void sendData();
	
	public void sendData(String s){
		out.println(s);
	}
	
	public abstract void recieveData();
	
	public abstract void sendSetup();
	
	public abstract void recieveSetup();

	public abstract void disconnect(String message);
	
}
