package dk.au.ase.asu.beertab.webserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleWebserver {

	
	private int port;
	private ServerSocket server;

	public SimpleWebserver(int port) {
		// TODO Auto-generated constructor stub
		this.port = port;
		try {
			this.server = new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void acceptLoop() {
		while(true){
			try {
				Socket sck = server.accept();
				HttpHandler handler = new HttpHandler(sck);
				handler.handleHttp();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleWebserver srv = new SimpleWebserver(9999);
		srv.acceptLoop();
	}

}
