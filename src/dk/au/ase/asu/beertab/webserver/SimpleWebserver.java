package dk.au.ase.asu.beertab.webserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleWebserver {

	private int threads = 100;
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
	
	public void acceptLoop() throws InterruptedException {
		ExecutorService pool = Executors.newScheduledThreadPool(threads);
	
		while(true){
			try {
				Socket sck = server.accept();
				HttpHandler handler = new HttpHandler(sck);
				//Thread traad = new Thread(handler);
				//traad.start();
				pool.execute(handler);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleWebserver srv = new SimpleWebserver(9999);
		try {
			srv.acceptLoop();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
